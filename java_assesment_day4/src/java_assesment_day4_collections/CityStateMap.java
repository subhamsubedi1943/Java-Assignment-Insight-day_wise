package java_assesment_day4_collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class CityStateMap extends AbstractMap<String, String> {
    private Map<String, String> map = new HashMap<>();

    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String put(String city, String state) {
        return map.put(city, state); // Replaces if city already exists
    }

    @Override
    public String get(Object city) {
        return map.get(city);
    }

    public Set<String> getAllCities() {
        return map.keySet();
    }

    public Collection<String> getAllStates() {
        return map.values();
    }

    public List<String> getCitiesForState(String state) {
        List<String> cities = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(state)) {
                cities.add(entry.getKey());
            }
        }
        return cities;
    }

    public void deleteCitiesForState(String state) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(state));
    }

    public static void loadFromFile(CityStateMap cityStateMap, String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Assuming comma-separated values
                if (parts.length == 2) {
                    cityStateMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        CityStateMap cityStateMap = new CityStateMap();
        String filename = "C:\\Users\\SubhamSubedi\\eclipse-workspace\\java_assesment_day4\\src\\java_assesment_day4_collections\\city_state"; // Create city_state.txt in the same directory

        // Load from file:
        try {
            CityStateMap.loadFromFile(cityStateMap, filename);
        } catch (IOException e) {
            System.err.println("Error loading from file: " + e.getMessage());
            return; 
        }



        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCity-State Map Operations:");
            System.out.println("1. Get all cities");
            System.out.println("2. Get all states");
            System.out.println("3. Get cities for a state");
            System.out.println("4. Add new city-state pair");
            System.out.println("5. Delete all cities for a given state");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("All Cities: " + cityStateMap.getAllCities());
                    break;
                case 2:
                    System.out.println("All States: " + cityStateMap.getAllStates());
                    break;
                case 3:
                    System.out.print("Enter state: ");
                    String state = scanner.nextLine();
                    System.out.println("Cities in " + state + ": " + cityStateMap.getCitiesForState(state));
                    break;
                case 4:
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter state: ");
                    String newState = scanner.nextLine();
                    cityStateMap.put(city, newState);
                    System.out.println("City-state pair added/updated.");
                    break;
                case 5:
                    System.out.print("Enter state to delete cities from: ");
                    String stateToDelete = scanner.nextLine();
                    cityStateMap.deleteCitiesForState(stateToDelete);
                    System.out.println("Cities for " + stateToDelete + " deleted.");
                    break;
                case 6:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
