package model;

import java.util.Objects;

public class Animal {

    public static final String animal_type = "non-endangered";
    public String name;
    public int id;
    public String animaltype;

    public Animal(String name) {
        this.name = name;
        this.animaltype = animal_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                Objects.equals(name, animal.name) &&
                Objects.equals(animaltype, animal.animaltype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, animaltype);
    }
}
