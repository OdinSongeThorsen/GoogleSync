package Logic;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

import java.io.IOException;
import java.util.List;

/**
 * Created by Odin on 2/4/2017.
 */
public class CalendarEventManager {

    private String calendarId = "primary";

    public List<Event> getEvents(Calendar service) throws IOException {
        //List the next 10 events from primary calendar.
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("primary")
                .setMaxResults(10)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        return events.getItems();
    }

    public void addEvent(Event event, Calendar service){
        try {
            if (service != null) {
                event = service.events().insert(calendarId, event).execute();
            }else {
                System.out.println("no calendar service");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Event created: %s\n", event.getHtmlLink());
    }

    public void editEvent(Event event, Calendar service){
        Event updatedEvent = null;
        try {
            updatedEvent = service.events().update("primary", event.getId(), event).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (updatedEvent != null) {
            System.out.println(updatedEvent.getUpdated());
        }else {
            System.out.println("Updated Event is null");
        }
    }

    public void removeEvent(Event event, Calendar service){
        try {
            service.events().delete(calendarId, event.getId()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
