package meyti.dogcheck.Model.Entity;

import java.util.Collection;

public class Dog {
    private String name;

    private String race;

    private String sex;

    private Integer age;

    private String size;

    private Boolean sterilised;

    private Boolean maleSterilisedFriendly;

    private Boolean femaleSterilisedFriendly;

    private Boolean smallDogFriendly;

    private Boolean mediumDogFriendly;

    private Boolean largeDogFriendly;

    private Boolean extraLargeDogFriendly;

    private Boolean maleFriendly;

    private Boolean femaleFriendly;

    private Collection<Affinity> recievedAffinities;

    private Collection<Affinity> sentAffinities;

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
