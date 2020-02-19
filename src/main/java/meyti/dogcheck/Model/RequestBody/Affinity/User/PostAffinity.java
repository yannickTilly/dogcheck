package meyti.dogcheck.Model.RequestBody.Affinity.User;

import meyti.dogcheck.Model.Entity.Affinity;
import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PostAffinity {
    public long senderId;
    private long receiverId;
    private Integer playfulScoreDog;
    private Integer sportScoreDog;

    public Affinity getAffinity(DogRepository dogRepository) throws DogNotFound {
        Dog sender = dogRepository.findOneById(senderId);
        Dog receiver = dogRepository.findOneById(receiverId);
        if (sender == null || receiver == null)
        {
            throw new DogNotFound();
        }
        Affinity affinity = new Affinity();
        affinity.setPlayfulScoreDog(playfulScoreDog);
        affinity.setSportScoreDog(sportScoreDog);
        affinity.setReceiver(receiver);
        affinity.setSender(sender);
        return affinity;
    }
}
