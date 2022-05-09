package Db;

import model.Sighting;

import java.util.List;

public interface SightingDao {

    // create new sighting
    void create();
    // list all sighting
    List<Sighting> getAllSighting();

    // create a new sighting
    void addSighting(Sighting sighting);

    // update the sighting
    void update(int id, String location, String name, int animalid);

    // get a specific sighting
    Sighting findSightingById(int id);

    // delete by id
    Sighting deleteById();

    // delete all sightings.
    Sighting deleteAllSigting();

    // more methods will added as the application grows.

}
