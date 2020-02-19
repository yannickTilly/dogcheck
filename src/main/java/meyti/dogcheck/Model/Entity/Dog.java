package meyti.dogcheck.Model.Entity;

import javax.persistence.*;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

@Entity
@Table(name = "Dog")
public class Dog {

    @Id
    @Column(name = "ID")
    @JsonView({Master.Dog.class, Master.User.class, Master.Affinity.class})
    private long id;

    @JsonView({Master.Dog.class, Master.User.class, Master.Affinity.class})
    private String name;

    @JsonView({Master.Dog.class, Master.User.class, Master.Affinity.class})
    private String race;

    @JsonView({Master.Dog.class, Master.User.class, Master.Affinity.class})
    private String sex;

    @JsonView({Master.Dog.class, Master.User.class, Master.Affinity.class})
    private Integer age;

    @JsonView({Master.Dog.class, Master.User.class, Master.Affinity.class})
    private String size;

    @JsonView({Master.Dog.class, Master.User.class, Master.Affinity.class})
    private Boolean sterilised;

    @JsonView(Master.Dog.class)
    private Boolean maleSterilisedFriendly;

    @JsonView(Master.Dog.class)
    private Boolean femaleSterilisedFriendly;

    @JsonView(Master.Dog.class)
    private Boolean smallDogFriendly;

    @JsonView(Master.Dog.class)
    private Boolean mediumDogFriendly;

    @JsonView(Master.Dog.class)
    private Boolean largeDogFriendly;

    @JsonView(Master.Dog.class)
    private Boolean extraLargeDogFriendly;

    @JsonView(Master.Dog.class)
    private Boolean maleFriendly;

    @JsonView(Master.Dog.class)
    private Boolean femaleFriendly;

    @OneToMany(targetEntity = Affinity.class, mappedBy = "receiver")
    private Collection<Affinity> recievedAffinities;

    @OneToMany(targetEntity = Affinity.class, mappedBy = "sender")
    private Collection<Affinity> sentAffinities;

    @ManyToOne(targetEntity = User.class)
    @JsonView({Master.Dog.class, Master.Affinity.class})
    private User master;

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public String getRace() {
        return race;
    }

    public Dog setRace(String race) {
        this.race = race;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Dog setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Dog setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Dog setSize(String size) {
        this.size = size;
        return this;
    }

    public Boolean getSterilised() {
        return sterilised;
    }

    public Dog setSterilised(Boolean sterilised) {
        this.sterilised = sterilised;
        return this;
    }

    public Boolean getMaleSterilisedFriendly() {
        return maleSterilisedFriendly;
    }

    public Dog setMaleSterilisedFriendly(Boolean maleSterilisedFriendly) {
        this.maleSterilisedFriendly = maleSterilisedFriendly;
        return this;
    }

    public Boolean getFemaleSterilisedFriendly() {
        return femaleSterilisedFriendly;
    }

    public Dog setFemaleSterilisedFriendly(Boolean femaleSterilisedFriendly) {
        this.femaleSterilisedFriendly = femaleSterilisedFriendly;
        return this;
    }

    public Boolean getSmallDogFriendly() {
        return smallDogFriendly;
    }

    public Dog setSmallDogFriendly(Boolean smallDogFriendly) {
        this.smallDogFriendly = smallDogFriendly;
        return this;
    }

    public Boolean getMediumDogFriendly() {
        return mediumDogFriendly;
    }

    public Dog setMediumDogFriendly(Boolean mediumDogFriendly) {
        this.mediumDogFriendly = mediumDogFriendly;
        return this;
    }

    public Boolean getLargeDogFriendly() {
        return largeDogFriendly;
    }

    public Dog setLargeDogFriendly(Boolean largeDogFriendly) {
        this.largeDogFriendly = largeDogFriendly;
        return this;
    }

    public Boolean getExtraLargeDogFriendly() {
        return extraLargeDogFriendly;
    }

    public Dog setExtraLargeDogFriendly(Boolean extraLargeDogFriendly) {
        this.extraLargeDogFriendly = extraLargeDogFriendly;
        return this;
    }

    public Boolean getMaleFriendly() {
        return maleFriendly;
    }

    public Dog setMaleFriendly(Boolean maleFriendly) {
        this.maleFriendly = maleFriendly;
        return this;
    }

    public Boolean getFemaleFriendly() {
        return femaleFriendly;
    }

    public Dog setFemaleFriendly(Boolean femaleFriendly) {
        this.femaleFriendly = femaleFriendly;
        return this;
    }

    public Collection<Affinity> getRecievedAffinities() {
        return recievedAffinities;
    }

    public Dog setRecievedAffinities(Collection<Affinity> recievedAffinities) {
        this.recievedAffinities = recievedAffinities;
        return this;
    }

    public Collection<Affinity> getSentAffinities() {
        return sentAffinities;
    }

    public Dog setSentAffinities(Collection<Affinity> sentAffinities) {
        this.sentAffinities = sentAffinities;
        return this;
    }

    public User getMaster() {
        return master;
    }

    public Dog setMaster(User master) {
        this.master = master;
        return this;
    }
}
