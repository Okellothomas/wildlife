//package Db;
//
//import model.Sighting;
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
//public class Sql2oSightingTest {
//
//    private Sql2oSighting sightingDao;
//    private Connection connection;
//
//    @Before
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_trackers_test";
//        Sql2o sql2o = new Sql2o(connectionString,"postgres","okello");
//        sightingDao = new Sql2oSighting(sql2o);
//        connection = (Connection) sql2o.open();
//    }
//
//    @Test
//    public void addingSightingSetsId() throws Exception {
//        Sighting sighting = setNewSighting();
//        int originalSightingId = sighting.getId();
//        sightingDao.addSighting(sighting);
//        assertNotEquals(originalSightingId, sighting.getId());
//    }
//
//    @Test
//    public void existingSightingCanBeFoundById() throws Exception {
//        Sighting sighting = setNewSighting();
//        sightingDao.addSighting(sighting);
//        Sighting foundSighting = sightingDao.findSightingById(sighting.getId());
//        assertEquals(sighting, foundSighting);
//    }
//
//    @Test
//    public void deleteByIdDeletesCorrectSighting() throws Exception {
//        Sighting sighting = new  Sighting("John", "River", 34, 21);
//        sightingDao.addSighting(sighting);
//        sightingDao.deleteById(sighting.getId());
//        assertEquals(0,sightingDao.getAllSighting().size());
//    }
//
//    @Test
//    public void clearAllSighting() throws Exception {
//        Sighting sighting = setNewSighting();
//        Sighting sighting1 = new  Sighting("John", "River", 34, 21);
//        sightingDao.addSighting(sighting);
//        sightingDao.addSighting(sighting1);
//        int sizeOfDao = sightingDao.getAllSighting().size();
//        sightingDao.deleteAllSigting();
//        assertTrue(sizeOfDao > 0 && sizeOfDao >sightingDao.getAllSighting().size());
//    }
//
//    // the helper classes
//
//    public Sighting setNewSighting(){
//        return new Sighting("John", "River", 34, 21);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//}