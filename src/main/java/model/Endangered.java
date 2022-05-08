package model;

import java.util.Objects;

public class Endangered extends Animal{
    // add variables to class
    private static final String Animal_Type = "Endangered_Animal";
    private String health;
    private String age;

    public Endangered(String name, String health, String age) {
        super(name);
        this.health = health;
        this.age = age;
        this.animaltype = Animal_Type;
    }

    public static String getAnimal_Type() {
        return Animal_Type;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Endangered that = (Endangered) o;
        return Objects.equals(health, that.health) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), health, age);
    }
}
