package streams_task_3;
import java.util.*;

interface AuthorService {
    // Get unique surnames in uppercase
    Set<String> getUniqueSurnames(List<Author> authorList);
    
    // Get authors by city
    List<Author> getAuthorsByCity(List<Author> authorList, String city);
    
    // Get average age of female authors
    double femaleAverageAge(List<Author> authorList);
    
    // Get mobile number by Aadhaar number
    Long getMobileByAdhar(List<Author> authorList, Long adharCard);
}
