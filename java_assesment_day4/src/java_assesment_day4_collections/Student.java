package java_assesment_day4_collections;

import java.util.Objects;

class Student {
    String firstname;
    String lastname;
    int age;
    Address address;

    public Student(String firstname, String lastname, int age, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
    }

    public String getFullname() {
        return firstname + " " + lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getFullname(), student.getFullname()) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullname(), address);
    }

    @Override
    public String toString() {
        return "Name: " + getFullname() + ", Age: " + age + ", " + address;
    }
}