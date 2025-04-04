/**
 * Resource is common, but we have to create
 * multiple threads
 */

class MyParkingLot implements Runnable {
    @Override
    synchronized public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " has entered the parking lot.");
            Thread.sleep(4000);

            System.out.println(Thread.currentThread().getName() + " has entered into car.");
            Thread.sleep(4000);

            System.out.println(Thread.currentThread().getName() + " started to drive car.");
            Thread.sleep(4000);

            System.out.println(Thread.currentThread().getName() + " has come back and parked the car.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class MyCar implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " has entered the parking lot.");
            Thread.sleep(4000);

            System.out.println(Thread.currentThread().getName() + " has entered into car.");
            Thread.sleep(4000);

            synchronized(this) {
                System.out.println(Thread.currentThread().getName() + " started to drive car.");
                Thread.sleep(4000);

                System.out.println(Thread.currentThread().getName() + " has come back and parked the car.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class LaunchThread7 {
    static void methodLevelLocking() {
        MyParkingLot parkingLot = new MyParkingLot();

        Thread p1 = new Thread(parkingLot);
        Thread p2 = new Thread(parkingLot);
        Thread p3 = new Thread(parkingLot);

        p1.setName("RAMESH PARKING LOT");
        p2.setName("SURESH PARKING LOT");
        p3.setName("DINESH PARKING LOT");

        p1.start();
        p2.start();
        p3.start();
    }

    static void blockLevelLocking() {
        MyCar car = new MyCar();

        Thread car1 = new Thread(car);
        Thread car2 = new Thread(car);
        Thread car3 = new Thread(car);

        car1.setName("RAMESH CAR");
        car2.setName("SURESH CAR");
        car3.setName("DINESH CAR");

        car1.start();
        car2.start();
        car3.start();
    }

    public static void main(String[] args) {
        methodLevelLocking();
        blockLevelLocking();

        /**
         * Problem in this code: the car is a shared resource,
         * and multiple threads are trying to access it simultaneously
         * without considering thread safety, leading to inconsistent behavior.
         *
         * To ensure proper synchronization and data consistency,
         * we need to enforce mutual exclusion so that only one thread
         * can access the critical section at a time.
         *
         * Solutions:
         * - Method-level locking (using synchronized methods)
         * - Block-level locking (using synchronized blocks on specific objects)
         *
         * The "synchronized" keyword in Java ensures that only one thread
         * can execute the synchronized code block or method at a time,
         * making it thread-safe.
         *
         * Java String Classes Comparison:
         * - StringBuffer: Synchronized, Thread-safe (slower, safe for multi-threading)
         * - StringBuilder: Not synchronized, Not thread-safe (faster, not safe for multi-threading)
         *
         * Note:
         * - Thread safety is essential when multiple threads access shared resources.
         * - Synchronization can reduce performance due to blocking, so use only when necessary.
         */
    }
}
