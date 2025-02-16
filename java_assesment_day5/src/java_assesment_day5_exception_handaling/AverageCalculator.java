package java_assesment_day5_exception_handaling;

class AverageCalculator {

    public double calAverage(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer (n > 0).");
        }

        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum / n;
    }


    public static void main(String[] args) {
        AverageCalculator calculator = new AverageCalculator();

        try {
            double average = calculator.calAverage(5);
            System.out.println("Average of first 5 natural numbers: " + average);

            average = calculator.calAverage(10);
            System.out.println("Average of first 10 natural numbers: " + average);

            average = calculator.calAverage(0); // This will throw an exception
            System.out.println("Average: " + average); // This line won't be reached

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            double average = calculator.calAverage(-3);
            System.out.println("Average: " + average); // This line won't be reached
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}