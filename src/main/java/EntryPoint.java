import Logic.*;
import TestClasses.*;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.gdata.client.authn.oauth.OAuthException;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.util.ServiceException;


import java.io.IOException;
import java.util.List;

/**
 * Created by Odin on 2/2/2017.
 */
public class EntryPoint {

    public static void main(String[] args) throws IOException, ServiceException, OAuthException {



        //initialize google services and permissions
        Calendar calendarService = GoogleServices.getCalendarService();
        ContactsService contactsService = GoogleServices.getContactsService();

        //initialize managers with methods to get/add/delete/edit entries.
        CalendarEventManager calendarEventManager = new CalendarEventManager();
        ContactManager contactManager = new ContactManager();


        List<Event> events = calendarEventManager.getEvents(calendarService);

        //set IDs for testing purposes
        String eventID = events.get(0).getId();
        //set to name or phone number you want to search for
        String searchString = "(206)555-1212";

//        //test print all contacts method
//        ContactFeed resultFeed = contactManager.getContactFeed(contactsService);
//        System.out.println(resultFeed.getTitle().getPlainText());
//        for (ContactEntry entry: resultFeed.getEntries()) {
//            contactManager.printContact(entry);
//        }


//        //test print searched contact
//        ContactFeed searchFeed = contactManager.getContactFeed(contactsService);
//        System.out.println(searchFeed.getTitle().getPlainText());
//        List<ContactEntry> entries = contactManager.searchFeed(searchFeed, searchString);
//        for (ContactEntry entry : entries){
//            contactManager.printContact(entry);
//        }
//
//        //edits the first returned search result
//        if (entries.size()>0) {
//            new TestEditContact(contactsService, entries.get(0), contactManager);
//        }
//        //deletes the first returned search result
//        if (entries.size()>0) {
//            contactManager.deleteContact(contactsService, entries.get(0));
//        }

//
//        new TestAddContact(contactsService);
//
//        new ContactManager().printContact(contactsService);
//
//        //test synchronization with Google calendar.
//        new UpdateSyncThread().run();
//
//        new TestAddContact(contactsService);
//
//        new TestAddEvent(calendarService);
//
//        new TestEditContact(contactsService);
//
//        new TestEditEvent(calendarService, eventID);
//
//        new TestGetEvents(calendarService);
//
//        new TestRemoveEvent(calendarService, eventID);

    }
}
