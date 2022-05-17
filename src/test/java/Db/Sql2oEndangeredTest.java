//package Db;
//
//import model.Endangered;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.sql2o.Sql2o;
//
//import java.sql.Connection;
//
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertTrue;
//import static org.junit.Assert.assertNotEquals;
//
//public class Sql2oEndangeredTest {
//
//    private Sql2oEndangered endangeredDo;
//    private Connection connection;
//
//    @Before
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_trackers_test";
//        Sql2o sql2o = new Sql2o(connectionString,"postgres","okello");
//        endangeredDo = new Sql2oEndangered(sql2o);
//        connection = (Connection) sql2o.open();
//    }
//
//    @Test
//    public void addingEndangeredSetsId() throws Exception {
//        Endangered endangered = setNewEndangered();
//        int originalEndangeredId = endangered.getId();
//        endangeredDo.addEndangered(endangered);
//        assertNotEquals(originalEndangeredId, endangered.getId());
//    }
//
//    @Test
//    public void existingAnimalCanBeFoundById() throws Exception {
//        Endangered endangered = setNewEndangered();
//        endangeredDo.addEndangered(endangered);
//        Endangered foundEndangered = endangeredDo.findEndangeredById(endangered.getId());
//        assertEquals(endangered, foundEndangered);
//    }
//
//    @Test
//    public void deleteByIdDeletesCorrectEndangered() throws Exception {
//        Endangered endangered = new Endangered("Cat", "Endangered", "Okey", "10");
//        endangeredDo.addEndangered(endangered);
//        endangeredDo.deleteendangeredById(endangered.getId());
//        assertEquals(0,endangeredDo.getAllEndangeredAnimal().size());
//    }
//
//    @Test
//    public void clearAllEndangered() throws Exception {
//        Endangered endangered = setNewEndangered();
//        Endangered endangered1 = new Endangered("Cat", "Endangered", "Okey", "10");
//        endangeredDo.addEndangered(endangered);
//        endangeredDo.addEndangered(endangered1);
//        int sizeOfDao = endangeredDo.getAllEndangeredAnimal().size();
//        endangeredDo.deleteAllEndangered();
//        assertTrue(sizeOfDao > 0 && sizeOfDao >endangeredDo.getAllEndangeredAnimal().size());
//    }
//
//
//    // helper classes
//    public Endangered setNewEndangered(){
//        return new Endangered("Tiger","Endanger","ill", "42");
//    }
//
//
//    @After
//    public void tearDown() throws Exception {
//    }
//}