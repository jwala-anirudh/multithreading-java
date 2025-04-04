class Producer1 extends Thread {
    Queue1 q;
    int i = 1;

    Producer1(Queue1 q) {
        this.q = q;
    }

    @Override
    public void run() {
        super.run();

        // Produce data infinite times
        while (true) {
            q.produce(i++);
        }
    }
}

class Consumer1 extends Thread {
    Queue1 q;

    Consumer1(Queue1 q) {
        this.q = q;
    }

    @Override
    public void run() {
        super.run();

        // Consume data infinite times
        while (true) {
            q.consume();
        }
    }
}

class Queue1 {
    int data;
    boolean flag = false;

    synchronized public void produce(int i) {
        try {
            if (flag == true) {
                System.out.println("Producer in wait state");
                wait();
            } else {
                data = i;
                System.out.println("I have Produced Data: " + data);

                flag = true;
                notify();
            }
        } catch (Exception e) {
            System.out.println("Producer Exception: " + e.getMessage());
        }
    }

    synchronized public void consume() {
        try {
            if (flag == false) {
                System.out.println("Consumer in wait state");
                wait();
            } else {
                System.out.println("I have Consumed Data: " + data);
                flag = false;
                notify();
            }
        } catch (Exception e) {
            System.out.println("Producer Exception: " + e.getMessage());
        }
    }
}

/**
 * To establish communication between threads of Producer and Consumer
 * 1) Use synchronized keyword for the responsible methods
 * 2) Use the wait() and notify() methods
 */
public class LaunchInterThread2 {
    public static void main(String[] args) {
        Queue1 q = new Queue1();

        Producer1 producer = new Producer1(q);
        Consumer1 consumer = new Consumer1(q);

        producer.start();
        consumer.start();
    }
}
