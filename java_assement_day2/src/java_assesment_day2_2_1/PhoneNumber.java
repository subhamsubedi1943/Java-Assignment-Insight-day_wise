package java_assesment_day2_2_1;

//Class to represent a US phone number
public class PhoneNumber {
 private String areaCode;
 private String exchange;
 private String extension;

 // Constructor to initialize phone number parts
 public PhoneNumber(String areaCode, String exchange, String extension) {
     this.areaCode = areaCode;
     this.exchange = exchange;
     this.extension = extension;
 }

 // toString method to format the phone number
 @Override
 public String toString() {
     return "(" + areaCode + ") " + exchange + "-" + extension;
 }

 // equals method to compare phone numbers
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true;
     if (obj == null || getClass() != obj.getClass()) return false;
     PhoneNumber that = (PhoneNumber) obj;
     return areaCode.equals(that.areaCode) && exchange.equals(that.exchange) && extension.equals(that.extension);
 }
 
 public static void main(String[] args) {
     PhoneNumber p1 = new PhoneNumber("800", "867", "5309");
     PhoneNumber p2 = new PhoneNumber("800", "867", "5309");
     
     System.out.println(p1.toString());
     System.out.println(p1.equals(p2)); // Should print true
 }
}

