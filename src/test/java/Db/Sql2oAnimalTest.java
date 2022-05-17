//package Db;
//
//import model.Animal;
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
//public class Sql2oAnimalTest {
//
//    private Sql2oAnimal animalDao;
//    private Connection connection;
//
//    @Before
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_trackers_test";
//        Sql2o sql2o = new Sql2o(connectionString,"postgres","okello");
//        animalDao = new Sql2oAnimal(sql2o);
//        connection = (Connection) sql2o.open();
//    }
//
//    @Test
//    public void addingAnimalSetsId() throws Exception {
//        Animal animal = setNewAnimal();
//        int originalAnimalId = animal.getId();
//        animalDao.addAnimal(animal);
//        assertNotEquals(originalAnimalId, animal.getId());
//    }
//
//    @Test
//    public void existingAnimalCanBeFoundById() throws Exception {
//        Animal animal = setNewAnimal();
//        animalDao.addAnimal(animal);
//        Animal foundAnimal = animalDao.findAnimalById(animal.getId());
//        assertEquals(animal, foundAnimal);
//    }
//
//    @Test
//    public void deleteByIdDeletesCorrectAnimal() throws Exception {
//        Animal animal = new Animal("Zebra");
//        animalDao.addAnimal(animal);
//        animalDao.deleteAnimalById(animal.getId());
//        assertEquals(0,animalDao.getAllAnimal().size());
//    }
//
//
//
//    @Test
//    public void clearAllAnimal() throws Exception {
//        Animal animal = setNewAnimal();
//        Animal animal1 = new Animal("Zebra");
//        animalDao.addAnimal(animal);
//        animalDao.addAnimal(animal1);
//        int sizeOfDao = animalDao.getAllAnimal().size();
//        animalDao.deleteAllAnimal();
//        assertTrue(sizeOfDao > 0 && sizeOfDao >animalDao.getAllAnimal().size());
//    }
//
//    public Animal setNewAnimal(){
//        return new Animal("Zebra");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        connection.close();
//    }
//}