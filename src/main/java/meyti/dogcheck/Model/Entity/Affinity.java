package meyti.dogcheck.Model.Entity;

import meyti.dogcheck.Model.Entity.Key.AffinityKey;

import javax.persistence.*;

@Entity
@Table(name = "Affinity")
@IdClass(AffinityKey.class)
public class Affinity {
    @Id
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Dog sender;

    @Id
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Dog receiver;

    private Integer playfulScoreDog;
    private Integer sportScoreDog;

    public Dog getSender() {
        return sender;
    }

    public Affinity setSender(Dog sender) {
        this.sender = sender;
        return this;
    }

    public Dog getReceiver() {
        return receiver;
    }

    public Affinity setReceiver(Dog receiver) {
        this.receiver = receiver;
        return this;
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
