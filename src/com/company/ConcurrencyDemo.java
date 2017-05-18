package com.company;

import static com.company.SimpleThreads.threadMessage;

class Thread1 extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread-1");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

class Thread2 extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread-2");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

class Thread3 implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread-3");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

class Thread4 implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread-4");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

public class ConcurrencyDemo{

    public static void main(String[] args) throws InterruptedException{

        // Use the classes above
        /*
        Thread t1 = new Thread(new Thread1());
        t1.start();

        Thread t2 = new Thread(new Thread2());
        t2.start();

        Thread t3 = new Thread(new Thread3());
        t3.start();

        Thread t4 = new Thread(new Thread4());
        t4.start();
        */

        // Use the classes from SimpleThreads class

        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 60 * 60;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new SimpleThreads.MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
