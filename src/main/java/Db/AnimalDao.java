package Db;

import model.Animal;

import java.util.List;

public interface AnimalDao {

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

    // more methods will be added with time.
}
