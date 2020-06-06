package meyti.dogcheck.SocketController.User;

import com.google.gson.Gson;
import meyti.dogcheck.Model.RedisObject.User;
import meyti.dogcheck.Model.RequestBody.Tracker.User.Tracker;
import meyti.dogcheck.Model.Response.View.Master;
import meyti.dogcheck.Service.RedisMap;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.user.UserDestinationResolver;
import org.springframework.stereotype.Controller;

import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class TrackerController {
    /**
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/secured/room")
    public void sendSpecific(
            @Payload Message msg,
            Principal user, @Header("simpSessionId") String sessionId) throws Exception {
        System.out.println("socket !!!!!");
        simpMessagingTemplate.convertAndSendToUser(sessionId, "/queue/specific-user", "test");
        String s = new String((byte[]) msg.getPayload(), StandardCharsets.US_ASCII);
    }
**/
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    private RedisMap redisMap;

    static ObjectMapper objectMapper = new ObjectMapper();

    @MessageMapping("/tracker")
    public void processMessageFromClient(
            @Payload Tracker tracker, @Header("simpSessionId") String sessionId,
            Principal principal) throws Exception {
        redisMap.putUser(sessionId,tracker.getLatitude(), tracker.getLongitude());
        User currentUser = redisMap.getUser(sessionId);
        for(User user : redisMap.getUsers(tracker.getLatitude(), tracker.getLongitude())){
            messagingTemplate.convertAndSendToUser(user.getId(), "/queue/map",
                    objectMapper
                            .writerWithView(Master.User.class)
                            .writeValueAsString(currentUser));
        }
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }
}
