class BankAccount {
    private int balance = 1000;
 
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(
            Thread.currentThread().getName()
            + " deposited Rs. " + amount
            + " | Balance: Rs. " + balance
        );
    }
 
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                Thread.currentThread().getName()
                + " withdrew Rs. " + amount
                + " | Balance: Rs. " + balance
            );
        } else {
            System.out.println(
                Thread.currentThread().getName()
                + " could not withdraw Rs. " + amount
                + " due to insufficient balance."
            );
        }
    }
 
    public synchronized int getBalance() {
        return balance;
    }
}
 
class DepositThread extends Thread {
    private BankAccount account;
 
    DepositThread(BankAccount account) {
        this.account = account;
    }
 
    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.deposit(500);
 
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
 
class WithdrawalThread extends Thread {
    private BankAccount account;
 
    WithdrawalThread(BankAccount account) {
        this.account = account;
    }
 
    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.withdraw(300);
 
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
 
public class BankTransaction {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
 
        DepositThread deposit = new DepositThread(account);
        WithdrawalThread withdrawal = new WithdrawalThread(account);
 
        deposit.setName("Deposit Thread");
        withdrawal.setName("Withdrawal Thread");
 
        System.out.println("Initial Balance: Rs. "
                           + account.getBalance());
 
        deposit.start();
        withdrawal.start();
 
        try {
            deposit.join();
            withdrawal.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
 
        System.out.println("Final Balance: Rs. "
                           + account.getBalance());
        System.out.println("All transactions completed.");
    }
}
