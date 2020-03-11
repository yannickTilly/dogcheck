package meyti.dogcheck.Controller.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.HeightPoint;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.HeightPointNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.RequestBody.HeightPoint.User.PostHeightPoint;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class HeightPointController extends meyti.dogcheck.Controller.Base.HeightPointController {


    @RequestMapping(value = "dog/{dogId}/heightpoint", method = RequestMethod.POST)
    @JsonView(Master.HeightPoint.class)
    public HeightPoint postHeightPoint(@RequestBody PostHeightPoint postHeightPoint, @PathVariable long dogId) throws DogNotFound {
        Dog dog = dogRepository.findOneById(dogId);
        if (dog == null)
        {
            throw new DogNotFound();
        }
        HeightPoint heightPoint = postHeightPoint.getHeightPoint();
        heightPoint.setDog(dog);
        return super.postHeightPoint(heightPoint);
    }

    @RequestMapping(value = "heightpoint/{id}", method = RequestMethod.GET)
    @JsonView(Master.HeightPoint.class)
    public HeightPoint getHeightPoint(@PathVariable long id) throws DogNotFound, HeightPointNotFound {
//        TODO: verification droit
        return super.getHeightPoint(id);
    }

    @RequestMapping(value = "heightpoints", method = RequestMethod.GET)
    @JsonView(Master.HeightPoint.class)
    public List<HeightPoint> getHeightPoints()
    {
        return super.getHeightPoints();
    }

    @RequestMapping(value = "dog/{dogId}/heightpoint", method = RequestMethod.GET)
    @JsonView(Master.HeightPoint.class)
    public List<HeightPoint> getDogHeighPoint(@PathVariable long dogId) throws DogNotFound {
        return super.getDogHeightPoints(dogId);
    }
}
