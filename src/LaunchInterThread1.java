class Producer extends Thread {
    Queue q;
    int i = 1;

    Producer(Queue q) {
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

class Consumer extends Thread {
    Queue q;

    Consumer(Queue q) {
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

class Queue {
    int data;

    public void produce(int i) {
        data = i;
        System.out.println("I have Produced Data: " + data);
    }

    public void consume() {
        System.out.println("I have Consumed Data: " + data);
    }
}

public class LaunchInterThread1 {
    public static void main(String[] args) {
        Queue q = new Queue();

        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        producer.start();
        consumer.start();
    }
}
