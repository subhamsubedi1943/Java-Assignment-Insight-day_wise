package streams_task_3;
import java.util.*;
import java.time.LocalDate;

public class AuthorTest {
    public static void main(String[] args) {
        // Sample list of authors
        List<Author> authorList = Arrays.asList(
                new Author(123456789012L, "Sharma", "Ramesh", "Kumar", LocalDate.of(1980, 5, 15), "Male", "Delhi", 9876543210L),
                new Author(234567890123L, "Verma", "Anita", "Devi", LocalDate.of(1992, 8, 25), "Female", "Mumbai", 8765432109L),
                new Author(345678901234L, "Mehta", "Suresh", "Patel", LocalDate.of(1985, 11, 10), "Male", "Delhi", 7654321098L),
                new Author(456789012345L, "Sharma", "Neha", "Joshi", LocalDate.of(1995, 3, 5), "Female", "Bangalore", 6543210987L),
                new Author(567890123456L, "Gupta", "Pooja", "Rani", LocalDate.of(1990, 6, 20), "Female", "Mumbai", 5432109876L)
        );

        // Creating an instance of AuthorServiceImpl
        AuthorService authorService = new AuthorServiceImpl();

        // Display unique surnames in uppercase
        System.out.println("Unique Surnames (Uppercase): " + authorService.getUniqueSurnames(authorList));

        // Display authors from Mumbai
        System.out.println("Authors from Mumbai: " + authorService.getAuthorsByCity(authorList, "Mumbai"));

        // Display average age of female authors
        System.out.println("Average Age of Female Authors: " + authorService.femaleAverageAge(authorList));

        // Get mobile number using Aadhaar
        Long adharToSearch = 234567890123L;
        System.out.println("Mobile Number for Aadhaar " + adharToSearch + ": " + authorService.getMobileByAdhar(authorList, adharToSearch));
    }
}
