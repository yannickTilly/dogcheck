package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Weight")
public class WeightPoint {

    @Id
    @Column(name = "ID")
    @JsonView({Master.Information.class, Master.Dog.class})
    private long id;

    @JsonView(Master.Dog.class)
    private float weight;

    @JsonView(Master.Dog.class)
    private LocalDate date;

    @ManyToOne(targetEntity = Dog.class)
    private Dog dog;

    public float getWeight() {
        return weight;
    }

    public WeightPoint setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public WeightPoint setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Dog getDog() {
        return dog;
    }

    public WeightPoint setDog(Dog dog) {
        this.dog = dog;
        return this;
    }
}
