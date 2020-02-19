package meyti.dogcheck.Controller.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.User;
import org.springframework.web.bind.annotation.*;
import meyti.dogcheck.Model.Response.View.Master;
import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("user")
@RolesAllowed("ROLE_VISITOR")
public class UserController extends meyti.dogcheck.Controller.Base.UserController {
//    TODO: patch user
    @JsonView(Master.User.class)
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id)
    {
//        TODO verification droit, connecter
        return super.getUser(id);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    @JsonView(Master.User.class)
    public List<User> getUsers()
    {
//        TODO: pagination
        return super.getUsers();
    }

    @RequestMapping(value = "dog/{idDog}/user", method = RequestMethod.GET)
    @JsonView(Master.User.class)
    public User getDogUser(@PathVariable long idDog)
    {
        return super.getDogUser(idDog);
    }
}
