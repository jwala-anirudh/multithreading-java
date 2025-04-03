public class Main {
    public static void main(String[] args) throws InterruptedException {
        // By default, we are given one thread
        // that is called as DEFAULT thread
        // that runs the program code
        System.out.println("Application Started...");

        Thread.sleep(5000);

        System.out.println("Application Terminated...");
    }
}
