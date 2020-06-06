package meyti.dogcheck.RestController.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Vaccine;
import meyti.dogcheck.Model.Exception.VaccineNotFound;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class VaccinController extends meyti.dogcheck.RestController.Base.VaccineController {

    @RequestMapping(value = "vaccine/{id}", method = RequestMethod.GET)
    @JsonView(Master.Vaccine.class)
    public Vaccine getVaccine(@PathVariable long id) throws VaccineNotFound {
//        TODO: verification droit
        return super.getVaccine(id);
    }

    @RequestMapping(value = "vaccines", method = RequestMethod.GET)
    @JsonView(Master.Vaccine.class)
    public List<Vaccine> getVaccines() {
        return super.getVaccines();
    }
}

