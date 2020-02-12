package meyti.dogcheck.Controller.User;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.RequestBody.Dog.User.PostDog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("user")
public class DogController extends meyti.dogcheck.Controller.Base.DogController {

    @Autowired
    DogRepository dogRepository;

    @RequestMapping(value = "dog", method = RequestMethod.POST)
    public Dog postDog(@RequestBody PostDog postDog)
    {
        Dog dog = postDog.getDog();
        return super.postDog(dog);
    }

    @RequestMapping(value = "dog/{id}", method = RequestMethod.GET)
    public Dog getDog(@PathVariable long id) throws DogNotFound {
        return super.getDog(id);
    }

    @RequestMapping(value = "dogs", method = RequestMethod.GET)
    public List<Dog> getDogs()
    {
        return super.getDogs();
    }

    @RequestMapping(value = "user/{userId}/dogs", method = RequestMethod.GET)
    public List<Dog> getUserDog(@PathVariable long userId) throws UserNotFound {
        return super.getUserDogs(userId);
    }
}
