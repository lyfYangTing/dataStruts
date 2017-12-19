package staticLinkedList;

/**
 * Created by 18435 on 2017/9/22.
 */
public class StaticLinkedList {
    private final int maxSize = 1000;
    private Node[] linkList;
    private int size;//链表的长度

    /**
     *  初始化链表 设置链表最大长度为maxSize
     */
    public StaticLinkedList(){
        this.linkList = new Node[maxSize];
        //将还未使用的数组元素串成   备用链表
        for(int i=0;i<maxSize-1;i++){
            //对数组的第一个元素不存放数据，其cur值存放备用链表第一个结点的下标
            Node node = new Node(i+1);
            linkList[i] = node;
        }
        //数组最后一个元素的cur值为第一个插入元素的下标，刚开始链表为空，所以cur值存放0
        Node node = new Node(0);
        linkList[maxSize-1] = node;
    }

    /**
     * 获取备用链表的头结点下标
     * @return
     */
    public int getByIndex(){
        //获取备用链表中的头结点
        int oldByNode = this.linkList[0].getCur();
        //获取备用链表中的第二个结点 并将其数组下表给lingList[0].cur 则其为最新的备用链表的头结点
        int newByNode = this.linkList[oldByNode].getCur();
        this.linkList[0].setCur(newByNode);
        return oldByNode;
    }

    /**
     * 添加元素  返回的值是备用链表的头结点下标
     * @param data
     */
    public void add(String data){
        //获取备用链表头结点下标
        int newIndex = this.getByIndex();
        //插入第一个元素时将其下标赋值给数组最后一个元素的cur值
        if(this.size==0){
            this.linkList[this.maxSize-1].setCur(newIndex);
        }else{
            //找到链表的最后一个元素，改变其cur值
            int index = this.linkList[this.maxSize-1].getCur();
            for(int i=0;i<this.size;i++){
                Node node = this.linkList[index];
                index = node.getCur();
                if(i+1==this.size){
                    node.setCur(newIndex);
                }
            }
        }
        //将新节点放到链表的最后位置
        Node node = new Node(data,0);
        //将新节点放入数组中
        this.linkList[newIndex] = node;
        size++;
    }

    /**
     * 将元素插入到指定位置
     * @param data
     * @param zdIndex 指定的位置
     */
    public void add(String data,int zdIndex){
        if(zdIndex<0 || zdIndex>size){
            System.out.println("该位置在链表中不存在！");
        }else{
            //获取备用链表头结点下标
            int newIndex = this.getByIndex();
            //插入第一个元素时将其下标赋值给数组最后一个元素的cur值
            if(zdIndex==1){
                //获取原来的第一个元素下标
                int oldIndex = this.linkList[this.maxSize-1].getCur();
                //将新插入的元素下标赋值给数组的最后一个元素
                this.linkList[this.size-1].setCur(newIndex);
                //将新节点放到链表第一个位置
                Node newNode = new Node(data,oldIndex);
                this.linkList[newIndex] = newNode;
            }else{
                //找到链表zdIndex位置的前一个元素，改变其cur值
                int index = this.linkList[this.maxSize-1].getCur();//链表的第一个元素下标
                for(int i=0;i<zdIndex-1;i++){
                    Node node = this.linkList[index];
                    index = node.getCur();
                    if(i+1 == zdIndex-1){
                        //node.getCur() 此时node中存放的是原来node结点后继元素的坐标 将其赋值给新元素
                        //将新节点放到链表指定位置
                        Node newNode = new Node(data,node.getCur());
                        //将新节点放入数组中
                        this.linkList[newIndex] = newNode;
                        node.setCur(newIndex);
                    }
                }
            }
            size++;
        }
    }

    /**
     * 获取链表指定位置的元素
     * @param x
     * @return
     */
    public Node get(int x){
        Node node = new Node();
        int index = this.linkList[this.maxSize-1].getCur();//第一个元素
        if(x<0 || x>size){
            System.out.println("该元素在链表中不存在！");
        }else{
            for(int i = 0;i<x;i++){
                node = this.linkList[index];
                index = this.linkList[index].getCur();
            }
        }
        return node;
    }

    /**
     * 输出链表中的所有元素
     */
    public void showAllNodes(){
        int index = this.linkList[this.maxSize-1].getCur();
        for(int i=0;i<size;i++){
            Node node = this.linkList[index];
            System.out.println((i+1)+"-------->"+node);
            index = node.getCur();
        }
    }

    /**
     * 获取链表长度
     * @return
     */
    public int length(){
        return this.size;
    }

    /**
     * 移除指定位置的元素
     * @param index
     */
    public void remove(int index){
        if(index<0 || index>size){
            System.out.println("该元素在链表中不存在！");
        }else if(index==1){//删除第一个元素
            // 将listLinked[maxSize-1]的cur值该为其后继元素的下标
            System.out.println("linkList[this.maxSize-1]===============>"+linkList[this.maxSize-1]);
            int removeIndex = this.linkList[this.maxSize-1].getCur();//1
            Node removedNode = this.linkList[removeIndex];//one==========>4
            System.out.println("removedNode.getCur()============>"+removedNode.getCur());
            //将被删除元素的前一个元素指向被删除元素的后继元素
            this.linkList[this.maxSize-1].setCur(removedNode.getCur());
            //将被删除元素的元素回收到到备用链表的头结点处
            removedNode.setCur(this.linkList[0].getCur());
            this.linkList[0].setCur(removeIndex);
            this.size--;
        }else{
            //找到被删除元素的前一个元素
            int previousIndex = this.linkList[this.maxSize-1].getCur();
            for(int i=0;i<index-1;i++){
                Node previousNode = this.linkList[previousIndex];
                previousIndex = this.linkList[previousIndex].getCur();
                if(i+1 == index-1){//找到了被删除元素的前一个元素
                    Node removedNode = this.linkList[previousNode.getCur()];
                    int removeIndex = previousNode.getCur();
                    if(index==this.size){//如果删除的是最后一个元素，则其前一个元素变为最后一个元素
                        previousNode.setCur(0);
                    }else{
                        //将被删除元素的前一个元素指向被删除元素的后继元素
                        previousNode.setCur(removedNode.getCur());
                    }
                    //将被删除元素的元素回收到到备用链表的头结点处
                    removedNode.setCur(this.linkList[0].getCur());
                    this.linkList[0].setCur(removeIndex);
                }
            }
            this.size--;
        }
    }
}
