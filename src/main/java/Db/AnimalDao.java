package Db;

import model.Animal;
import model.Sighting;

import java.util.List;

public interface AnimalDao {

    // create an animal
    void create();
    // list all Animal
    List<Animal> getAllAnimal();

    // create a new Animal
    void addAnimal(Animal animal);

    // get a specific Animal
    Animal findAnimalById(int id);

    // Delete an animal
    void deleteAnimalById( int id);

    // Update the animal
    void updateAnimalById(int id);

    //Delete all animal
    void deleteAllAnimal();

    List<Sighting> findsighting ();

    void update(String name);

    // more methods will be implemented below;
}
