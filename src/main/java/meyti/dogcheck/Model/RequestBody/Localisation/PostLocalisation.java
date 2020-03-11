package meyti.dogcheck.Model.RequestBody.Localisation;

public class PostLocalisation {
    private float latitude;
    private float longitude;

    public float getLatitude() {
        return latitude;
    }

    public PostLocalisation setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public PostLocalisation setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }
}
