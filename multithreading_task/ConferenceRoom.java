package multithreading_task;

class ConferenceRoom {
    private boolean isAvailable = true; // Room is initially available

    public synchronized void bookRoom(String managerName) {
        System.out.println(managerName + " is trying to book the conference room...");

        while (!isAvailable) { // If room is already booked, wait
            System.out.println(managerName + " is waiting as the room is already occupied...");
            try {
                wait(); // Thread waits until room becomes available
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Booking the room
        isAvailable = false;
        System.out.println(managerName + " has booked the room and is conducting a meeting...");

        try {
            Thread.sleep(5000); // Simulating the meeting duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Meeting over, make the room available again
        isAvailable = true;
        System.out.println(managerName + " has finished the meeting and released the room.");

        notifyAll(); // Notify waiting threads that room is now available
    }
}