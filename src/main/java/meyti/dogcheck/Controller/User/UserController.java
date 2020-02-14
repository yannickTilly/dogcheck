package meyti.dogcheck.Controller.User;

import meyti.dogcheck.Model.Entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("user")
@RolesAllowed("ROLE_VISITOR")
public class UserController extends meyti.dogcheck.Controller.Base.UserController {
//    TODO: patch user
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public User getUser(@RequestParam long id)
    {
//        TODO verification droit, connecter
        return super.getUser(id);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> getUsers()
    {
//        TODO: pagination
        return super.getUsers();
    }

    @RequestMapping(value = "dog/{idDog}/user", method = RequestMethod.GET)
    public User getDogUser(@RequestParam long idDog)
    {
        return super.getDogUser(idDog);
    }
}
