package java_assesment_day5_exception_handaling;
import java.io.*;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName, middleName, lastName, dateOfBirth, gender, mobileNumber;

    public Contact(String firstName, String middleName, String lastName, String dateOfBirth, String gender, String mobileNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() { return mobileNumber; }
    public String toString() {
        return firstName + " " + middleName + " " + lastName + ", DOB: " + dateOfBirth + ", Gender: " + gender + ", Mobile: " + mobileNumber;
    }
}

class StackFullException extends Exception { private static final long serialVersionUID = 1L; public StackFullException(String msg) { super(msg); } }
class StackEmptyException extends Exception { private static final long serialVersionUID = 1L; public StackEmptyException(String msg) { super(msg); } }
class ContactValidationException extends Exception { private static final long serialVersionUID = 1L; public ContactValidationException(String msg) { super(msg); } }



