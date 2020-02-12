package meyti.dogcheck.Model.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;

public class User {

    private String name;

    // photo

    private String mailMessenger;

    private String phoneNumber;

    private String instagramLink;

    private String statut;

    private Collection<Dog> dogs;

    private float latitude;

    private float longitude;

    private Date localisationDate;

    public Date getLocalisationDate() {
        return localisationDate;
    }

    public User setLocalisationDate(Date localisationDate) {
        this.localisationDate = localisationDate;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public User setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public User setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getMailMessenger() {
        return mailMessenger;
    }

    public User setMailMessenger(String mailMessenger) {
        this.mailMessenger = mailMessenger;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public User setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
        return this;
    }

    public String getStatut() {
        return statut;
    }

    public User setStatut(String statut) {
        this.statut = statut;
        return this;
    }

    public Collection<Dog> getDogs() {
        return dogs;
    }

    public User setDogs(Collection<Dog> dogs) {
        this.dogs = dogs;
        return this;
    }
}
