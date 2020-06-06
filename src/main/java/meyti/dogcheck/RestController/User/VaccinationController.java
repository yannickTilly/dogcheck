package meyti.dogcheck.RestController.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.Vaccination;
import meyti.dogcheck.Model.Entity.Vaccine;
import meyti.dogcheck.Model.Exception.*;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.Repository.VaccineRepository;
import meyti.dogcheck.Model.RequestBody.Vaccination.User.PostVaccination;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class VaccinationController extends meyti.dogcheck.RestController.Base.VaccinationController {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    @RequestMapping(value = "dog/{dogId}/vaccine/{vaccineId}/vaccination", method = RequestMethod.POST)
    @JsonView(Master.WalkPoint.class)
    public Vaccination postVaccination(
            @RequestBody PostVaccination postVaccination,
            @PathVariable long dogId,
            @PathVariable long vaccineId) throws DogNotFound, VaccineNotFound {

        Vaccination vaccination = postVaccination.getVaccination();
        Dog dog = dogRepository.findOneById(dogId);
        Vaccine vaccine = vaccineRepository.findOneById(vaccineId);
        if(dog == null){
            throw new DogNotFound();
        }
        if(vaccine == null){
            throw new VaccineNotFound();
        }
        vaccination.setDog(dog);
        vaccination.setVaccine(vaccine);
        return super.postVaccination(vaccination);
    }

    @RequestMapping(value = "vaccination/{id}", method = RequestMethod.GET)
    @JsonView(Master.Vaccination.class)
    public Vaccination getVaccination(@PathVariable long id) throws VaccinationNotFound {
//        TODO: verification droit
        return super.getVaccination(id);
    }

    @RequestMapping(value = "dog/{dogId}/vaccinations", method = RequestMethod.GET)
    @JsonView(Master.WalkPoint.class)
    public List<Vaccination> getdogVaccinations(@PathVariable long dogId) throws DogNotFound {
        return super.getDogVaccinations(dogId);
    }
}

