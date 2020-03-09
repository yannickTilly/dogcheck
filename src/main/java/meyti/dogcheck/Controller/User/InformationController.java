package meyti.dogcheck.Controller.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Information;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.InformationRepository;
import meyti.dogcheck.Model.RequestBody.Information.User.PostInformation;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class InformationController extends meyti.dogcheck.Controller.Base.InformationController{

    @Autowired
    InformationRepository informationRepository;

    @RequestMapping(value = "information", method = RequestMethod.POST)
    @JsonView(Master.Information.class)
    public Information postInformation(@RequestBody PostInformation postInformation) throws UserNotFound {
        Information information = postInformation.getInformation(this.getUser());
        information.setCreator(this.getUser());
        return super.postInformation(information);
    }

    @RequestMapping(value = "information/{id}", method = RequestMethod.GET)
    @JsonView(Master.Information.class)
    public Information getInformation(@PathVariable long id) throws DogNotFound {
        return super.getInformation(id);
    }

    @RequestMapping(value = "informations", method = RequestMethod.GET)
    @JsonView(Master.Information.class)
    public List<Information> getDogs()
    {
        return super.getInformations();
    }

    @RequestMapping(value = "user/{userId}/informations", method = RequestMethod.GET)
    @JsonView(Master.Information.class)
    public List<Information> getUserInformation(@PathVariable long userId) throws UserNotFound {
//        TODO :droit
        return super.getUserInformations(userId);
    }
}
