package meyti.dogcheck.Controller.Base;

import meyti.dogcheck.Model.Entity.Walk;
import meyti.dogcheck.Model.Entity.WalkPoint;
import meyti.dogcheck.Model.Exception.WalkNotFound;
import meyti.dogcheck.Model.Exception.WalkPointNotFound;
import meyti.dogcheck.Model.Repository.WalkPointRepository;
import meyti.dogcheck.Model.Repository.WalkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class WalkPointController extends BaseController {

    @Autowired
    protected WalkPointRepository walkPointRepository;

    @Autowired
    protected WalkRepository walkRepository;

    public WalkPoint postWalkPoint(WalkPoint walkPoint)
    {
        walkPointRepository.save(walkPoint);
        return walkPoint;
    }

    public WalkPoint postWalkWalkPoint(WalkPoint walkPoint, long walkId) throws WalkNotFound {
        Walk walk = walkRepository.findOneById(walkId);
        if(walk == null)
        {
            throw new WalkNotFound();
        }
        walkPoint.setWalk(walk);
        walkPointRepository.save(walkPoint);
        return walkPoint;
    }

    public List<WalkPoint> getWalkPoints()
    {
        return (List<WalkPoint>) walkPointRepository.findAll();
    }

    public List<WalkPoint> getWalkWalkPoints(long walkId) throws WalkNotFound {
        Walk walk = walkRepository.findOneById(walkId);
        if (walk == null)
        {
            throw new WalkNotFound();
        }
        return (List<WalkPoint>) walk.getWalkPoints();
    }

    public WalkPoint getWalkPoint(long id) throws WalkPointNotFound {
        WalkPoint walkPoint = walkPointRepository.findOneById(id);
        if (walkPoint == null)
        {
            throw new WalkPointNotFound();
        }
        return walkPoint;
    }
}
