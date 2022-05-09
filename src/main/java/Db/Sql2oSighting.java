package Db;

import model.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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
        getDrivers();
        String sql = "INSERT INTO sightings (name,location,animId,endangeredId) VALUES (:name,:location,:animId,:endangeredId)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(sighting)
                    .executeUpdate()
                    .getKey();
            sighting.setId(id);
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void update(int id, String location, String name, int animalid) {

    }

    @Override
    public Sighting findSightingById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM sightings WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
        }
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
