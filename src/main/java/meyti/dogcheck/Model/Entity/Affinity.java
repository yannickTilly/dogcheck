package meyti.dogcheck.Model.Entity;

import meyti.dogcheck.Model.Entity.Key.AffinityKey;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Affinity")
public class Affinity {

    private AffinityKey affinityKey;
    private Integer playfulScoreDog;
    private Integer sportScoreDog;

    public Dog getSender() {
        return affinityKey.getSenderDog();
    }

    public Dog getReceiver() {
        return affinityKey.getReceiverDog();
    }

    public Integer getPlayfulScoreDog() {
        return playfulScoreDog;
    }

    public Affinity setPlayfulScoreDog(Integer playfulScoreDog) {
        this.playfulScoreDog = playfulScoreDog;
        return this;
    }

    public Integer getSportScoreDog() {
        return sportScoreDog;
    }

    public Affinity setSportScoreDog(Integer sportScoreDog) {
        this.sportScoreDog = sportScoreDog;
        return this;
    }
}
