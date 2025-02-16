package java_assesment_day2_2_1;

public class ParamPassingDemo2 {

    // Swap for primitive
    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    // Swap for arrays
    public void swap(int[] arr1, int[] arr2) {
        int temp = arr1[0];
        arr1[0] = arr2[0];
        arr2[0] = temp;
    }

    public static void main(String[] args) {
        int a = 5, b = 10;
        int[] arr1 = {1};
        int[] arr2 = {2};

        ParamPassingDemo2 demo = new ParamPassingDemo2();

        System.out.println("Before swap: a=" + a + ", b=" + b);
        demo.swap(a, b);  // Will not swap because integers are passed by value
        System.out.println("After swap: a=" + a + ", b=" + b);

        System.out.println("Before swap (arrays): arr1[0]=" + arr1[0] + ", arr2[0]=" + arr2[0]);
        demo.swap(arr1, arr2);  // Will swap because arrays are objects
        System.out.println("After swap (arrays): arr1[0]=" + arr1[0] + ", arr2[0]=" + arr2[0]);
    }
}
