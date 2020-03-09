package meyti.dogcheck.Controller.Base;

import meyti.dogcheck.Model.Entity.Dog;
import meyti.dogcheck.Model.Entity.Event;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.DogRepository;
import meyti.dogcheck.Model.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class EventController extends BaseController {

    @Autowired
    EventRepository eventRepository;

    public Event postEvent(Event event)
    {
        eventRepository.save(event);
        return event;
    }

    public List<Event> getEvents()
    {
        return (List<Event>) eventRepository.findAll();
    }

    public List<Event> getUserCreatedEvents(long userId) throws UserNotFound {
        User user = userRepository.findOneById(userId);
        if (user == null)
        {
            throw new UserNotFound();
        }
        return (List<Event>) user.getCreatedEvents();
    }

    public List<Event> getUserParticipateEvents(long userId) throws UserNotFound {
        User user = userRepository.findOneById(userId);
        if (user == null)
        {
            throw new UserNotFound();
        }
        return (List<Event>) user.getParticipateEvents();
    }

    public Event getEvent(long id) throws DogNotFound {
        Event event = eventRepository.findOneById(id);
        if (event == null)
        {
            throw new DogNotFound();
        }
        return event;
    }
}
