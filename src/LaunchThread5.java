import java.util.Scanner;

class Alpha3 implements Runnable {
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

class Beta3 implements Runnable {
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

class Gamma3 implements Runnable {
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

public class LaunchThread5 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main method activity started...");

        Alpha3 a = new Alpha3();
        Beta3 b = new Beta3();
        Gamma3 g = new Gamma3();

        /**
         * Since the above class have implemented Runnable,
         * inorder to execute them we must create a Thread
         * object and using that we pass the context
         * <p>
         * Using the thread object only we can further make
         * start() calls as they are not available at the
         * interface level. Hence, all the thread related
         * management is done by the Thread class.
         */
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(g);

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main method activity completed...");
    }
}
