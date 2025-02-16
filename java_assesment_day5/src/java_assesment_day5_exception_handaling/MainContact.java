package java_assesment_day5_exception_handaling;

public class MainContact {
    public static void main(String[] args) {
        ContactStack stack = new ContactStack(2);
        try {
            stack.push(new Contact("John", "A", "Doe", "01-01-1990", "Male", "1234567890"));
            stack.push(new Contact("Jane", "B", "Doe", "02-02-1992", "Female", "0987654321"));
            System.out.println("Contacts pushed successfully.");
            stack.pop();
            System.out.println("Contact popped successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
