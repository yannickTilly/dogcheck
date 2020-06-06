package meyti.dogcheck.Model.RequestBody.Report.User;

import meyti.dogcheck.Model.Entity.Report;
import meyti.dogcheck.Model.Entity.User;

public class PostReport {

    private String level;

    private String title;

    private String description;

    private float latitude;

    private float longitude;

    public float getLatitude() {
        return latitude;
    }

    public PostReport setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public PostReport setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public Report getInformation(User creator)
    {
        Report report = new Report();
        report.setCreator(creator);
        report.setDescription(description);
        report.setLevel(level);
        report.setTitle(title);
        report.setLatitude(latitude);
        report.setLongitude(longitude);
        return report;
    }

    public String getLevel() {
        return level;
    }

    public PostReport setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostReport setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PostReport setDescription(String description) {
        this.description = description;
        return this;
    }
}
