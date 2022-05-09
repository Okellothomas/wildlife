package Db;

import model.Animal;
import model.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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
        String sql = "SELECT * FROM Animals WHERE animaltype";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Animal.class);
        }
    }

    @Override
    public void addAnimal(Animal animal) {

    }

    @Override
    public Animal findAnimalById(int id) {
        return null;
    }

    @Override
    public void deleteAnimalById(int id) {

    }

    @Override
    public void updateAnimalById(int id) {

    }

    @Override
    public void deleteAllAnimal() {

    }

    @Override
    public List<Sighting> findsighting() {
        return null;
    }

    @Override
    public void update(String name) {

    }
}
