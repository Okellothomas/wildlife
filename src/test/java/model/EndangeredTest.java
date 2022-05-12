package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredTest {


    @Test
    public void getNameReturnsCorrectName_String() throws Exception {
        Endangered newEndangered = setNewEndangered();
        assertEquals("Tiger", newEndangered.getName());
    }

    @Test
    public void getNameReturnsCorrectType_String() {
        Endangered newEndangered = setNewEndangered();
        assertEquals("Endanger", newEndangered.getType());
    }

    @Test
    public void getNameReturnsCorrectHealth_String() {
        Endangered newEndangered = setNewEndangered();
        assertEquals("ill", newEndangered.getHealth());
    }

    @Test
    public void getNameReturnsCorrectAge_String() {
        Endangered newEndangered = setNewEndangered();
        assertEquals("42", newEndangered.getAge());
    }

    // helper classes
    public Endangered setNewEndangered(){
        return new Endangered("Tiger","Endanger","ill", "42");
    }

}