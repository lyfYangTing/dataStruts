package queueTest.lsccQueue;

/**
 * Created by 18435 on 2017/9/26.
 */
public class QueueText {
    private Node topQueue;//队头  队头出
    private Node tailTeam;//队尾  队尾进
    private int size;

    //初始化队列
    public QueueText(){
        this.topQueue = null;
        this.tailTeam = null;
        this.size = 0;
    }

    /**
     * 进队
     * @param data
     */
    public void inQueue(String data){
        Node newNode = new Node(data);
        if(this.size==0){
            newNode.setNextNode(newNode);
           this.tailTeam = this.topQueue = newNode;
        }else{//将新加入的元素插入到队尾
            //新结点的前一个元素是原来的队尾元素
            //newNode.setPreviousNode(this.tailTeam);
            //新结点的后一个元素是队头元素
            newNode.setNextNode(this.topQueue);
            //原来队尾元素的后继元素是新元素
            this.tailTeam.setNextNode(newNode);
            //队头元素的前一个元素是新元素
            //this.topQueue.setPreviousNode(newNode);
            //改变队尾元素
            this.tailTeam = newNode;
        }
        this.size++;
    }

    /**
     * 出队
     * @return  队头元素
     */
    public String outQueue(){
        if(this.size<=0){
            return "该队列是空队列";
        }else{
            String data = this.topQueue.getData();//队头元素的值
            //改变队头元素下一个元素 的前一个元素为队尾元素
            //this.topQueue.getNextNode().setPreviousNode(this.tailTeam);
            //改变队尾元素的下一个元素为 原队头元素的下一个元素
            this.tailTeam.setNextNode(this.topQueue.getNextNode());
            //改变队头元素
            this.topQueue = this.topQueue.getNextNode();
            this.size--;
            return data;
        }
    }

    /**
     * 获取队列长度
     * @return
     */
    public int length(){
        return this.size;
    }

    /**
     * 循环输出队列中的元素
     */
    public void showAll(){
        Node node = this.topQueue;
        for(int i=0;i<this.size;i++){
            System.out.println("第"+i+"个元素====>"+node.getData());
            node = node.getNextNode();
        }
    }

    /**
     * 清空队列
     */
    public void destoryQueue(){
        if(this.size<=0){
            System.out.println("该队列是已经是空队列");
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
     * 队列是否为空 是 返回 true
     *           不是 返回 false
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
     * 获取队头元素
     * @return
     */
    public String getHead(){
        if(this.size<=0){
            return "该队列为空";
        }else{
            return this.topQueue.getData();
        }
    }
}
