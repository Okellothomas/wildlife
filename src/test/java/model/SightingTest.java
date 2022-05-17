//package model;
//
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class SightingTest {
//
//    @Test
//    public void getNameReturnsCorrectName_String() throws Exception {
//        Sighting newSighting = setNewSighting();
//        assertEquals("John", newSighting.getName());
//    }
//
//    @Test
//    public void getNameReturnsCorrectLocation_String() {
//        Sighting newSighting = setNewSighting();
//        assertEquals("River", newSighting.getLocation());
//    }
//
//    @Test
//    public void getNameReturnsCorrectAnimal_int() {
//        Sighting newSighting = setNewSighting();
//        assertEquals(34, newSighting.getAnimId());
//    }
//
//    @Test
//    public void getNameReturnsCorrectEndangered_int() {
//        Sighting newSighting = setNewSighting();
//        assertEquals(21, newSighting.getEndangeredId());
//    }
//
//    // the helper classes
//
//    public Sighting setNewSighting(){
//        return new Sighting("John", "River", 34, 21);
//    }
//
//}