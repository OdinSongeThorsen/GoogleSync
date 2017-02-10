package TestClasses;

import Logic.CalendarEventManager;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;

import java.util.Arrays;

/**
 * Created by Odin on 2/3/2017.
 */
public class TestAddEvent {
    public TestAddEvent(Calendar service){

        Event event = new Event()
                .setSummary("Go to meeting about Bac assignment")
                .setLocation("Tonsberg")
                .setDescription("I am going with my group to meet with the people who wants us to build the art IS");

        DateTime startDateTime = new DateTime("2017-02-03T10:00:00-01:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("Europe/Oslo");
        event.setStart(start);

        DateTime endDateTime = new DateTime("2017-02-03T15:00:00-01:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("Europe/Oslo");
        event.setEnd(end);

        String[] recurrence = new String[]{"RRULE:FREQ=DAILY;COUNT=2"};
        event.setRecurrence(Arrays.asList(recurrence));

        EventAttendee[] attendees = new EventAttendee[]{
                new EventAttendee().setEmail("lpage@example.com"),
                new EventAttendee().setEmail("sbrin@example.com")
        };
        event.setAttendees(Arrays.asList(attendees));

        EventReminder[] reminderOverrides = new EventReminder[]{
                new EventReminder().setMethod("email").setMinutes(24*60),
                new EventReminder().setMethod("popup").setMinutes(10)
        };
        Event.Reminders reminders = new Event.Reminders()
                .setUseDefault(false)
                .setOverrides(Arrays.asList(reminderOverrides));
        event.setReminders(reminders);

        new CalendarEventManager().addEvent(event, service);
    }
}
