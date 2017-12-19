package stackTest.lsccStackTest;

/**
 * Created by 18435 on 2017/9/25.
 */
public class LinkStack {
    private StackNode topNode;
    private int count;

    public LinkStack() {
        this.topNode = null;
        this.count = 0;
    }

    //��ջ
    public void push(String data) {
        StackNode newNode = new StackNode(data);
        if (this.topNode == null) {
            this.topNode = newNode;
        } else {
            newNode.setNextNode(this.topNode);
            this.topNode = newNode;
        }
    }

    //��ջ
    public String pop() {
        if (this.topNode == null) {
            return "��ջ�ǿ�ջ�������Ԫ��";
        } else {
            StackNode oldNode = this.topNode;
            this.topNode = oldNode.getNextNode();
            return oldNode.getData();
        }
    }

    //ѭ�����ջ��Ԫ��
    public void show(){
        StackNode node = this.topNode;
        while(node!=null){
            System.out.println("node data-------------->"+node.getData());
            node = node.getNextNode();
        }
    }
}
