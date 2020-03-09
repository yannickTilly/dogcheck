package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    @Column(name = "ID")
    @JsonView({})
    private long id;

    @ManyToOne(targetEntity = User.class)
    private User creator;

    @ManyToMany(targetEntity = User.class)
    private Collection<User> participants;

    private LocalDate startDate;

    private LocalDate endDate;

    private float longitute;

    private float latitude;

    private String description;

    public long getId() {
        return id;
    }

    public Event setId(long id) {
        this.id = id;
        return this;
    }

    public User getCreator() {
        return creator;
    }

    public Event setCreator(User creator) {
        this.creator = creator;
        return this;
    }

    public Collection<User> getParticipants() {
        return participants;
    }

    public Event setParticipants(Collection<User> participants) {
        this.participants = participants;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Event setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Event setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public float getLongitute() {
        return longitute;
    }

    public Event setLongitute(float longitute) {
        this.longitute = longitute;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public Event setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }
}
