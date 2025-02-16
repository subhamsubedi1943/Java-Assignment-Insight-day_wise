package java_assesment_day5_exception_handaling;

public class Source {
    public static void main(String[] args) {
        Activity activity = new Activity("Hello", "Welcome", "+");
        Source source = new Source();

        try {
            if (!source.validate(activity)) throw new OperatorException("Invalid parameters");
            System.out.println(source.doOperation(activity));
        } catch (OperatorException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(Activity activity) throws OperatorException {
        if (activity.getString1() == null || activity.getString2() == null || activity.getOperator() == null)
            throw new NullPointerException("Null values not allowed");
        if (!activity.getOperator().equals("+") && !activity.getOperator().equals("-"))
            throw new OperatorException("Invalid operator: " + activity.getOperator());
        return true;
    }

    public String doOperation(Activity activity) {
        if (activity.getOperator().equals("+"))
            return activity.getString1() + activity.getString2();
        else
            return activity.getString1().replace(activity.getString2(), "");
    }
}

