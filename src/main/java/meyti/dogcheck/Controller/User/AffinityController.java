package meyti.dogcheck.Controller.User;

import meyti.dogcheck.Model.Entity.Affinity;
import meyti.dogcheck.Model.Entity.Key.AffinityKey;
import meyti.dogcheck.Model.Exception.*;
import meyti.dogcheck.Model.RequestBody.Affinity.User.PostAffinity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

public class AffinityController extends meyti.dogcheck.Controller.Base.AffinityController {

    @RequestMapping(value = "affinity/{senderId}/{receiverId}", method = RequestMethod.GET)
    public Affinity getAffinity(AffinityKey affinityKey) throws AffinityNotFound, AccessRessourceForbidden, UserNotFound {
        Affinity affinity = super.getAffinity(affinityKey);
        if(affinity.getSender().getMaster().getId() != this.getUser().getId() &&
                affinity.getReceiver().getMaster().getId() != this.getUser().getId()) throw new AccessRessourceForbidden();
        return affinity;
    }

    @RequestMapping(value = "affinity", method = RequestMethod.GET)
    public Affinity postAffinity(PostAffinity postAffinity) throws PostRessourceForbidden, UserNotFound {
        Affinity affinity = postAffinity.getAffinity();
        if (affinity.getSender().getMaster().getId() != this.getUser().getId()) throw new PostRessourceForbidden();
        return super.postAffinity(affinity);
    }

    @RequestMapping(value = "affinitys", method = RequestMethod.GET)
    public List<Affinity> getAffinitys()
    {
        return super.getAffinitys();
    }

    @RequestMapping(value = "dog/{dogId}/recievedAffinitys", method = RequestMethod.GET)
    public Collection<Affinity> getDogRecievedAffinitys(long dogId) throws DogNotFound {
        return super.getDogRecievedAffinitys(dogId);
    }

    @RequestMapping(value = "dog/{dogId}/sentAffinitys", method = RequestMethod.GET)
    public Collection<Affinity> getDogSentAffinitys(long idDog) throws DogNotFound {
        return super.getDogSentAffinitys(idDog);
    }
}
