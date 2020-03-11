package meyti.dogcheck.Controller.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Entity.Event;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.EventRepository;
import meyti.dogcheck.Model.RequestBody.Event.User.PostEvent;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class EventController extends meyti.dogcheck.Controller.Base.EventController {

    @Autowired
    EventRepository eventRepository;

    @RequestMapping(value = "event", method = RequestMethod.POST)
    @JsonView(Master.Event.class)
    public Event postEvent(@RequestBody PostEvent postEvent) throws UserNotFound {
        Event event = postEvent.getEvent(this.getUser());
        event.setCreator(this.getUser());
        return super.postEvent(event);
    }

    @RequestMapping(value = "event/{id}", method = RequestMethod.GET)
    @JsonView(Master.Event.class)
    public Event getEvent(@PathVariable long id) throws DogNotFound {
//        TODO: verification droit
        return super.getEvent(id);
    }

    @RequestMapping(value = "events", method = RequestMethod.GET)
    @JsonView(Master.Event.class)
    public List<Event> getEvents()
    {
        return super.getEvents();
    }

    @RequestMapping(value = "user/{userId}/events", method = RequestMethod.GET)
    @JsonView(Master.Event.class)
    public List<Event> getUserCreatedEvents(@PathVariable long userId) throws UserNotFound {
//        TODO :droit
        return super.getUserCreatedEvents(userId);
    }
}
