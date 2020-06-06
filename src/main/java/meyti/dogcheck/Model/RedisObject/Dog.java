package meyti.dogcheck.Model.RedisObject;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

public class Dog {
    @JsonView(Master.User.class)
    String name;

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }
}
