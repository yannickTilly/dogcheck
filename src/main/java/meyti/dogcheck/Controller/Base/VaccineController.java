package meyti.dogcheck.Controller.Base;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.HeightPoint;
import meyti.dogcheck.Model.Entity.Vaccine;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.HeightPointNotFound;
import meyti.dogcheck.Model.Exception.VaccineNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.Repository.HeightPointRepository;
import meyti.dogcheck.Model.Repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class VaccineController extends BaseController {

    @Autowired
    protected VaccineRepository vaccineRepository;

    public Vaccine postVaccine(Vaccine vaccine)
    {
        vaccineRepository.save(vaccine);
        return vaccine;
    }

    public List<Vaccine> getVaccines()
    {
        return (List<Vaccine>) vaccineRepository.findAll();
    }

    public Vaccine getVaccine(long id) throws VaccineNotFound {
        Vaccine vaccine = vaccineRepository.findOneById(id);
        if (vaccine == null)
        {
            throw new VaccineNotFound();
        }
        return vaccine;
    }
}
