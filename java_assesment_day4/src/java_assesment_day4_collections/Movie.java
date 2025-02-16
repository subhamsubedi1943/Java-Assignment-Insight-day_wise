package java_assesment_day4_collections;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Movie implements Comparable<Movie> {
    String name;
    String language;
    Date releaseDate;
    String director;
    String producer;
    int duration;

    public Movie(String name, String language, String releaseDate, String director, String producer, int duration) throws ParseException {
        this.name = name;
        this.language = language;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Customize date format if needed
        this.releaseDate = sdf.parse(releaseDate);
        this.director = director;
        this.producer = producer;
        this.duration = duration;
    }

    @Override
    public int compareTo(Movie other) {
        return this.language.compareTo(other.language); // Sort by language
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Language: " + language + ", Release Date: " + new SimpleDateFormat("yyyy-MM-dd").format(releaseDate) + ", Director: " + director + ", Producer: " + producer + ", Duration: " + duration;
    }


    // Comparator for sorting by director
    public static Comparator<Movie> DirectorComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            return m1.director.compareTo(m2.director);
        }
    };

    // Comparator for sorting by duration (example)
    public static Comparator<Movie> DurationComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            return Integer.compare(m1.duration, m2.duration);
        }
    };

}