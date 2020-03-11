package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Height")
public class HeightPoint {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({Master.Information.class, Master.Dog.class})
    private Long id;

    @JsonView(Master.Dog.class)
    private float withers;

    @JsonView(Master.Dog.class)
    private LocalDate date;

    @ManyToOne(targetEntity = Dog.class)
    private Dog dog;

    public float getWithers() {
        return withers;
    }

    public HeightPoint setWithers(float withers) {
        this.withers = withers;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public HeightPoint setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Dog getDog() {
        return dog;
    }

    public HeightPoint setDog(Dog dog) {
        this.dog = dog;
        return this;
    }
}
