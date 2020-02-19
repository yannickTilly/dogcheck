package meyti.dogcheck.Controller.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Affinity;
import meyti.dogcheck.Model.Entity.Key.AffinityKey;
import meyti.dogcheck.Model.Exception.*;
import meyti.dogcheck.Model.RequestBody.Affinity.User.PostAffinity;
import meyti.dogcheck.Model.ResponseView.Master;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
@RestController
@RequestMapping("user")
public class AffinityController extends meyti.dogcheck.Controller.Base.AffinityController {

    @RequestMapping(value = "sender/{senderId}/receiver/{receiverId}/affinity", method = RequestMethod.GET)
    @JsonView(Master.Affinity.class)
    public Affinity getAffinity(@PathVariable long senderId, @PathVariable long receiverId) throws AffinityNotFound, AccessRessourceForbidden, UserNotFound {
        Affinity affinity = super.getAffinity(senderId, receiverId);
        if(affinity.getSender().getMaster().getId() != this.getUser().getId() &&
                affinity.getReceiver().getMaster().getId() != this.getUser().getId()) throw new AccessRessourceForbidden();
        return affinity;
    }

    @RequestMapping(value = "affinity", method = RequestMethod.GET)
    @JsonView(Master.Affinity.class)
    public Affinity postAffinity(PostAffinity postAffinity) throws PostRessourceForbidden, UserNotFound, DogNotFound {
        Affinity affinity = postAffinity.getAffinity(dogRepository);
        if (affinity.getSender().getMaster().getId() != this.getUser().getId()) throw new PostRessourceForbidden();
        return super.postAffinity(affinity);
    }

    @RequestMapping(value = "affinitys", method = RequestMethod.GET)
    @JsonView(Master.Affinity.class)
    public List<Affinity> getAffinitys()
    {
        return super.getAffinitys();
    }

    @RequestMapping(value = "dog/{dogId}/recievedAffinitys", method = RequestMethod.GET)
    @JsonView(Master.Affinity.class)
    public Collection<Affinity> getDogRecievedAffinitys(long dogId) throws DogNotFound {
        return super.getDogRecievedAffinitys(dogId);
    }

    @RequestMapping(value = "dog/{dogId}/sentAffinitys", method = RequestMethod.GET)
    @JsonView(Master.Affinity.class)
    public Collection<Affinity> getDogSentAffinitys(long idDog) throws DogNotFound {
        return super.getDogSentAffinitys(idDog);
    }
}
