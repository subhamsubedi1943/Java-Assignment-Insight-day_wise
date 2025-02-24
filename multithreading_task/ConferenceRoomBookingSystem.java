package multithreading_task;

public class ConferenceRoomBookingSystem {
    public static void main(String[] args) {
        ConferenceRoom conferenceRoom = new ConferenceRoom();

        // Creating two manager threads
        Thread manager1 = new Thread(new ConferenceRoomBookingJob(conferenceRoom, "Manager 1"));
        Thread manager2 = new Thread(new ConferenceRoomBookingJob(conferenceRoom, "Manager 2"));

        // Start both threads at the same time
        manager1.start();
        manager2.start();
    }
}