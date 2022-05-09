package Db;

import model.Animal;
import model.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAnimal implements AnimalDao {

    // initialize Sql2o
    private final Sql2o sql2o;

    public Sql2oAnimal(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create() {

    }

    @Override
    public List<Animal> getAllAnimal() {
        getDrivers();
        String sql = "SELECT * FROM animals";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Animal.class);
        }
    }
    @Override
    public void addAnimal(Animal animal) {
        getDrivers();
        String sql = "INSERT INTO animals (name) VALUES (:name)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(animal)
                    .executeUpdate()
                    .getKey();
            animal.setId(id);
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public Animal findAnimalById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM animals WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
        }
    }

    @Override
    public void deleteAnimalById(int id) {
        getDrivers();
        String sql = "DELETE FROM animals WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void updateAnimalById(int id) {

    }

    @Override
    public void deleteAllAnimal() {
        getDrivers();
        String sql = "DELETE from animals";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<Sighting> findsighting() {
        return null;
    }

    @Override
    public void update(String name) {
        getDrivers();
        String sql = "UPDATE animals SET (name) VALUES (:name)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .executeUpdate()
                    .getKey();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }
}
