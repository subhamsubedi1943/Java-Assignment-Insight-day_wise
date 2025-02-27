package streams_task_1;


public class Candidate {
    private String name;
    private String technology;
    private String city;
    private int experience;

    public Candidate(String name, String technology, String city, int experience) {
        this.name = name;
        this.technology = technology;
        this.city = city;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getTechnology() {
        return technology;
    }

    public String getCity() {
        return city;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Candidate{name='" + name + "', technology='" + technology + "', city='" + city + "', experience=" + experience + "}";
    }
}

