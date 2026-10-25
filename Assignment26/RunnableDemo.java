class Task1 implements Runnable 
{
public void run() 
{
for (int i = 1; i <= 5; i++) {
System.out.println("Task 1: " + i);
try {
Thread.sleep(500);
} catch (InterruptedException e) {
Thread.currentThread().interrupt();
return;
}
}
}
}

class Task2 implements Runnable {
public void run() {
for (int i = 1; i <= 5; i++) {
System.out.println("Task 2: " + i);
try {
Thread.sleep(500);
} catch (InterruptedException e) {
Thread.currentThread().interrupt();
return;
}
}
}
}

public class RunnableDemo {
public static void main(String[] args) {
Task1 task1 = new Task1();
Task2 task2 = new Task2();

Thread t1 = new Thread(task1);
Thread t2 = new Thread(task2);

t1.start();
t2.start();
}
}
