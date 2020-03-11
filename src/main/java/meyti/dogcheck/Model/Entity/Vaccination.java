package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Vaccination")
public class Vaccination {

    @Id
    @JsonView({Master.Dog.class})
    private  long id;

    @JsonView({Master.Dog.class})
    private LocalDate date;

    @ManyToOne(targetEntity = Dog.class)
    private Dog dog;

    @ManyToOne(targetEntity = Vaccine.class)
    @JsonView({Master.Dog.class})
    private Vaccine vaccine;

    public LocalDate getDate() {
        return date;
    }

    public Vaccination setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Dog getDog() {
        return dog;
    }

    public Vaccination setDog(Dog dog) {
        this.dog = dog;
        return this;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public Vaccination setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
        return this;
    }
}
