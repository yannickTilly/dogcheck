package meyti.dogcheck.Model.RequestBody.WalkPointUser;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Walk;
import meyti.dogcheck.Model.Entity.WalkPoint;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class PostWalkpoint {

    private float latitude;
    private float longitude;
    private long walkId;

    public WalkPoint getWalkpoint()
    {
        WalkPoint walkPoint = new WalkPoint();
        walkPoint.setDate(LocalDate.now());
        walkPoint.setLatitude(latitude);
        walkPoint.setLongitude(longitude);
        return walkPoint;
    }


    public float getLatitude() {
        return latitude;
    }

    public PostWalkpoint setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public PostWalkpoint setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }
}
