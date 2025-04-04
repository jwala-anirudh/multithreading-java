import java.util.Scanner;

class Activity implements Runnable {
    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();

            if (threadName.equals("ADD")) {
                addition();
            } else if (threadName.equals("FOCUS")) {
                focus();
            } else {
                printingStars();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
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

    public void focus() throws InterruptedException {
        System.out.println("Printing important message activity Started...");

        for (int i = 0; i < 4; i++) {
            System.out.println("Focus is the key...");
            Thread.sleep(4000);
        }

        System.out.println("Printing important message activity Completed...");
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

public class LaunchThread6 {
    public static void main(String[] args) {
        Activity a = new Activity();

        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(a);
        Thread thread3 = new Thread(a);

        thread1.setName("ADD");
        thread2.setName("FOCUS");
        thread3.setName("STAR");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
