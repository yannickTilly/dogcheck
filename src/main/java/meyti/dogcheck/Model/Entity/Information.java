package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;

@Entity
@Table(name = "Information")
public class Information {
    @Id
    @Column(name = "ID")
    @JsonView({})
    private long id;

    private String level;

    private String title;

    private String description;

    @ManyToOne(targetEntity = User.class)
    private User creator;

    public long getId() {
        return id;
    }

    public Information setId(long id) {
        this.id = id;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public Information setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Information setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Information setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getCreator() {
        return creator;
    }

    public Information setCreator(User creator) {
        this.creator = creator;
        return this;
    }
}
