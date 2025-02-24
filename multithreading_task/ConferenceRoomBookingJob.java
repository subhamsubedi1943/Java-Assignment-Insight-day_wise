package multithreading_task;

class ConferenceRoomBookingJob implements Runnable {
    private ConferenceRoom conferenceRoom;
    private String managerName;

    public ConferenceRoomBookingJob(ConferenceRoom conferenceRoom, String managerName) {
        this.conferenceRoom = conferenceRoom;
        this.managerName = managerName;
    }

    @Override
    public void run() {
        conferenceRoom.bookRoom(managerName); // Manager tries to book the room
    }
}