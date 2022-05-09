package Db;

import model.Endangered;

import java.util.List;

public interface EndangeredDao {

    // create an endangered animal
    void create();
    // list all endangeredAnimals
    List<Endangered> getAllEndangeredAnimal();

    // create a new endangeredAnimals
    void addEndangered(Endangered endangered);

    // get a specific endangered animal
    Endangered findEndangeredById(int id);

    // Delete an endangered animal
    void deleteendangeredById( int id);

    // Update the endangered animal
    void updateEngangeredById(int id);

    //Delete all endangered animals
    void deleteAllEndangered();

    void update(String name, String health, String age);

    // more methods will added with time.

}
