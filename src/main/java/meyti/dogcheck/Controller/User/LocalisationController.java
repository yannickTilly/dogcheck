package meyti.dogcheck.Controller.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Event;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.EventRepository;
import meyti.dogcheck.Model.RequestBody.Event.User.PostEvent;
import meyti.dogcheck.Model.RequestBody.Localisation.PostLocalisation;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class LocalisationController extends meyti.dogcheck.Controller.Base.LocalisationController {

    @RequestMapping(value = "localisation", method = RequestMethod.POST)
    @JsonView(Master.Event.class)
    public User postLocalisation(@RequestBody PostLocalisation postLocalisation) throws UserNotFound {
        return super.postLocalisation(postLocalisation, this.getUser());
    }
}
