package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name = "User")
public class User {

    @Id
    @JsonView({Master.Dog.class, Master.User.class})
    private  long id;

    @JsonView({Master.Dog.class, Master.User.class})
    private String name;

    // photo

    @JsonView({Master.Dog.class, Master.User.class})
    private String mailMessenger;


    @JsonView({Master.User.class, Master.Dog.class})
    private String phoneNumber;

    @JsonView(Master.User.class)
    private String instagramLink;

    @JsonView({Master.Dog.class, Master.User.class})
    private String statut;

    @OneToMany(targetEntity = Dog.class, mappedBy = "master")
    @JsonView(Master.User.class)
    private Collection<Dog> dogs;

    private String login;

    private String password;

    private float latitude;

    private float longitude;

    private Date localisationDate;

    private String role;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

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
