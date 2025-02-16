package java_assement_day2_OOPS;


class Account {
    int accountNo;
    String accountType;
    int accountBalance;

    void setAccountDetails(int accountNo, String accountType, int accountBalance) {
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    void withdraw() {
        if (accountBalance >= 1000) {
            accountBalance -= 1000;
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void deposit() {
        accountBalance += 1000;
    }

    void dispAccountDetails() {
        System.out.println("Account No: " + accountNo + ", Type: " + accountType + ", Balance: " + accountBalance);
    }
}

public class AccMain {
    public static void main(String[] args) {
        Account acc = new Account();
        acc.setAccountDetails(12345, "Savings", 5000);
        acc.dispAccountDetails();
        acc.withdraw();
        acc.dispAccountDetails();
        acc.deposit();
        acc.dispAccountDetails();
    }
}
