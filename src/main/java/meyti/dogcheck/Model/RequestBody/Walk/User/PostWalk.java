package meyti.dogcheck.Model.RequestBody.Walk.User;

import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Entity.Walk;

import javax.persistence.ManyToOne;

public class PostWalk {

    private String title;

    private String description;

    private float latitude;

    private float longitude;

    private boolean isPublic;

    public Walk getWalk(User walker)
    {
        Walk walk = new Walk();
        walk.setWalker(walker);
        walk.setDescription(description);
        walk.setLatitude(latitude);
        walk.setLongitude(longitude);
        walk.setPublic(isPublic);
        walk.setTitle(title);
        return walk;
    }

    public String getTitle() {
        return title;
    }

    public PostWalk setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PostWalk setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public PostWalk setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public PostWalk setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public PostWalk setPublic(boolean aPublic) {
        isPublic = aPublic;
        return this;
    }
}
