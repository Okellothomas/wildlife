package Db;

import model.Sighting;

import java.util.List;

public interface SightingDao {

    // list all sighting
    List<Sighting> getAllSighting();

    // create a new sighting
    void addSighting(Sighting sighting);

    // get a specific sighting
    Sighting findSightingById(int id);

    // more methods will added as the application grows.
}
