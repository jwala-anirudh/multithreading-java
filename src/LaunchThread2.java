import java.util.Scanner;

/**
 * In this example code we can see there are three independent activities
 * but due to the interruption that needs user input for addition() the rest
 * two functions which are totally independent have to wait until
 * the DEFAULT thread comes to execute them.
 */
class Alpha {
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

public class LaunchThread2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main method activity started...");

        Alpha a = new Alpha();
        a.addition();
        a.focus();
        a.printingStars();

        System.out.println("Main method activity completed...");
    }
}
