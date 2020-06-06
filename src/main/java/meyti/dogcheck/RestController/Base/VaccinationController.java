package meyti.dogcheck.RestController.Base;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.Vaccination;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.VaccinationNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class VaccinationController extends BaseController {

    @Autowired
    protected VaccinationRepository vaccinationRepository;

    @Autowired
    protected DogRepository dogRepository;

    public Vaccination postVaccination(Vaccination vaccination)
    {
        vaccinationRepository.save(vaccination);
        return vaccination;
    }

    public List<Vaccination> getVaccinations()
    {
        return (List<Vaccination>) vaccinationRepository.findAll();
    }

    public Vaccination getVaccination(long id) throws VaccinationNotFound {
        Vaccination vaccination = vaccinationRepository.findOneById(id);
        if (vaccination == null)
        {
            throw new VaccinationNotFound();
        }
        return vaccination;
    }

    public List<Vaccination> getDogVaccinations(long dogId) throws DogNotFound {
        Dog dog = dogRepository.findOneById(dogId);
        if (dog == null)
        {
            throw new DogNotFound();
        }
        return (List<Vaccination>) dog.getVaccinations();
    }
}
