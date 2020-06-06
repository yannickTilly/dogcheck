package meyti.dogcheck.Model.RequestBody.Tracker.User;

public class Tracker {
    float latitude;
    float longitude;

    public float getLatitude() {
        return latitude;
    }

    public Tracker setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public Tracker setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }
}
