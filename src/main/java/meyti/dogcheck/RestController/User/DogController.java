package meyti.dogcheck.RestController.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.RequestBody.Dog.User.PostDog;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("user")
@RestController
public class DogController extends meyti.dogcheck.RestController.Base.DogController {

    @Autowired
    DogRepository dogRepository;

    @RequestMapping(value = "dog", method = RequestMethod.POST)
    @JsonView(Master.Dog.class)
    public Dog postDog(@RequestBody PostDog postDog) throws UserNotFound {
        Dog dog = postDog.getDog(this.getUser());
        dog.setMaster(this.getUser());
        return super.postDog(dog);
    }

    @RequestMapping(value = "dog/{id}", method = RequestMethod.GET)
    @JsonView(Master.Dog.class)
    public Dog getDog(@PathVariable long id) throws DogNotFound {
//        TODO: verification droit
        return super.getDog(id);
    }

    @RequestMapping(value = "dogs", method = RequestMethod.GET)
    @JsonView(Master.Dog.class)
    public List<Dog> getDogs(@RequestParam(required = false) String name)
    {
        if (name != null)
        {
            List<Dog> dogs= (List<Dog>) dogRepository.findByNameContainingIgnoreCase(name);
            if (dogs == null) return  new ArrayList<>();
            else return dogs;
        }
        return super.getDogs();
    }

    @RequestMapping(value = "user/{userId}/dogs", method = RequestMethod.GET)
    @JsonView(Master.Dog.class)
    public List<Dog> getUserDog(@PathVariable long userId) throws UserNotFound {
//        TODO :droit
        return super.getUserDogs(userId);
    }
}
