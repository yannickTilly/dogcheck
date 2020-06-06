package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Walk")
public class Walk {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({Master.Walk.class})
    private Long id;

    @JsonView({Master.Walk.class})
    private String title;

    @JsonView({Master.Walk.class})
    private String description;

    @JsonView({Master.Walk.class})
    private float latitude;

    @JsonView({Master.Walk.class})
    private float longitude;

    @JsonView({Master.Walk.class})
    private boolean isPublic;

    @ManyToOne(targetEntity = User.class)
    @JsonView({Master.Walk.class})
    private User walker;

    @OneToMany(targetEntity = WalkPoint.class, mappedBy = "walk")
    @JsonView({Master.Walk.class})
    private Collection<WalkPoint> walkPoints;

    public Collection<WalkPoint> getWalkPoints() {
        return walkPoints;
    }

    public Walk setWalkPoints(Collection<WalkPoint> walkPoints) {
        this.walkPoints = walkPoints;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Walk setId(Long id) {
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
