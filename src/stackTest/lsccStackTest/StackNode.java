package stackTest.lsccStackTest;

/**
 * Created by 18435 on 2017/9/25.
 */
public class StackNode {
    private String data;
    private StackNode nextNode;

    public StackNode(){}

    public StackNode(String data){
        this.data = data;
    }
    public StackNode(String data,StackNode nextNode){
        this.data = data;
        this.nextNode = nextNode;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public StackNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(StackNode nextNode) {
        this.nextNode = nextNode;
    }
}
