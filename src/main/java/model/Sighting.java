package model;

import java.util.Objects;

public class Sighting {
    private String name;
    private String location;
    private int id;
    private int animId;
    private int endangeredId;

    public Sighting(String name, String location, int id, int animId, int endangeredId) {
        this.name = name;
        this.location = location;
        this.animId = animId;
        this.endangeredId = endangeredId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimId() {
        return animId;
    }

    public void setAnimId(int animId) {
        this.animId = animId;
    }

    public int getEndangeredId() {
        return endangeredId;
    }

    public void setEndangeredId(int endangeredId) {
        this.endangeredId = endangeredId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return id == sighting.id &&
                animId == sighting.animId &&
                endangeredId == sighting.endangeredId &&
                Objects.equals(name, sighting.name) &&
                Objects.equals(location, sighting.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, id, animId, endangeredId);
    }
}
