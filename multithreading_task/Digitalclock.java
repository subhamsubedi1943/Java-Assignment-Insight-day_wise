package multithreading_task;

import java.text.SimpleDateFormat;
import java.util.Date;

class Digitalclock extends Thread {
    public void run() {
        while (true) { // Infinite loop to keep updating time
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String time = formatter.format(new Date());

            System.out.println("Current Time: " + time);

            try {
                Thread.sleep(500); // Delay of 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



