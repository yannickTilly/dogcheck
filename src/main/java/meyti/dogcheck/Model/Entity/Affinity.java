package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Key.AffinityKey;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Affinity")
@IdClass(AffinityKey.class)
public class Affinity implements Serializable {
    @Id
    @JsonView(Master.Affinity.class)
    @JoinColumn(name="senderId", referencedColumnName="id")
    @ManyToOne
    public Dog sender;

    @Id

    @JsonView(Master.Affinity.class)
    @JoinColumn(name="receiverId", referencedColumnName="id")
    @ManyToOne
    private Dog receiver;


    @JsonView(Master.Affinity.class)
    private Integer playfulScoreDog;


    @JsonView(Master.Affinity.class)
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
