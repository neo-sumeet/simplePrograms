package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    static int counter = 0;
    static boolean consumed = true;
    static boolean stop = false;
    static Lock lock = new ReentrantLock();
    static Condition consumedCondition = lock.newCondition();
    static Condition producedCondition = lock.newCondition();

    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        Runnable producerRunnable = () -> {
            while(!stop) {
                System.out.println("P1 ");

                if(lock.tryLock()) {
                    while (!consumed) {
                        try {
                            System.out.println("Waiting for counter to be consumed");
                            consumedCondition.await();
                        } catch (InterruptedException e) {
                            System.out.println("Comsumption notified to producer");
                        }
                    }
                }
                if(lock.tryLock()){
                    System.out.println("Produced " + ++counter);
                    consumed = false;
                    lock.unlock();
                    producedCondition.signal();
                }
            }
        };

        Runnable consumerRunnable = () -> {
            while (!stop) {
                System.out.println("C1 ");

                if (lock.tryLock()) {
                    while (consumed) {
                        try {
                            System.out.println("Waiting for counter to be produced");
                            producedCondition.await();
                        } catch (InterruptedException e) {
                            System.out.println("Production notified to producer");

                        }
                    }
                }
                if(lock.tryLock()){
                    System.out.println("Consumed " + counter);
                    consumed = true;
                    if (counter == 10) stop = true;
                    lock.unlock();
                }
            }
        };


        executorService.submit(producerRunnable);
        executorService.submit(consumerRunnable);
        executorService.shutdown();
    }
}


