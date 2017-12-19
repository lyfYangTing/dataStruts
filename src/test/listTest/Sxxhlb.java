package test.listTest;

/**
 * Created by 18435 on 2017/10/10.
 * ˫��ѭ������
 */
public class Sxxhlb {
    private int length;
    private Node startNode;
    private Node endNode;

    public Sxxhlb() {
        this.length = 0;
        this.startNode = null;
        this.endNode = null;
    }

    public void add(int data) {
        if (this.length == 0) {
            Node newNode = new Node(data);
            this.startNode = newNode;
        } else if (this.length == 1) {
            Node newNode = new Node(data, this.startNode, this.startNode);
            this.startNode.setPrevious(newNode);
            this.startNode.setNext(newNode);
            this.endNode = newNode;
        } else {
            Node newNode = new Node(data, this.endNode, this.startNode);
            this.endNode.setNext(newNode);
            this.startNode.setPrevious(newNode);
            this.endNode = newNode;
        }
        this.length++;
    }

    public int remove(int index) {
        int olddata = 0;
        if (index < 0 || index > this.length) {
            olddata = -1;
            System.out.println("��ɾ����Ԫ�ز�����");
        } else {
            Node start = this.startNode;
            //�ҵ���ɾ��Ԫ��
            for (int i = 0; i < index - 1; i++) {
                start = start.getNext();
            }

            olddata = start.getData();
            //�ҵ���ɾ��Ԫ�صĺ�һ��Ԫ��
            Node next = start.getNext();
            //�ҵ���ɾ��Ԫ�ص�ǰһ��Ԫ��
            Node previous = start.getPrevious();

            previous.setNext(next);
            next.setPrevious(previous);

            if (index == 1) {
                this.startNode = next;
            }
            if (index == this.length) {
                this.endNode = previous;
            }
        }
        return olddata;
    }

    public void showList() {
        Node start = this.startNode;
        for (int i = 0; i < this.length; i++) {
            System.out.print("--" + start.getData());
            start = start.getNext();
        }
    }

    public int removeNode(Node removedNode) {
//        Node removedNode = null;
//        Node start = this.startNode;
//        int index = -1;
//        //�ҵ���ɾ��Ԫ��
//        for (int i = 0; i < this.length - 1; i++) {
//            if(olddata == start.getData()){
//                removedNode = start;
//                index = i+1;
//                break;
//            }
//            start = start.getNext();
//        }
//
//        if(removedNode==null){
//            System.out.println("��ɾ����Ԫ�ز�����");
//        }

        //�ҵ���ɾ��Ԫ�صĺ�һ��Ԫ��
        Node next = removedNode.getNext();
        //�ҵ���ɾ��Ԫ�ص�ǰһ��Ԫ��
        Node previous = removedNode.getPrevious();

        previous.setNext(next);
        next.setPrevious(previous);

        if (removedNode == this.startNode) {
            this.startNode = next;
        }
        if (removedNode == this.endNode) {
            this.endNode = previous;
        }
        return removedNode.getData();
    }

    public void josePhus(int n, int m) {//������ ѭ������ �ؼ�����
        Node start = this.startNode;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<m;j++){
                start = start.getNext();
            }
            System.out.println("--"+start.getData());
            this.removeNode(start);
            start = start.getNext();
        }
    }

    public static void main(String[] args) {
        Sxxhlb sxxhlb = new Sxxhlb();
        for (int i = 1; i <= 7; i++) {
            sxxhlb.add(i);
        }
        sxxhlb.showList();
        System.out.println();
        sxxhlb.josePhus(7, 2);
    }
}
