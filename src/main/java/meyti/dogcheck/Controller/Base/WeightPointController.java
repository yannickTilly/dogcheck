package meyti.dogcheck.Controller.Base;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Entity.Walk;
import meyti.dogcheck.Model.Entity.WeightPoint;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Exception.WeightPointNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.Repository.WalkRepository;
import meyti.dogcheck.Model.Repository.WeightPointRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class WeightPointController extends BaseController {

    @Autowired
    protected WeightPointRepository weightPointRepository;

    @Autowired
    protected DogRepository dogRepository;

    public WeightPoint postWeightPoint(WeightPoint weightPoint)
    {
        weightPointRepository.save(weightPoint);
        return weightPoint;
    }

    public List<WeightPoint> getWeightPoints()
    {
        return (List<WeightPoint>) weightPointRepository.findAll();
    }

    public List<WeightPoint> getDogWeightPoints(long dogId) throws DogNotFound {
        Dog dog = dogRepository.findOneById(dogId);
        if (dog == null)
        {
            throw new DogNotFound();
        }
        return (List<WeightPoint>) dog.getWeightPoints();
    }

    public WeightPoint getWeightPoint(long id) throws WeightPointNotFound {
        WeightPoint weightPoint = weightPointRepository.findOneById(id);
        if (weightPoint == null)
        {
            throw new WeightPointNotFound();
        }
        return weightPoint;
    }
}
