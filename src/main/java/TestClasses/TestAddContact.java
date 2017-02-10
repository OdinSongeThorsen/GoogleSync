package TestClasses;

import com.google.api.services.calendar.Calendar;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.extensions.*;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Odin on 2/4/2017.
 */
public class TestAddContact {
    public TestAddContact(ContactsService service) throws IOException, ServiceException {
        // Create the entry to insert.
        ContactEntry contact = new ContactEntry();
        // Set the contact's name.
        Name name = new Name();
        final String NO_YOMI = null;
        name.setFullName(new FullName("Elizabeth Bennet", NO_YOMI));
        name.setGivenName(new GivenName("Elizabeth", NO_YOMI));
        name.setFamilyName(new FamilyName("Bennet", NO_YOMI));
        contact.setName(name);
        contact.setContent(new PlainTextConstruct("Notes"));
        // Set contact's e-mail addresses.
        Email primaryMail = new Email();
        primaryMail.setAddress("liz@gmail.com");
        primaryMail.setDisplayName("E. Bennet");
        primaryMail.setRel("http://schemas.google.com/g/2005#home");
        primaryMail.setPrimary(true);
        contact.addEmailAddress(primaryMail);
        Email secondaryMail = new Email();
        secondaryMail.setAddress("liz@example.com");
        secondaryMail.setRel("http://schemas.google.com/g/2005#work");
        secondaryMail.setPrimary(false);
        contact.addEmailAddress(secondaryMail);
        // Set contact's phone numbers.
        PhoneNumber primaryPhoneNumber = new PhoneNumber();
        primaryPhoneNumber.setPhoneNumber("(206)555-1212");
        primaryPhoneNumber.setRel("http://schemas.google.com/g/2005#work");
        primaryPhoneNumber.setPrimary(true);
        contact.addPhoneNumber(primaryPhoneNumber);
        PhoneNumber secondaryPhoneNumber = new PhoneNumber();
        secondaryPhoneNumber.setPhoneNumber("(206)555-1213");
        secondaryPhoneNumber.setRel("http://schemas.google.com/g/2005#home");
        contact.addPhoneNumber(secondaryPhoneNumber);
        // Set contact's IM information.
        Im imAddress = new Im();
        imAddress.setAddress("liz@gmail.com");
        imAddress.setRel("http://schemas.google.com/g/2005#home");
        imAddress.setProtocol("http://schemas.google.com/g/2005#GOOGLE_TALK");
        imAddress.setPrimary(true);
        contact.addImAddress(imAddress);
        // Set contact's postal address.
        StructuredPostalAddress postalAddress = new StructuredPostalAddress();
        postalAddress.setStreet(new Street("1600 Amphitheatre Pkwy"));
        postalAddress.setCity(new City("Mountain View"));
        postalAddress.setRegion(new Region("CA"));
        postalAddress.setPostcode(new PostCode("94043"));
        postalAddress.setCountry(new Country("US", "United States"));
        postalAddress.setFormattedAddress(new FormattedAddress("1600 Amphitheatre Pkwy Mountain View"));
        postalAddress.setRel("http://schemas.google.com/g/2005#work");
        postalAddress.setPrimary(true);
        contact.addStructuredPostalAddress(postalAddress);
        // Ask the service to insert the new entry
        URL postUrl = new URL("https://www.google.com/m8/feeds/contacts/odin.thorsen@gmail.com/full");
        ContactEntry createdContact = service.insert(postUrl, contact);
        System.out.println("Contact's ID: " + createdContact.getId());
    }
}
