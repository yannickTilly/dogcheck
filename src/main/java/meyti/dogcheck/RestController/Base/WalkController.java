package meyti.dogcheck.RestController.Base;

import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Entity.Walk;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.WalkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class WalkController extends BaseController {

    @Autowired
    WalkRepository walkRepository;

    public Walk postWalk(Walk walk)
    {
        walkRepository.save(walk);
        return walk;
    }

    public List<Walk> getWalks()
    {
        return (List<Walk>) walkRepository.findAll();
    }

    public List<Walk> getUserWalks(long userId) throws UserNotFound {
        User user = userRepository.findOneById(userId);
        if (user == null)
        {
            throw new UserNotFound();
        }
        return (List<Walk>) user.getCreatedWalks();
    }

    public Walk getWalk(long id) throws DogNotFound {
        Walk walk = walkRepository.findOneById(id);
        if (walk == null)
        {
            throw new DogNotFound();
        }
        return walk;
    }
}
