import Db.Sql2oAnimal;
import Db.Sql2oEndangered;
import Db.Sql2oSighting;
import model.Animal;
import model.Endangered;
import model.Sighting;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        // create a connection:
//        String connectionString = "jdbc:postgresql://ec2-18-210-233-138.compute-1.amazonaws.com:5432/dcusbo64al2pmk?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
//        Sql2o sql2o = new Sql2o(connectionString,"kyzdcepzltqodh","7b09db0492c0fed51d36f6f5931bd587e13a6c8eb824707660118eb10b679ace");

        String connect =  "jdbc:postgresql://localhost/wildlife_trackers";
        Sql2o sql2o = new Sql2o(connect,"postgres","okello");

        Sql2oAnimal animalDao = new Sql2oAnimal(sql2o);
        Sql2oEndangered endangeredDao = new Sql2oEndangered(sql2o);
        Sql2oSighting sightingDao = new Sql2oSighting(sql2o);

        staticFileLocation("/public");
        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> allAnimal = animalDao.getAllAnimal();
            model.put("animal",allAnimal);
            List<Endangered> allEndangeredAnimal = endangeredDao.getAllEndangeredAnimal();
            model.put("endangered",allEndangeredAnimal);
            List<Sighting> allSightings = sightingDao.getAllSighting();
            model.put("sighting", allSightings);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        //display form to create a new endangered
        get("/endangered/new",(request,response)->{
            Map<String, Object>model = new HashMap<>();
            List<Endangered> endangereds = endangeredDao.getAllEndangeredAnimal();
            model.put("endangered",endangereds);
            return new ModelAndView(model,"newendanger.hbs");
        },new HandlebarsTemplateEngine());

        //process new squad
        post("/endangered",(request,response)->{
            Map<String, Object>model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            String type = request.queryParams("type");
            Endangered endangered = new Endangered(name, age, health, type);
            endangeredDao.addEndangered(endangered);
            response.redirect("endanger.hbs");
            return null;
        },new HandlebarsTemplateEngine());

        get("/endangered",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Animal> allAnimal = animalDao.getAllAnimal();
//            model.put("animal",allAnimal);
            List<Endangered> allEndangeredAnimal = endangeredDao.getAllEndangeredAnimal();
            model.put("endangered",allEndangeredAnimal);
//            List<Sighting> allSightings = sightingDao.getAllSighting();
//            model.put("sighting", allSightings);
            return new ModelAndView(model,"endanger.hbs");
        },new HandlebarsTemplateEngine());

        //clear all endangered
        get("/endengered/delete",(request, response)->{
            Map<String,Object>model = new HashMap<>();
            endangeredDao.deleteAllEndangered();
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //clear all animals
        get("/animal/delete",(request, response)->{
            Map<String,Object>model = new HashMap<>();
            animalDao.deleteAllAnimal();
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //clear all sighting
        get("/sightings/delete",(request, response)->{
            Map<String,Object>model = new HashMap<>();
            sightingDao.deleteAllSigting();
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());


        get("/endangered/:id",(request,response)->{
            Map<String,Object>model = new HashMap<>();
            int endangeredToFindId = Integer.parseInt(request.params("id"));
            Endangered endangered = endangeredDao.findEndangeredById(endangeredToFindId);
            model.put("endangered",endangeredDao.getAllEndangeredAnimal());
            return new ModelAndView(model,"endanger.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/",(request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            List<Animal> allAnimal = animalDao.getAllAnimal();
//            model.put("animal",allAnimal);
//            List<Endangered> allEndangeredAnimal = endangeredDao.getAllEndangeredAnimal();
//            model.put("endangered",allEndangeredAnimal);
//            List<Sighting> allSightings = sightingDao.getAllSighting();
//            model.put("sighting", allSightings);
//            return new ModelAndView(model,"index.hbs");
//        },new HandlebarsTemplateEngine());

        //display form to create a new animal
        get("/animal/new",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = animalDao.getAllAnimal();
            model.put("animal",animals);
            return new ModelAndView(model,"newanimal.hbs");
        },new HandlebarsTemplateEngine());

        //display form to create a new animal
        get("/sighting/new",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = sightingDao.getAllSighting();
            model.put("sighting",sightings);
            return new ModelAndView(model,"newsighting.hbs");
        },new HandlebarsTemplateEngine());
    }

}
