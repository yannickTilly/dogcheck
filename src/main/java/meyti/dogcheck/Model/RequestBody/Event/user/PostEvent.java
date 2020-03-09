package meyti.dogcheck.Model.RequestBody.Event.user;

import meyti.dogcheck.Model.Entity.Event;
import meyti.dogcheck.Model.Entity.User;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Collection;

public class PostEvent {
    private LocalDate startDate;

    private LocalDate endDate;

    private float longitute;

    private float latitude;

    private String description;

    public Event getEvent(User creator) {
        Event event = new Event();
        event.setCreator(creator);
        event.setDescription(description);
        event.setEndDate(endDate);
        event.setStartDate(startDate);
        event.setLatitude(latitude);
        event.setLongitute(longitute);
        return event;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public PostEvent setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public PostEvent setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public float getLongitute() {
        return longitute;
    }

    public PostEvent setLongitute(float longitute) {
        this.longitute = longitute;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public PostEvent setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PostEvent setDescription(String description) {
        this.description = description;
        return this;
    }
}
