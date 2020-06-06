package meyti.dogcheck.RestController.Auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.UserRepository;
import meyti.dogcheck.Model.RequestBody.PostToken;
import meyti.dogcheck.Model.Response.Body.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController{
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public Token getToken(@RequestBody PostToken postToken) throws UserNotFound {
        User user = userRepository.findOneByLogin(postToken.getLogin());
        if(user != null)
        {

            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("id", user.getId())
                    .withClaim("role", user.getRole())
                    .sign(algorithm);
            Token tokenResponse = new Token();
            tokenResponse.setToken(token);
            return tokenResponse;
        }
        throw new UserNotFound();
    }
}