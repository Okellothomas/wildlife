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

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

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
    }
}
