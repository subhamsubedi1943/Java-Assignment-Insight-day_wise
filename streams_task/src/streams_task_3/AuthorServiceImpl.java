package streams_task_3;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.Period;

class AuthorServiceImpl implements AuthorService {

    // Get unique surnames in uppercase
    @Override
    public Set<String> getUniqueSurnames(List<Author> authorList) {
        return authorList.stream()
                .map(author -> author.getSurname().toUpperCase()) // Convert to uppercase
                .collect(Collectors.toSet()); // Collect unique surnames
    }

    // Get authors by city
    @Override
    public List<Author> getAuthorsByCity(List<Author> authorList, String city) {
        return authorList.stream()
                .filter(author -> author.getCity().equalsIgnoreCase(city)) // Match city (case-insensitive)
                .collect(Collectors.toList());
    }

    // Get average age of female authors
    @Override
    public double femaleAverageAge(List<Author> authorList) {
        return authorList.stream()
                .filter(author -> author.getGender().equalsIgnoreCase("Female")) // Filter female authors
                .mapToInt(author -> Period.between(author.getBirthdate(), LocalDate.now()).getYears()) // Calculate age
                .average() // Calculate average
                .orElse(0.0); // Default value if no female authors
    }

    // Get mobile number by Aadhaar number
    @Override
    public Long getMobileByAdhar(List<Author> authorList, Long adharCard) {
        return authorList.stream()
                .filter(author -> author.getAdharCard().equals(adharCard)) // Match Aadhaar number
                .map(Author::getMobile) // Extract mobile number
                .findFirst() // Get the first match
                .orElse(null); // Return null if no match found
    }
}
