package TestClasses;

import Logic.CalendarEventManager;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

import java.io.IOException;
import java.util.List;

/**
 * Created by Odin on 2/2/2017.
 */
public class TestGetEvents {
    public TestGetEvents(Calendar service) throws IOException {

        List<Event> events = new CalendarEventManager().getEvents(service);
        if (events.size() == 0){
            System.out.println("No upcoming events found.");
        }else {
            System.out.println("Upcoming events");
            for (Event event : events){
                DateTime start = event.getStart().getDateTime();
                if (start == null){
                    start = event.getStart().getDate();
                }
                System.out.printf("%s (%s)\n", event.getSummary(), start);
            }
        }
    }
}
