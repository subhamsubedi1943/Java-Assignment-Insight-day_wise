package java_assement_day2_OOPS;

class Student {
    int rollNo;
    String name;
    int mark1, mark2, mark3, total;

    void setStudDetails(int rollNo, String name, int mark1, int mark2, int mark3) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    void findTotal() {
        total = mark1 + mark2 + mark3;
    }

    void dispStudDetails() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Total Marks: " + total);
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student s = new Student();
        s.setStudDetails(1, "John", 85, 90, 80);
        s.findTotal();
        s.dispStudDetails();
    }
}

