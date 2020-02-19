package meyti.dogcheck.Model.RequestBody.Dog.User;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.User;

public class PostDog {

    private long id;

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

    public Dog getDog(User currentUser) {
        Dog dog = new Dog();
        dog.setMaster(currentUser);
        dog.setAge(age);
        dog.setSterilised(sterilised)
                .setSmallDogFriendly(smallDogFriendly)
                .setSize(size)
                .setSex(sex)
                .setRace(race)
                .setName(name)
                .setMediumDogFriendly(mediumDogFriendly)
                .setMaleSterilisedFriendly(maleSterilisedFriendly)
                .setMaleFriendly(maleFriendly)
                .setLargeDogFriendly(largeDogFriendly)
                .setFemaleSterilisedFriendly(femaleSterilisedFriendly)
                .setFemaleFriendly(femaleFriendly)
                .setExtraLargeDogFriendly(extraLargeDogFriendly);
        return dog;
    }
}
