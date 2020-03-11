package meyti.dogcheck.Controller.Base;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.HeightPoint;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.HeightPointNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.Repository.HeightPointRepository;
import meyti.dogcheck.Model.RequestBody.Localisation.PostLocalisation;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
