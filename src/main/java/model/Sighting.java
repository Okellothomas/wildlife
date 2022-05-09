package model;

import java.util.Objects;

public class Sighting {
    private String name;
    private String location;
    private int id;
    private String animId;
    private String endangeredId;

    public Sighting(String name, String location, int id, String animId, String endangeredId) {
        this.name = name;
        this.location = location;
        this.id = id;
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

    public String getAnimId() {
        return animId;
    }

    public void setAnimId(String animId) {
        this.animId = animId;
    }

    public String getEndangeredId() {
        return endangeredId;
    }

    public void setEndangeredId(String endangeredId) {
        this.endangeredId = endangeredId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return id == sighting.id &&
                Objects.equals(name, sighting.name) &&
                Objects.equals(location, sighting.location) &&
                Objects.equals(animId, sighting.animId) &&
                Objects.equals(endangeredId, sighting.endangeredId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, id, animId, endangeredId);
    }
}
