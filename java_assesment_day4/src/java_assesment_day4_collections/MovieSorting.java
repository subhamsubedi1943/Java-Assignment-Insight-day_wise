package java_assesment_day4_collections;
import java.text.ParseException;
import java.util.*;
public class MovieSorting {

    public static List<Movie> createMovieSet() throws ParseException {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Movie A", "English", "2023-10-26", "Director X", "Producer Y", 120));
        movieList.add(new Movie("Movie B", "Hindi", "2023-11-15", "Director Z", "Producer W", 150));
        movieList.add(new Movie("Movie C", "English", "2023-09-01", "Director X", "Producer A", 100));
        movieList.add(new Movie("Movie D", "Tamil", "2024-01-20", "Director A", "Producer B", 160));
        movieList.add(new Movie("Movie E", "Telugu", "2023-12-05", "Director Z", "Producer C", 135));

        return movieList;
    }

    public static void sortByLanguage(List<Movie> movieList) {
        Collections.sort(movieList); // Uses the compareTo method in Movie class
    }

    public static void sortByDirector(List<Movie> movieList) {
        Collections.sort(movieList, Movie.DirectorComparator);
    }

    public static void sortByDuration(List<Movie> movieList) {
        Collections.sort(movieList, Movie.DurationComparator);
    }



    public static void main(String[] args) throws ParseException {
        List<Movie> movies = createMovieSet();

        System.out.println("Original List:");
        for (Movie m : movies) {
            System.out.println(m);
        }

        sortByLanguage(movies);
        System.out.println("\nSorted by Language:");
        for (Movie m : movies) {
            System.out.println(m);
        }

        sortByDirector(movies);
        System.out.println("\nSorted by Director:");
        for (Movie m : movies) {
            System.out.println(m);
        }

        sortByDuration(movies);
        System.out.println("\nSorted by Duration:");
        for (Movie m : movies) {
            System.out.println(m);
        }

    }
}