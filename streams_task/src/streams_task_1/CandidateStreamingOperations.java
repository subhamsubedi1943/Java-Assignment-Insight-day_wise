package streams_task_1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

    public static void main(String[] args) {

        // Fetch the list of candidates from the repository
        List<Candidate> candidates = InterviewRepository.getCandidateList();

        // List candidate names from Pune city
        System.out.println("List of Pune Candidates:");
        candidates.stream()
                .filter(candidate -> candidate.getCity().equalsIgnoreCase("Pune"))
                .map(Candidate::getName)
                .forEach(System.out::println);
        
        printLine(); // Separator line

        // List city and count of candidates per city
        System.out.println("Candidate count per city:");
        Map<String, Long> candidatesByCity = candidates.stream()
                .collect(Collectors.groupingBy(Candidate::getCity, Collectors.counting()));
        candidatesByCity.forEach((city, count) -> System.out.println(city + ": " + count));

        printLine(); 

        // List technical expertise and count of candidates
     // List technical expertise and count of candidates
        System.out.println("Candidate count by Technical Expertise:");
        Map<String, Long> candidatesByExpertise = candidates.stream()
                .collect(Collectors.groupingBy(Candidate::getTechnology, Collectors.counting()));
        candidatesByExpertise.forEach((tech, count) -> System.out.println(tech + ": " + count));

        printLine(); 

        // List fresher candidates (experience = 0)
        System.out.println("Fresher Candidate list:");
        candidates.stream()
                .filter(candidate -> candidate.getExperience() == 0)
                .map(Candidate::getName)
                .forEach(System.out::println);

        printLine(); 

        // Listing candidates with highest experience
        System.out.println("Candidate with Highest Experience:");
        candidates.stream()
                .max(Comparator.comparingInt(Candidate::getExperience))
                .ifPresent(candidate -> System.out.println(candidate.getName() + " - " + candidate.getExperience() + " years"));

        printLine(); 

        // Sort the candidates by experience (descending order)
        System.out.println("Sorted List of Candidates by Experience:");
        candidates.stream()
                .sorted(Comparator.comparingInt(Candidate::getExperience).reversed())
                .forEach(candidate -> System.out.println(candidate.getName() + " - " + candidate.getExperience() + " years"));

        printLine(); 

        // Sort the candidates by city name (ascending order)
        System.out.println("Sorted List of Candidates by City Name:");
        candidates.stream()
                .sorted(Comparator.comparing(Candidate::getCity))
                .forEach(candidate -> System.out.println(candidate.getName() + " - " + candidate.getCity()));

    }

    private static void printLine() {
        System.out.println("======================================================");
    }
}
