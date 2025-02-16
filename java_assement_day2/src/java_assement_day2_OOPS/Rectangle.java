package java_assement_day2_OOPS;

 public class Rectangle {
    int length, breadth;

    public Rectangle(int side) {
        this.length = side;
        this.breadth = side;
    }

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    void display() {
        System.out.println("Length: " + length + ", Breadth: " + breadth);
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5);
        r1.display();
        Rectangle r2 = new Rectangle(4, 6);
        r2.display();
    }
}
