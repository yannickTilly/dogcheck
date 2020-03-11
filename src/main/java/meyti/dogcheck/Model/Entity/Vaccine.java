package meyti.dogcheck.Model.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Response.View.Master;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Vaccine")
public class Vaccine {

    @Id
    @JsonView({Master.Dog.class})
    private  long id;

    @JsonView({Master.Dog.class})
    private String name;

    @JsonView({Master.Dog.class})
    private String description;

    @JsonView({Master.Dog.class})
    private String cycle;

    @OneToMany(targetEntity = Vaccination.class, mappedBy = "vaccine")
    private Collection<Vaccination> vaccinations;

    public String getName() {
        return name;
    }

    public Vaccine setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Vaccine setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCycle() {
        return cycle;
    }

    public Vaccine setCycle(String cycle) {
        this.cycle = cycle;
        return this;
    }

    public Collection<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public Vaccine setVaccinations(Collection<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
        return this;
    }
}
