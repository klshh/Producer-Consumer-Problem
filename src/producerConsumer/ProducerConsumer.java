package producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private final Queue<Integer> buffer = new LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0;
        while(true){
            synchronized (this){
                int BUFFER_SIZE = 5;
                while(buffer.size() == BUFFER_SIZE){
//                    queue size if full,producer has to wait till the queue size is less the BUFFER_SIZE
                    System.out.println("Queue size is full unable to produce more");
                    wait();
                }
                System.out.println("Producer produce: "+ value);
                buffer.offer(value++);

//                notify all consumers to consume as producer produces some data
                notifyAll();
            }


            Thread.sleep(2000);
        }
    }

    public void consume() throws InterruptedException {
        while(true){

//            here lock is acquired on the object of this class, so here either produce or consumer function will execute at a time
            synchronized (this){
                while(buffer.isEmpty()){
                    System.out.println("Buffer is empty, Consumer is waiting..!!!");
                    wait();
                }

                int value = buffer.poll();
                System.out.println("Consumer consumes: " + value);

//                noitfy all producers as cosumer consumes some data
                notifyAll();
            }

            Thread.sleep(10000);
        }
    }
}
