package meyti.dogcheck.Model.RequestBody.Information.User;

import meyti.dogcheck.Model.Entity.Information;
import meyti.dogcheck.Model.Entity.User;

import javax.persistence.ManyToOne;

public class PostInformation {

    private String level;

    private String title;

    private String description;

    public Information getInformation(User creator)
    {
        Information information = new Information();
        information.setCreator(creator);
        information.setDescription(description);
        information.setLevel(level);
        information.setTitle(title);
        return information;
    }

    public String getLevel() {
        return level;
    }

    public PostInformation setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostInformation setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PostInformation setDescription(String description) {
        this.description = description;
        return this;
    }
}
