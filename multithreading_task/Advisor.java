package multithreading_task;

public class Advisor {
    public static void main(String[] args) {
        // Array of advice messages
        String[] advices = {
            "Never begin to stop and never stop to begin.",
            "Only destination isn’t important, one should enjoy the journey.",
            "Impossible itself says ‘I’m possible’.",
            "Success is not the key to happiness. Happiness is the key to success.",
            "Mistakes are proof that you are trying.",
            "Every day is a second chance.",
            "Do what you love, and you’ll never work a day in your life."
        };

        // Generate a random index
        int randomIndex = (int) (Math.random() * advices.length);

        // Print the randomly selected advice
        System.out.println("Advice of the Day: " + advices[randomIndex]);
    }
}

