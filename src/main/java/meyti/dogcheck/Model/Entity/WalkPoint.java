package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WalkPoint")
public class WalkPoint {

    @Id
    @Column(name = "ID")
    @JsonView({Master.WalkPoint.class})
    private long id;

    @JsonView({Master.WalkPoint.class, Master.Walk.class})
    private float latitude;

    @JsonView({Master.WalkPoint.class, Master.Walk.class})
    private float longitude;

    @JsonView({Master.WalkPoint.class, Master.Walk.class})
    private LocalDate date;

    @ManyToOne(targetEntity = Walk.class)
    private Walk walk;

    public long getId() {
        return id;
    }

    public WalkPoint setId(long id) {
        this.id = id;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public WalkPoint setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public WalkPoint setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public WalkPoint setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Walk getWalk() {
        return walk;
    }

    public WalkPoint setWalk(Walk walk) {
        this.walk = walk;
        return this;
    }
}
