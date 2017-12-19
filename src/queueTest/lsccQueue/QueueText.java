package queueTest.lsccQueue;

/**
 * Created by 18435 on 2017/9/26.
 */
public class QueueText {
    private Node topQueue;//��ͷ  ��ͷ��
    private Node tailTeam;//��β  ��β��
    private int size;

    //��ʼ������
    public QueueText(){
        this.topQueue = null;
        this.tailTeam = null;
        this.size = 0;
    }

    /**
     * ����
     * @param data
     */
    public void inQueue(String data){
        Node newNode = new Node(data);
        if(this.size==0){
            newNode.setNextNode(newNode);
           this.tailTeam = this.topQueue = newNode;
        }else{//���¼����Ԫ�ز��뵽��β
            //�½���ǰһ��Ԫ����ԭ���Ķ�βԪ��
            //newNode.setPreviousNode(this.tailTeam);
            //�½��ĺ�һ��Ԫ���Ƕ�ͷԪ��
            newNode.setNextNode(this.topQueue);
            //ԭ����βԪ�صĺ��Ԫ������Ԫ��
            this.tailTeam.setNextNode(newNode);
            //��ͷԪ�ص�ǰһ��Ԫ������Ԫ��
            //this.topQueue.setPreviousNode(newNode);
            //�ı��βԪ��
            this.tailTeam = newNode;
        }
        this.size++;
    }

    /**
     * ����
     * @return  ��ͷԪ��
     */
    public String outQueue(){
        if(this.size<=0){
            return "�ö����ǿն���";
        }else{
            String data = this.topQueue.getData();//��ͷԪ�ص�ֵ
            //�ı��ͷԪ����һ��Ԫ�� ��ǰһ��Ԫ��Ϊ��βԪ��
            //this.topQueue.getNextNode().setPreviousNode(this.tailTeam);
            //�ı��βԪ�ص���һ��Ԫ��Ϊ ԭ��ͷԪ�ص���һ��Ԫ��
            this.tailTeam.setNextNode(this.topQueue.getNextNode());
            //�ı��ͷԪ��
            this.topQueue = this.topQueue.getNextNode();
            this.size--;
            return data;
        }
    }

    /**
     * ��ȡ���г���
     * @return
     */
    public int length(){
        return this.size;
    }

    /**
     * ѭ����������е�Ԫ��
     */
    public void showAll(){
        Node node = this.topQueue;
        for(int i=0;i<this.size;i++){
            System.out.println("��"+i+"��Ԫ��====>"+node.getData());
            node = node.getNextNode();
        }
    }

    /**
     * ��ն���
     */
    public void destoryQueue(){
        if(this.size<=0){
            System.out.println("�ö������Ѿ��ǿն���");
        }else{
            Node node = this.topQueue;
            for(int i=0;i<this.size;i++){
                Node nextNode = node.getNextNode();
                node.setNextNode(null);
                //node.setPreviousNode(null);
                node.setData(null);
                node = nextNode;
            }
            this.topQueue = this.tailTeam = null;
            this.size=0;
        }
    }

    /**
     * �����Ƿ�Ϊ�� �� ���� true
     *           ���� ���� false
     * @return
     */
    public boolean queueEmpty(){
        if(this.size==0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * ��ȡ��ͷԪ��
     * @return
     */
    public String getHead(){
        if(this.size<=0){
            return "�ö���Ϊ��";
        }else{
            return this.topQueue.getData();
        }
    }
}
