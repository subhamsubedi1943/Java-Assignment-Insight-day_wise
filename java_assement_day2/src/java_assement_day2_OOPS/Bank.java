package java_assement_day2_OOPS;

class Bank {
    int deposit(int amount, int balance) {
        return balance + amount;
    }

    int withdraw(int amount, int balance) {
        return (balance >= amount) ? (balance - amount) : 0;
    }

    public static void main(String[] args) {
        Bank b = new Bank();
        int balance = 5000;
        balance = b.deposit(2000, balance);
        System.out.println("Balance after deposit: " + balance);
        balance = b.withdraw(3000, balance);
        System.out.println("Balance after withdrawal: " + balance);
    }
}
