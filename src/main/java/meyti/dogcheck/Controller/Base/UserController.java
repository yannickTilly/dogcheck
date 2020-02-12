package meyti.dogcheck.Controller.Base;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class UserController extends BaseController {
    @Autowired
    DogRepository dogRepository;

    public User getUser(long id)
    {
        User user = userRepository.findOneById(id);
        return user;
    }

    public List<User> getUsers()
    {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    public User getDogUser(long idDog)
    {
        Dog dog = dogRepository.findOneById(idDog);
        return dog.getMaster();
    }
}
