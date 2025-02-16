package java_assement_day2_exercises_1;

public class MyMathDemo {
	 public static void main(String[] args) {
	int testNum = 28;
    System.out.println("Is " + testNum + " a perfect number? " + PerfectNumber.isPerfectNumber(testNum));
	
    int factNum = 5;
    System.out.println("Factorial of " + factNum + ": " + Factorial.factorial(factNum));

    int primeCheck = 17;
    System.out.println("Is " + primeCheck + " a prime number? " + IsPrime.isPrime(primeCheck));

    int sumPrime = 10;
    System.out.println("Sum of primes up to " + sumPrime + ": " + SumofPrimes.sumOfPrimes(sumPrime));

    int armstrongNum = 153;
    System.out.println("Is " + armstrongNum + " an Armstrong number? " + IsarmstrongNum.isArmstrongNumber(armstrongNum));

    int revNum = 1234;
    System.out.println("Reverse of " + revNum + ": " + RevNum.reverseNumber(revNum));

    int decNum = 10;
    System.out.println("Binary of " + decNum + ": " + DecToBin.decimalToBinary(decNum));

   
    int fiboCount = 10;
    System.out.println("Sum of first " + fiboCount + " Fibonacci numbers: " + SumOfFib.getSumOfNfibos(fiboCount));

   int palNum = 1991;
    System.out.println("Is " + palNum + " a palindrome number? " + IsPal.isPalindromeNumber(palNum));
   
	 }
}