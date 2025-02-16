package java_assement_day2_exercises_1;

public class Factorial {
	 public static long factorial(int n) {
	        if (n < 0) return -1; // Negative numbers don't have factorial
	        long fact = 1;
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	    }


}
