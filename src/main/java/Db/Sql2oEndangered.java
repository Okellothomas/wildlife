package Db;

import model.Endangered;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oEndangered implements EndangeredDao {

    // initialize Sql2o
    private final Sql2o sql2o;

    public Sql2oEndangered(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void create() {

    }

    @Override
    public List<Endangered> getAllEndangeredAnimal() {
        return null;
    }

    @Override
    public void addEndangered(Endangered endangered) {

    }

    @Override
    public Endangered findEndangeredById(int id) {
        return null;
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
