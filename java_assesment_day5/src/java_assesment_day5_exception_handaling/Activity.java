package java_assesment_day5_exception_handaling;

public class Activity {
    private String string1;
    private String string2;
    private String operator;

    public Activity() {}

    public Activity(String string1, String string2, String operator) {
        this.string1 = string1;
        this.string2 = string2;
        this.operator = operator;
    }

    public String getString1() { return string1; }
    public String getString2() { return string2; }
    public String getOperator() { return operator; }
}
