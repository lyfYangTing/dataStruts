package queueTest.lsccQueue;

/**
 * Created by 18435 on 2017/9/26.
 */
public class Node {
    private String data;
    private Node nextNode;
    //private Node previousNode;

    public Node(){}

    public Node(String data){
        this.data = data;
    }
//    public Node(String data,Node nextNode,Node previousNode){
//        this.data = data;
//        this.nextNode = nextNode;
//        this.previousNode = previousNode;
//    }
//
//    public Node getPreviousNode() {
//        return previousNode;
//    }
//
//    public void setPreviousNode(Node previousNode) {
//        this.previousNode = previousNode;
//    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
