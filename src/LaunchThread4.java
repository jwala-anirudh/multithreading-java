import java.util.Scanner;

class Alpha2 extends Thread {
    @Override
    public void run() {
        super.run();
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

class Beta2 extends Thread {
    @Override
    public void run() {
        super.run();
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

class Gamma2 extends Thread {
    @Override
    public void run() {
        super.run();
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

public class LaunchThread4 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main method activity started...");

        /**
         * Apart from main thread, three threads can be created
         * as each class is extending the Thread class
         */
        Alpha2 a = new Alpha2();
        Beta2 b = new Beta2();
        Gamma2 g = new Gamma2();

        a.start();
        b.start();
        g.start();

        /**
         * If we directly call the run() method
         * then its equal to that of a single-threaded
         * no benefit of using threads
         * <p>
         * a.run();
         * b.run();
         * g.run();
         */

        System.out.println("Main method activity completed...");
    }
}
