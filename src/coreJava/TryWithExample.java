package coreJava;

public class TryWithExample {
    static class Demo1 implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("Closing Demo1");
        }
    }
    static class Demo2 implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("Closing Demo2");
        }
    }

    public static void main(String[] args) {
        try(Demo1 demo1 = new Demo1();
        Demo2 demo2 = new Demo2()){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
