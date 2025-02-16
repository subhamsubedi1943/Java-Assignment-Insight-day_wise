package java_assement_day2_exercises_1;

public class SumOfFib {
	 public static int getSumOfNfibos(int n) {
	        if (n <= 0) return 0;
	        int a = 0, b = 1, sum = a + b;
	        for (int i = 2; i < n; i++) {
	            int next = a + b;
	            sum += next;
	            a = b;
	            b = next;
	        }
	        return sum;
	    }

}
