import producerConsumer.ProducerConsumer;

public class Main {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.produce();
                } catch (Exception e){
                    System.out.println("Producer Thread Interrupted");
                }

            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.consume();
                } catch (Exception e){
                    System.out.println("Consumer Thread Interrupted");
                }
            }
        });


        producerThread.start();
        consumerThread.start();
    }
}