package meyti.dogcheck.RestController.Base;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class DogController extends BaseController {

    @Autowired
    DogRepository dogRepository;

    public Dog postDog(Dog dog)
    {
        dogRepository.save(dog);
        return dog;
    }

    public List<Dog> getDogs()
    {
        return (List<Dog>) dogRepository.findAll();
    }

    public List<Dog> getUserDogs(long userId) throws UserNotFound {
        User user = userRepository.findOneById(userId);
        if (user == null)
        {
            throw new UserNotFound();
        }
        return (List<Dog>) user.getDogs();
    }

    public Dog getDog(long id) throws DogNotFound {
        Dog dog = dogRepository.findOneById(id);
        if (dog == null)
        {
            throw new DogNotFound();
        }
        return dog;
    }
}
