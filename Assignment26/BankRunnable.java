class BankAccount { private int balance = 1000;
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
            + " could not withdraw due to insufficient balance."
        );
    }
}
public synchronized int getBalance() {
    return balance;
}
}
class DepositTask implements Runnable { private BankAccount account;
DepositTask(BankAccount account) {
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
class WithdrawalTask implements Runnable { private BankAccount account;
WithdrawalTask(BankAccount account) {
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
public class BankRunnable { public static void main(String[] args) { BankAccount account = new BankAccount();
   Thread depositThread =
        new Thread(new DepositTask(account), "Deposit Thread");

    Thread withdrawalThread =
        new Thread(new WithdrawalTask(account), "Withdrawal Thread");

    System.out.println("Initial Balance: Rs. "
                       + account.getBalance());

    depositThread.start();
    withdrawalThread.start();

    try {
        depositThread.join();
        withdrawalThread.join();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    System.out.println("Final Balance: Rs. "
                       + account.getBalance());
}
 
}
