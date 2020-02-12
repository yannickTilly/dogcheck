package meyti.dogcheck.Model.Entity.Key;

import meyti.dogcheck.Model.Entity.Dog;

public class AffinityKey {
    Dog senderDog;
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
