package java_assesment_day5_exception_handaling;

class ContactStack {
    private Contact[] stack;
    private int top;
    public ContactStack(int size) { stack = new Contact[size]; top = -1; }
    public void push(Contact c) throws StackFullException, ContactValidationException {
        if (top == stack.length - 1) throw new StackFullException("Stack full");
        if (c.getMobileNumber() == null || !c.getMobileNumber().matches("[0-9]{10}")) throw new ContactValidationException("Invalid contact");
        stack[++top] = c;
        System.out.println("Pushed: " + c);
    }
    public Contact pop() throws StackEmptyException {
        if (top == -1) throw new StackEmptyException("Stack empty");
        return stack[top--];
    }
}

