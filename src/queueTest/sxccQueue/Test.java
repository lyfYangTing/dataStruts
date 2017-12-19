package queueTest.sxccQueue;

/**
 * Created by 18435 on 2017/9/26.
 */
public class Test {

    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.inQueue("one");
        arrayQueue.inQueue("two");
        arrayQueue.inQueue("three");
        arrayQueue.inQueue("four");
        arrayQueue.inQueue("five");

        arrayQueue.showAll();
        System.out.println("outQueue---------->"+arrayQueue.outQueue());
        System.out.println("outQueue---------->"+arrayQueue.outQueue());
        arrayQueue.showAll();
        arrayQueue.inQueue("one");
        arrayQueue.inQueue("two");
        System.out.println("-----------------------------------");
        arrayQueue.showAll();
        System.out.println("outQueue---------->"+arrayQueue.outQueue());
        System.out.println("outQueue---------->"+arrayQueue.outQueue());
        System.out.println("outQueue---------->"+arrayQueue.outQueue());
        System.out.println("outQueue---------->"+arrayQueue.outQueue());
        System.out.println("outQueue---------->"+arrayQueue.outQueue());
        arrayQueue.showAll();
        System.out.println("outQueue---------->"+arrayQueue.outQueue());
    }
}
