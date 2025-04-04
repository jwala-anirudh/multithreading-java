import java.util.Scanner;

/**
 * Following the code pattern from previous file, we are
 * now going to break the independent activities into their
 * individual classes to see if the problem can be overcome.
 * <p>
 * But still having different objects for different activities
 * doesn't solve the problem.
 */
class Alpha1 {
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

class Beta1 {
    public void focus() throws InterruptedException {
        System.out.println("Printing important message activity Started...");

        for (int i = 0; i < 4; i++) {
            System.out.println("Focus is the key...");
            Thread.sleep(4000);
        }

        System.out.println("Printing important message activity Completed...");
    }
}

class Gamma1 {
    public void printingStars() throws InterruptedException {
        System.out.println("Printing stars activity Started...");

        for (int i = 0; i < 4; i++) {
            System.out.println("* *");
            Thread.sleep(4000);
        }

        System.out.println("Printing stars activity Completed...");
    }
}

public class LaunchThread3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main method activity started...");

        Alpha1 a = new Alpha1();
        a.addition();

        Beta1 b = new Beta1();
        b.focus();

        Gamma1 g = new Gamma1();
        g.printingStars();

        System.out.println("Main method activity completed...");
    }
}
