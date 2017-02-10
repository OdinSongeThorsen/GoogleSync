package TestClasses;


import Logic.ContactManager;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Odin on 2/4/2017.
 */
public class TestEditContact {
    public TestEditContact(ContactsService service, ContactEntry entry, ContactManager contactManager) throws IOException, ServiceException {
        // Retrieve the contact to updated.
        URL contactURL = new URL(entry.getEditLink().getHref());
        ContactEntry entryToUpdate = service.getEntry(contactURL, ContactEntry.class);
        entryToUpdate.getName().getFullName().setValue("Huginn muninn");
        entryToUpdate.getName().getGivenName().setValue("Huginn");
        entryToUpdate.getName().getFamilyName().setValue("Muninn");
        URL editUrl = new URL(entryToUpdate.getEditLink().getHref());
        //Send test entry to update method
        contactManager.updateContactName(service, editUrl, entryToUpdate);
    }
}
