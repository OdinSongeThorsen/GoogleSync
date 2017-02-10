package TestClasses;

import Logic.CalendarEventManager;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

import java.io.IOException;

/**
 * Created by Odin on 2/3/2017.
 */
public class TestEditEvent {
    public TestEditEvent(Calendar service, String eventID) throws IOException {

        //fetch event
        Event event = service.events().get("primary", eventID).execute();

        //change it
        event.setSummary("Stay home and work on Google Calendar program");

        //update
        new CalendarEventManager().editEvent(event, service);
    }
}
