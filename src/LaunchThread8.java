import java.util.Scanner;

class Alpha4 implements Runnable {
    @Override
    public void run() {
        addition();
    }

    public void addition() {
        System.out.println("Addition Activity Started...");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Number for Addition: ");
        int num1 = sc.nextInt();
        System.out.println("Enter Second Number for Addition: ");
        int num2 = sc.nextInt();
        int result = num1 + num2;

        System.out.println("Result is: " + result);

        System.out.println("Addition Activity Completed...");
    }
}

class Beta4 implements Runnable {
    @Override
    public void run() {
        try {
            focus();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void focus() throws InterruptedException {
        System.out.println("Printing important message activity Started...");

        for (int i = 0; i < 4; i++) {
            System.out.println("Focus is the key...");
            Thread.sleep(4000);
        }

        System.out.println("Printing important message activity Completed...");
    }
}

class Gamma4 implements Runnable {
    @Override
    public void run() {
        try {
            printingStars();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printingStars() throws InterruptedException {
        System.out.println("Printing stars activity Started...");

        for (int i = 0; i < 4; i++) {
            System.out.println("* *");
            Thread.sleep(4000);
        }

        System.out.println("Printing stars activity Completed...");
    }
}

/**
 * Before JOIN,
 * main method starts execution and ends hands over
 * the control of execution to other threads.
 *
 * After JOIN,
 * I want the main thread to wait until, all the other
 * threads are completed in execution and then I will
 * proceed forward with mine.
 */
public class LaunchThread8 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main method activity started...");

        Alpha3 a = new Alpha3();
        Beta3 b = new Beta3();
        Gamma3 g = new Gamma3();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(g);

        System.out.println(t1.isAlive()); // false
        System.out.println(t2.isAlive()); // false
        System.out.println(t3.isAlive()); // false

        t1.start();
        t2.start();
        t3.start();

        t1.join(); // unless and until t1 completes we don't move forward
        t2.join(); // similarly for t2
        t3.join(); // and for t3

        // main thread has to wait until the before joined thread are done

        System.out.println(t1.isAlive()); // true
        System.out.println(t2.isAlive()); // true
        System.out.println(t3.isAlive()); // true

        System.out.println("Main method activity completed...");
    }
}
