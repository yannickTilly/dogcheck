package meyti.dogcheck.RestController.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.RequestBody.Localisation.PostLocalisation;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class LocalisationController extends meyti.dogcheck.RestController.Base.LocalisationController {

    @RequestMapping(value = "localisation", method = RequestMethod.POST)
    @JsonView(Master.Event.class)
    public User postLocalisation(@RequestBody PostLocalisation postLocalisation) throws UserNotFound {
        return super.postLocalisation(postLocalisation, this.getUser());
    }
}
