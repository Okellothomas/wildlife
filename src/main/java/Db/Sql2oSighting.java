package Db;

import model.Sighting;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oSighting implements SightingDao {

    // initialize Sql2o
    private final Sql2o sql2o;

    public Sql2oSighting(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void create() {

    }

    @Override
    public List<Sighting> getAllSighting() {
        return null;
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
