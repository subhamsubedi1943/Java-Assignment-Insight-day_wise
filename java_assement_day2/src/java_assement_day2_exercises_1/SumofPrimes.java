package java_assement_day2_exercises_1;

public class SumofPrimes {
	public static long sumOfPrimes(int n) {
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if (IsPrime.isPrime(i)) sum += i;
        }
        return sum;
    }

}
