package meyti.dogcheck.Model.Entity.Key;

import meyti.dogcheck.Model.Entity.Dog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class AffinityKey {
    long sender;
    long receiver;

    public long getSender() {
        return sender;
    }

    public AffinityKey setSender(long sender) {
        this.sender = sender;
        return this;
    }

    public long getReceiver() {
        return receiver;
    }

    public AffinityKey setReceiver(long receiver) {
        this.receiver = receiver;
        return this;
    }
}
