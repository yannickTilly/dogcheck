package meyti.dogcheck.Controller.Base;

import meyti.dogcheck.Model.Entity.Affinity;
import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.Key.AffinityKey;
import meyti.dogcheck.Model.Exception.*;
import meyti.dogcheck.Model.Repository.AffinityRepository;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.RequestBody.Affinity.User.PostAffinity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public class AffinityController extends BaseController {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    AffinityRepository affinityRepository;


    public Affinity getAffinity(AffinityKey affinityKey) throws AffinityNotFound, UserNotFound, AccessRessourceForbidden {
        Affinity affinity = affinityRepository.findOneByKey(affinityKey);
        if (affinity == null) throw new AffinityNotFound();
        return affinity;
    }

    public Affinity postAffinity(Affinity affinity) throws PostRessourceForbidden{
        Dog sender = dogRepository.findOneById(affinity.getSender().getMaster().getId());
        affinityRepository.save(affinity);
        return affinity;
    }

    public List<Affinity> getAffinitys()
    {
        return (List<Affinity>) affinityRepository.findAll();
    }

    public Collection<Affinity> getDogRecievedAffinitys(long idDog) throws DogNotFound {
        Dog dog = dogRepository.findOneById(idDog);
        if (dog == null) throw new DogNotFound();
        return dog.getRecievedAffinities();
    }

    public Collection<Affinity> getDogSentAffinitys(long idDog) throws DogNotFound {
        Dog dog = dogRepository.findOneById(idDog);
        if (dog == null) throw new DogNotFound();
        return dog.getSentAffinities();
    }
}
