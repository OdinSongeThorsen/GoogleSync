package TestClasses;

import Logic.CalendarEventManager;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

import java.io.IOException;

/**
 * Created by Odin on 2/4/2017.
 */
public class TestRemoveEvent {
    public TestRemoveEvent(Calendar service, String eventID) throws IOException {

        //fetch event
        Event event = service.events().get("primary", eventID).execute();

        //delete
        new CalendarEventManager().removeEvent(event, service);
        System.out.println("The event: "+event.getSummary() + " - \nHas been deleted");
    }
}
