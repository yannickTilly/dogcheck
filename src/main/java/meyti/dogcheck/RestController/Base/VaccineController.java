package meyti.dogcheck.RestController.Base;

import meyti.dogcheck.Model.Entity.Vaccine;
import meyti.dogcheck.Model.Exception.VaccineNotFound;
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
