package meyti.dogcheck.Model.RequestBody.User.User;

import meyti.dogcheck.Model.Entity.User;

import javax.persistence.Id;

public class PostUser {
    private String name;

    // photo

    private String mailMessenger;

    private String phoneNumber;

    private String instagramLink;

    private String statut;

    public User getUser() {
        User user = new User();
        user.setMailMessenger(mailMessenger);
        user.setInstagramLink(instagramLink);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        return user;
    }
}

