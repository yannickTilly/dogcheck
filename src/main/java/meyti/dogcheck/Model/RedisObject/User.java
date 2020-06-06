package meyti.dogcheck.Model.RedisObject;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User {
    @JsonView(Master.User.class)
    float latitude;

    @JsonView(Master.User.class)
    float longitude;

    @JsonView(Master.User.class)
    String id;

    @JsonView(Master.User.class)
    String idSql;

    @JsonView(Master.User.class)
    List<Dog> dogs;


    public List<Dog> getDogs() {
        return dogs;
    }

    public User setDogs(List<Dog> dogs) {
        this.dogs = dogs;
        return this;
    }

    public User() {
        dogs = new ArrayList<>();
    }

    public String getIdSql() {
        return idSql;
    }

    public User setIdSql(String idSql) {
        this.idSql = idSql;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public User setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public User setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }
}
