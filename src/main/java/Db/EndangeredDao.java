package Db;

import model.Endangered;

import java.util.List;

public interface EndangeredDao {
    // list all heroes
    List<Endangered> getAllEndangeredAnimal();

    // create a new hero
    void addEndangered(Endangered endangered);

    // get a speciffic hero
    Endangered findEndangeredById(int id);

    // Delete a hero
    void deleteendangeredById( int id);

    // Update the hero
    void updateEngangeredById(int id);

    //Delete all heroes
    void deleteAllEndangered();
}
