package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;

@Entity
@Table(name = "Information")
public class Report {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({Master.Report.class})
    private Long id;

    @JsonView({Master.Report.class})
    private String level;

    @JsonView({Master.Report.class})
    private String title;

    @JsonView({Master.Report.class})
    private String description;

    @JsonView({Master.Report.class})
    private float latitude;

    @JsonView({Master.Report.class})
    private float longitude;

    @JsonView({Master.Report.class})
    @ManyToOne(targetEntity = User.class)
    private User creator;


    public float getLatitude() {
        return latitude;
    }

    public Report setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public Report setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Report setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public Report setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Report setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Report setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getCreator() {
        return creator;
    }

    public Report setCreator(User creator) {
        this.creator = creator;
        return this;
    }
}
