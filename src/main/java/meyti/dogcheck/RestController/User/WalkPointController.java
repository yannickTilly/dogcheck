package meyti.dogcheck.RestController.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.WalkPoint;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Exception.WalkNotFound;
import meyti.dogcheck.Model.Exception.WalkPointNotFound;
import meyti.dogcheck.Model.RequestBody.WalkPointUser.PostWalkpoint;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class WalkPointController extends meyti.dogcheck.RestController.Base.WalkPointController {

    @RequestMapping(value = "walk/{walkId}/walkpoint", method = RequestMethod.POST)
    @JsonView(Master.WalkPoint.class)
    public WalkPoint postWalkpoint(@RequestBody PostWalkpoint postWalkpoint, @PathVariable int walkId) throws UserNotFound, WalkNotFound {

        WalkPoint walkPoint = postWalkpoint.getWalkpoint();
        return super.postWalkWalkPoint(walkPoint, walkId);
    }

    @RequestMapping(value = "walkPoint/{id}", method = RequestMethod.GET)
    @JsonView(Master.WalkPoint.class)
    public WalkPoint getWalkPoint(@PathVariable long id) throws WalkPointNotFound {
//        TODO: verification droit
        return super.getWalkPoint(id);
    }

    @RequestMapping(value = "walk/{walkId}/walkpoints", method = RequestMethod.GET)
    @JsonView(Master.WalkPoint.class)
    public List<WalkPoint> getWalks(@PathVariable long walkId) throws WalkNotFound {
        return super.getWalkWalkPoints(walkId);
    }
}

