package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {


    @Test
    public void getNameReturnsCorrectName_String() {
        Animal newAnimal = setNewAnimal();
        assertEquals("Zebra", newAnimal.getName());
    }

    // the helper classes.

     public Animal setNewAnimal(){
        return new Animal("Zebra");
     }

}