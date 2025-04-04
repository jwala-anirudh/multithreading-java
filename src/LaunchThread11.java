class MSWord extends Thread {
    @Override
    public void run() {
        super.run();

        String threadName = Thread.currentThread().getName();

        if (threadName.equals("TYPING")) {
            typing();
        } else if (threadName.equals("SPELL-CHECK")) {
            spellCheck();
        } else {
            saving();
        }
    }

    public void typing() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("Typing...");
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            System.out.println("Typing Error: " + e.getMessage());
        }
    }

    public void spellCheck() {
        try {
            for (;;) {
                System.out.println("Spell Checking...");
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            System.out.println("Spell Check Error: " + e.getMessage());
        }
    }

    public void saving() {
        try {
            for (;;) {
                System.out.println("Saving...");
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            System.out.println("Saving Error: " + e.getMessage());
        }
    }
}

public class LaunchThread11 {
    public static void main(String[] args) {
        MSWord t1 = new MSWord();
        MSWord t2 = new MSWord();
        MSWord t3 = new MSWord();

        t1.setName("TYPING");
        t2.setName("SPELL-CHECK");
        t3.setName("AUTO-SAVE");

        t2.setDaemon(true);
        t3.setDaemon(true);

        t2.setPriority(4);
        t3.setPriority(3);

        t1.start();
        t2.start();
        t3.start();
    }
}
