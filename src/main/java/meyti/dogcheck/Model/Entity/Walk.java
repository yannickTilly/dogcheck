package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;

@Entity
@Table(name = "Walk")
public class Walk {
    @Id
    @Column(name = "ID")
    @JsonView({})
    private long id;

    private String title;

    private String description;

    private float latitude;

    private float longitude;

    private boolean isPublic;

    @ManyToOne(targetEntity = User.class)
    public User walker;

    public long getId() {
        return id;
    }

    public Walk setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Walk setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Walk setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public Walk setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public Walk setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public Walk setPublic(boolean aPublic) {
        isPublic = aPublic;
        return this;
    }

    public User getWalker() {
        return walker;
    }

    public Walk setWalker(User walker) {
        this.walker = walker;
        return this;
    }
}
