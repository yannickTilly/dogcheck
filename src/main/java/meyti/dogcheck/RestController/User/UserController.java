package meyti.dogcheck.RestController.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import meyti.dogcheck.Model.Response.View.Master;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
@Secured("ROLE_USER")
public class UserController extends meyti.dogcheck.RestController.Base.UserController {
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
    public List<User> getUsers(@RequestParam String name)
    {
        if (name != null)
        {
            List<User> users= (List<User>) userRepository.findByNameContainingIgnoreCase(name);
            if (users == null) return  new ArrayList<>();
            else return users;
        }
        return super.getUsers();
    }

    @RequestMapping(value = "dog/{idDog}/user", method = RequestMethod.GET)
    @JsonView(Master.User.class)
    public User getDogUser(@PathVariable long idDog)
    {
        return super.getDogUser(idDog);
    }
}
