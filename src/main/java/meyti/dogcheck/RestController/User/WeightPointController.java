package meyti.dogcheck.RestController.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.WeightPoint;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.WeightPointNotFound;
import meyti.dogcheck.Model.RequestBody.WeightPoint.User.PostWeightPoint;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class WeightPointController extends meyti.dogcheck.RestController.Base.WeightPointController {


    @RequestMapping(value = "dog/{dogId}/weightpoint", method = RequestMethod.POST)
    @JsonView(Master.WeightPoint.class)
    public WeightPoint postWeightPoint(@RequestBody PostWeightPoint postWeightPoint, @PathVariable long dogId) throws DogNotFound {
        Dog dog = dogRepository.findOneById(dogId);
        if (dog == null)
        {
            throw new DogNotFound();
        }
        WeightPoint weightPoint = postWeightPoint.getWeightPoint();
        weightPoint.setDog(dog);
        return super.postWeightPoint(weightPoint);
    }

    @RequestMapping(value = "weightpoint/{id}", method = RequestMethod.GET)
    @JsonView(Master.WeightPoint.class)
    public WeightPoint getWeightPoint(@PathVariable long id) throws WeightPointNotFound {
//        TODO: verification droit
        return super.getWeightPoint(id);
    }

    @RequestMapping(value = "weightpoints", method = RequestMethod.GET)
    @JsonView(Master.HeightPoint.class)
    public List<WeightPoint> getHeightPoints()
    {
        return super.getWeightPoints();
    }

    @RequestMapping(value = "dog/{dogId}/weightpoint", method = RequestMethod.GET)
    @JsonView(Master.WeightPoint.class)
    public List<WeightPoint> getDogWeighPoint(@PathVariable long dogId) throws DogNotFound {
        return super.getDogWeightPoints(dogId);
    }
}
