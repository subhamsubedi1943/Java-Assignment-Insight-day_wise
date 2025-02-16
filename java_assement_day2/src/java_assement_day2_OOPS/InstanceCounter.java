package java_assement_day2_OOPS;

class InstanceCounter {
    private static int count = 0;

    public InstanceCounter() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        InstanceCounter obj1 = new InstanceCounter();
        InstanceCounter obj2 = new InstanceCounter();
        InstanceCounter obj3 = new InstanceCounter();
        System.out.println("Number of instances created: " + InstanceCounter.getCount());
    }
}
