package meyti.dogcheck.Model.Entity.Key;

import meyti.dogcheck.Model.Entity.Dog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AffinityKey.class)
public class AffinityKey {
    @Id
    Dog senderDog;
    @Id
    Dog receiverDog;

    public Dog getSenderDog() {
        return senderDog;
    }

    public AffinityKey setSenderDog(Dog senderDog) {
        this.senderDog = senderDog;
        return this;
    }

    public Dog getReceiverDog() {
        return receiverDog;
    }

    public AffinityKey setReceiverDog(Dog receiverDog) {
        this.receiverDog = receiverDog;
        return this;
    }
}
