public class LaunchThread1 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * By default, we are given one thread
         * that is called as DEFAULT thread
         * which runs the program code
         */
        System.out.println("Application Started...");

        // Thread.sleep(5000);

        // Accessing static method of currentThread()
        Thread thread = Thread.currentThread();

        // Name of DEFAULT thread is "main"
        System.out.println(thread.getName());

        // Every thread will have a priority ranging from 1-10
        System.out.println(thread.getPriority());

        Thread.sleep(4000);

        thread.setName("Anirudh");
        thread.setPriority(4);

        System.out.println(thread.getName());
        System.out.println(thread.getPriority());

        // Default and user defined threads in java are managed by Thread class

        System.out.println("Application Terminated...");
    }
}
