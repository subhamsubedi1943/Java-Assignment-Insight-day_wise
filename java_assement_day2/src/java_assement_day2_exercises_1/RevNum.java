package java_assement_day2_exercises_1;

public class RevNum {
	public static int reverseNumber(int n) {
        String reversedStr = new StringBuilder(String.valueOf(n)).reverse().toString();
        return Integer.parseInt(reversedStr);
    }


}
