package meyti.dogcheck.RestController.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Walk;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.RequestBody.Walk.User.PostWalk;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class WalkController extends meyti.dogcheck.RestController.Base.WalkController {

    @Autowired
    DogRepository dogRepository;

    @RequestMapping(value = "walk", method = RequestMethod.POST)
    @JsonView(Master.Walk.class)
    public Walk postWalk(@RequestBody PostWalk postWalk) throws UserNotFound {
        Walk walk = postWalk.getWalk(this.getUser());
        walk.setWalker(this.getUser());
        return super.postWalk(walk);
    }

    @RequestMapping(value = "walk/{id}", method = RequestMethod.GET)
    @JsonView(Master.Walk.class)
    public Walk getWalk(@PathVariable long id) throws DogNotFound {
//        TODO: verification droit
        return super.getWalk(id);
    }

    @RequestMapping(value = "walks", method = RequestMethod.GET)
    @JsonView(Master.Walk.class)
    public List<Walk> getWalks()
    {
        return super.getWalks();
    }

    @RequestMapping(value = "user/{userId}/walks", method = RequestMethod.GET)
    @JsonView(Master.Dog.class)
    public List<Walk> getUserWalk(@PathVariable long userId) throws UserNotFound {
//        TODO :droit
        return super.getUserWalks(userId);
    }
}
