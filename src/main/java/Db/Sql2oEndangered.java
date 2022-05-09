package Db;

import model.Endangered;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEndangered implements EndangeredDao {

    // initialize Sql2o
    private final Sql2o sql2o;

    public Sql2oEndangered(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create() {

    }

    @Override
    public List<Endangered> getAllEndangeredAnimal() {
        getDrivers();
        String sql = "SELECT * FROM endangered";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Endangered.class);
        }
    }

    @Override
    public void addEndangered(Endangered endangered) {
        getDrivers();
        String sql = "INSERT INTO endangered (name,type,health,age) VALUES (:name,:type,:health,:age)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(endangered)
                    .executeUpdate()
                    .getKey();
            endangered.setId(id);
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public Endangered findEndangeredById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangered WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Endangered.class);
        }
    }

    @Override
    public void deleteendangeredById(int id) {

    }

    @Override
    public void updateEngangeredById(int id) {

    }

    @Override
    public void deleteAllEndangered() {

    }

    @Override
    public void update(String name, String health, String age) {

    }
}
