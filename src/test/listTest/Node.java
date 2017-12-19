package test.listTest;

/**
 * Created by 18435 on 2017/11/1.
 */
public class Node {
    private int data;
    private Node next;
    private Node previous;

    public Node(int data,Node next,Node previous){
        this.previous = previous;
        this.next = next;
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node(int data){
        this.data = data;
    }
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
