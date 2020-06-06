package meyti.dogcheck.RestController.Base;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.HeightPoint;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.HeightPointNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.Repository.HeightPointRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class HeightPointController extends BaseController {

    @Autowired
    protected HeightPointRepository heightPointRepository;

    @Autowired
    protected DogRepository dogRepository;

    public HeightPoint postHeightPoint(HeightPoint heightPoint)
    {
        heightPointRepository.save(heightPoint);
        return heightPoint;
    }

    public List<HeightPoint> getHeightPoints()
    {
        return (List<HeightPoint>) heightPointRepository.findAll();
    }

    public List<HeightPoint> getDogHeightPoints(long dogId) throws DogNotFound {
        Dog dog = dogRepository.findOneById(dogId);
        if (dog == null)
        {
            throw new DogNotFound();
        }
        return (List<HeightPoint>) dog.getHeightPoints();
    }

    public HeightPoint getHeightPoint(long id) throws DogNotFound, HeightPointNotFound {
        HeightPoint heightPoint = heightPointRepository.findOneById(id);
        if (heightPoint == null)
        {
            throw new HeightPointNotFound();
        }
        return heightPoint;
    }
}
