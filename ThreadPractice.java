public class ThreadPractice {

    public static void main(String args[]) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("Hello from thread: " + Thread.currentThread().getName() + " Thread is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(r);
        t1.start();
        t1.join();
        System.out.println("Main thread: " + Thread.currentThread().getName());

        Runnable tr = () -> {
            try {
                Thread.sleep(10000);
                System.out.println("I am tr");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread a2 = new Thread(tr) {
            @Override
            public void run() {
                super.run();
                System.out.println("Thread a2 is running");

            }
        };
        a2.start();

        Runnable another = () -> {
                try {
                    for(int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        System.out.println("I am another thread " + Thread.currentThread().getName() + " Thread is running ");
                        Thread.yield();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        };
        Thread an1 = new Thread(another, "A");
        Thread an2 = new Thread(another, "B");
        an1.start();
        an2.start();

        ThreadPractice pc = new ThreadPractice();

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                pc.increment();
            }
        }, "Incrementer");
        Thread t3 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                pc.increment();
            }
        }, "Incrementer2");
        t2.start();
        t3.start();
        System.out.println("value of  count "+ pc.getCount() + " before joining threads");
        t2.join();
        t3.join();
        System.out.println("value of count after joining threads " + pc.getCount());

        Runnable wr = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    System.out.println("The current thread is "+Thread.currentThread().getName());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        }

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    }







