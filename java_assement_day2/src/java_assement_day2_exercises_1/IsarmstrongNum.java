package java_assement_day2_exercises_1;

public class IsarmstrongNum {
	 public static boolean isArmstrongNumber(int n) {
	        int sum = 0, temp = n, digits = String.valueOf(n).length();
	        while (temp > 0) {
	            int digit = temp % 10;
	            sum += Math.pow(digit, digits);
	            temp /= 10;
	        }
	        return sum == n;
	    }


}
