package meyti.dogcheck.Controller.Base;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.Information;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.Repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class InformationController extends BaseController {

    @Autowired
    InformationRepository informationRepository;

    public Information postInformation(Information information)
    {
        informationRepository.save(information);
        return information;
    }

    public List<Information> getInformations()
    {
        return (List<Information>) informationRepository.findAll();
    }

    public List<Information> getUserInformations(long userId) throws UserNotFound {
        User user = userRepository.findOneById(userId);
        if (user == null)
        {
            throw new UserNotFound();
        }
        return (List<Information>) user.getCreatedInformations();
    }

    public Information getInformation(long id) throws DogNotFound {
        Information information = informationRepository.findOneById(id);
        if (information == null)
        {
            throw new DogNotFound();
        }
        return information;
    }
}
