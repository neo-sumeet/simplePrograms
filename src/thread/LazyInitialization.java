package thread;

public class LazyInitialization {
    private static boolean initialized = false;

    static {
        Thread t = new Thread(() -> {initialized = true;});
        t.start();
        try {
            t.wait();
            t.join(); // deadloack state. cannot set initialized = true because for it to be set, the main thread of class LazyInitialization should be loaded. For that to happen,
            // static block should be comletely executed. since t.join prevents it, we have a resource trying to use another resource which is not loaded yet causing deadlock
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(initialized);

    }
}
