package Logic;

import com.google.api.client.util.store.DataStore;
import com.google.api.services.calendar.Calendar;

import java.io.IOException;


/**
 * Created by Odin on 2/4/2017.
 */
public class CalendarSyncThread {
    private static DataStore<String> syncSettingsDataStore;
    private static final String SYNC_TOKEN_KEY = "syncToken";
    private static void run(Calendar service) throws IOException {
        // Construct the {@link Calendar.Events.List} request, but don't execute it yet.
        Calendar.Events.List request = service.events().list("primary");

        // Load the sync token stored from the last execution, if any.
        String syncToken = syncSettingsDataStore.get(SYNC_TOKEN_KEY);
    }
}
