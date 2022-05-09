package Db;

import model.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oSighting implements SightingDao {

    // initialize Sql2o
    private final Sql2o sql2o;

    public Sql2oSighting(Sql2o sql2o) {
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
    public List<Sighting> getAllSighting() {
        getDrivers();
        String sql = "SELECT * FROM sightings";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }
    }

    @Override
    public void addSighting(Sighting sighting) {

    }

    @Override
    public void update(int id, String location, String name, int animalid) {

    }

    @Override
    public Sighting findSightingById(int id) {
        return null;
    }

    @Override
    public Sighting deleteById() {
        return null;
    }

    @Override
    public Sighting deleteAllSigting() {
        return null;
    }
}
