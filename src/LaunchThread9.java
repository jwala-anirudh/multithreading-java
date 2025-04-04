class Library implements Runnable {
    // Resources (limited)
    String java = new String("Java");
    String devOps = new String("DevOps");
    String aws = new String("Cloud AWS");

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        if (name.equals("Rohan")) {
            try {
                System.out.println("Rohan got into Library");
                Thread.sleep(4000);

                synchronized (java) {
                    System.out.println("Rohan has acquired Java Book");
                    Thread.sleep(4000);

                    synchronized (devOps) {
                        System.out.println("Rohan has acquired DevOps Book");
                        Thread.sleep(4000);

                        synchronized (aws) {
                            System.out.println("Rohan has acquired AWS Book");
                            Thread.sleep(4000);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("ROHAN Error: " + e.getMessage());
            }
        } else {
            try {
                System.out.println("Bishnu got into Library");
                Thread.sleep(4000);

                synchronized (java) {
                    System.out.println("Bishnu has acquired Java Book");
                    Thread.sleep(4000);

                    synchronized (devOps) {
                        System.out.println("Bishnu has acquired DevOps Book");
                        Thread.sleep(4000);

                        synchronized (aws) {
                            System.out.println("Bishnu has acquired AWS Book");
                            Thread.sleep(4000);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("BISHNU Error: " + e.getMessage());
            }
        }

    }
}

public class LaunchThread9 {
    public static void main(String[] args) {
        Library lib = new Library();

        Thread t1 = new Thread(lib);
        Thread t2 = new Thread(lib);

        t1.setName("Rohan");
        t2.setName("Bishnu");

        t1.start();
        t2.start();
    }
}
