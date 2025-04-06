package debugging;

public class LaunchThread2 {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Task from new Thread");

        // Thread t = new Thread(runnable);

        Thread t = new Thread(() -> System.out.println("Task from new Thread"));
        t.start();
    }
}
