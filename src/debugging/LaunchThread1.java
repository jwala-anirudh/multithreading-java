package debugging;

public class LaunchThread1 extends Thread {
    public LaunchThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Task for my new threads");
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");

        /**
        LaunchThread1 t1 = new LaunchThread1();
        LaunchThread1 t2 = new LaunchThread1();

        t1.setName("MyThread1");
        t2.setName("MyThread2");
        */
        LaunchThread1 t1 = new LaunchThread1("MyThread1");
        LaunchThread1 t2 = new LaunchThread1("MyThread2");

        t1.start();
        t2.start();

        System.out.println("Main thread concluded");
    }
}
