package thread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    private int maxRequestInTimePeriod;
    private long timePeriodInSecs;
    private HitCounter hitCounter;

    public RateLimiter(int maxRequestInTimePeriod, long timePeriodInSecs) {
        this.maxRequestInTimePeriod = maxRequestInTimePeriod;
        this.timePeriodInSecs = timePeriodInSecs;
        this.hitCounter = new HitCounter();
    }

    private class HitCounter {
        private Queue<Long> timestampQueue;
        AtomicInteger hitCount = new AtomicInteger(0);
        HitCounter(){
            timestampQueue = new ArrayBlockingQueue<>(maxRequestInTimePeriod);
        }

        boolean hit(long time) {
            // remove expired elements
            boolean result = true;

            int x = hitCount.addAndGet(1);
            if (timestampQueue.isEmpty()) {
                timestampQueue.add(time);
            } else {
                while (!timestampQueue.isEmpty() && (time - timestampQueue.peek() > timePeriodInSecs)) timestampQueue.poll();
                try {
                    timestampQueue.add(time);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    result = false;
                }
            }
            System.out.println("Thread id "+ Thread.currentThread().getId()+", Request "+x+", hit="+result);

            return result;
        }

    }

    public boolean isAllow(long time){
        return hitCounter.hit(time);
    }


    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(20,3);

        Runnable runnable = () -> {
            int i = 0;
            while(i++ < 100){
                rateLimiter.isAllow(System.currentTimeMillis());
            }
        };

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.submit(runnable);

        for(int i =0;i < 10;i++){
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
