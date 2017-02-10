package Logic;

import java.io.IOException;

/**
 * Created by Odin on 2/4/2017.
 */
public class UpdateSyncThread extends Thread {
    @Override
    public void run() {
        super.run();
        while (true){
            try {
                sleep(000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                SyncTokenSample.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
