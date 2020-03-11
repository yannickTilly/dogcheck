package meyti.dogcheck.Model.RequestBody.WeightPoint.User;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.WeightPoint;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class PostWeightPoint {
    private float weight;

    public WeightPoint getWeightPoint() {
        WeightPoint weightPoint = new WeightPoint();
        weightPoint.setWeight(weight);
        weightPoint.setDate(LocalDate.now());
        return weightPoint;
    }

    public float getWeight() {
        return weight;
    }

    public PostWeightPoint setWeight(float weight) {
        this.weight = weight;
        return this;
    }
}
