package queueTest.lsccQueue;

/**
 * Created by 18435 on 2017/9/26.
 */
public class Test {

    public static void main(String[] args){
        QueueText queueText = new QueueText();
        queueText.inQueue("one");
        queueText.inQueue("two");
        queueText.inQueue("three");
        queueText.showAll();
        System.out.println("queue 出队列---》"+queueText.outQueue());
        queueText.showAll();
        System.out.println("queue 出队列---》"+queueText.outQueue());
        queueText.showAll();
        System.out.println("queue 出队列---》"+queueText.outQueue());
        queueText.showAll();
        System.out.println("queue 出队列---》"+queueText.outQueue());
        queueText.inQueue("one");
        queueText.showAll();
    }
}
