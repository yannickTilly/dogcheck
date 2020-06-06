package meyti.dogcheck.RestController.Base;

import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.RequestBody.Localisation.PostLocalisation;

import java.util.Date;

public abstract class LocalisationController extends BaseController {

    public User postLocalisation(PostLocalisation postLocalisation, User user)
    {
        user.setLocalisationDate(new Date());
        user.setLongitude(postLocalisation.getLongitude());
        user.setLatitude(postLocalisation.getLatitude());
        userRepository.save(user);
        return user;
    }
}
