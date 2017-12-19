package staticLinkedList;

/**
 * Created by 18435 on 2017/9/22.
 */
public class StaticLinkedList {
    private final int maxSize = 1000;
    private Node[] linkList;
    private int size;//����ĳ���

    /**
     *  ��ʼ������ ����������󳤶�ΪmaxSize
     */
    public StaticLinkedList(){
        this.linkList = new Node[maxSize];
        //����δʹ�õ�����Ԫ�ش���   ��������
        for(int i=0;i<maxSize-1;i++){
            //������ĵ�һ��Ԫ�ز�������ݣ���curֵ��ű��������һ�������±�
            Node node = new Node(i+1);
            linkList[i] = node;
        }
        //�������һ��Ԫ�ص�curֵΪ��һ������Ԫ�ص��±꣬�տ�ʼ����Ϊ�գ�����curֵ���0
        Node node = new Node(0);
        linkList[maxSize-1] = node;
    }

    /**
     * ��ȡ���������ͷ����±�
     * @return
     */
    public int getByIndex(){
        //��ȡ���������е�ͷ���
        int oldByNode = this.linkList[0].getCur();
        //��ȡ���������еĵڶ������ �����������±��lingList[0].cur ����Ϊ���µı��������ͷ���
        int newByNode = this.linkList[oldByNode].getCur();
        this.linkList[0].setCur(newByNode);
        return oldByNode;
    }

    /**
     * ���Ԫ��  ���ص�ֵ�Ǳ��������ͷ����±�
     * @param data
     */
    public void add(String data){
        //��ȡ��������ͷ����±�
        int newIndex = this.getByIndex();
        //�����һ��Ԫ��ʱ�����±긳ֵ���������һ��Ԫ�ص�curֵ
        if(this.size==0){
            this.linkList[this.maxSize-1].setCur(newIndex);
        }else{
            //�ҵ���������һ��Ԫ�أ��ı���curֵ
            int index = this.linkList[this.maxSize-1].getCur();
            for(int i=0;i<this.size;i++){
                Node node = this.linkList[index];
                index = node.getCur();
                if(i+1==this.size){
                    node.setCur(newIndex);
                }
            }
        }
        //���½ڵ�ŵ���������λ��
        Node node = new Node(data,0);
        //���½ڵ����������
        this.linkList[newIndex] = node;
        size++;
    }

    /**
     * ��Ԫ�ز��뵽ָ��λ��
     * @param data
     * @param zdIndex ָ����λ��
     */
    public void add(String data,int zdIndex){
        if(zdIndex<0 || zdIndex>size){
            System.out.println("��λ���������в����ڣ�");
        }else{
            //��ȡ��������ͷ����±�
            int newIndex = this.getByIndex();
            //�����һ��Ԫ��ʱ�����±긳ֵ���������һ��Ԫ�ص�curֵ
            if(zdIndex==1){
                //��ȡԭ���ĵ�һ��Ԫ���±�
                int oldIndex = this.linkList[this.maxSize-1].getCur();
                //���²����Ԫ���±긳ֵ����������һ��Ԫ��
                this.linkList[this.size-1].setCur(newIndex);
                //���½ڵ�ŵ������һ��λ��
                Node newNode = new Node(data,oldIndex);
                this.linkList[newIndex] = newNode;
            }else{
                //�ҵ�����zdIndexλ�õ�ǰһ��Ԫ�أ��ı���curֵ
                int index = this.linkList[this.maxSize-1].getCur();//����ĵ�һ��Ԫ���±�
                for(int i=0;i<zdIndex-1;i++){
                    Node node = this.linkList[index];
                    index = node.getCur();
                    if(i+1 == zdIndex-1){
                        //node.getCur() ��ʱnode�д�ŵ���ԭ��node�����Ԫ�ص����� ���丳ֵ����Ԫ��
                        //���½ڵ�ŵ�����ָ��λ��
                        Node newNode = new Node(data,node.getCur());
                        //���½ڵ����������
                        this.linkList[newIndex] = newNode;
                        node.setCur(newIndex);
                    }
                }
            }
            size++;
        }
    }

    /**
     * ��ȡ����ָ��λ�õ�Ԫ��
     * @param x
     * @return
     */
    public Node get(int x){
        Node node = new Node();
        int index = this.linkList[this.maxSize-1].getCur();//��һ��Ԫ��
        if(x<0 || x>size){
            System.out.println("��Ԫ���������в����ڣ�");
        }else{
            for(int i = 0;i<x;i++){
                node = this.linkList[index];
                index = this.linkList[index].getCur();
            }
        }
        return node;
    }

    /**
     * ��������е�����Ԫ��
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
     * ��ȡ������
     * @return
     */
    public int length(){
        return this.size;
    }

    /**
     * �Ƴ�ָ��λ�õ�Ԫ��
     * @param index
     */
    public void remove(int index){
        if(index<0 || index>size){
            System.out.println("��Ԫ���������в����ڣ�");
        }else if(index==1){//ɾ����һ��Ԫ��
            // ��listLinked[maxSize-1]��curֵ��Ϊ����Ԫ�ص��±�
            System.out.println("linkList[this.maxSize-1]===============>"+linkList[this.maxSize-1]);
            int removeIndex = this.linkList[this.maxSize-1].getCur();//1
            Node removedNode = this.linkList[removeIndex];//one==========>4
            System.out.println("removedNode.getCur()============>"+removedNode.getCur());
            //����ɾ��Ԫ�ص�ǰһ��Ԫ��ָ��ɾ��Ԫ�صĺ��Ԫ��
            this.linkList[this.maxSize-1].setCur(removedNode.getCur());
            //����ɾ��Ԫ�ص�Ԫ�ػ��յ������������ͷ��㴦
            removedNode.setCur(this.linkList[0].getCur());
            this.linkList[0].setCur(removeIndex);
            this.size--;
        }else{
            //�ҵ���ɾ��Ԫ�ص�ǰһ��Ԫ��
            int previousIndex = this.linkList[this.maxSize-1].getCur();
            for(int i=0;i<index-1;i++){
                Node previousNode = this.linkList[previousIndex];
                previousIndex = this.linkList[previousIndex].getCur();
                if(i+1 == index-1){//�ҵ��˱�ɾ��Ԫ�ص�ǰһ��Ԫ��
                    Node removedNode = this.linkList[previousNode.getCur()];
                    int removeIndex = previousNode.getCur();
                    if(index==this.size){//���ɾ���������һ��Ԫ�أ�����ǰһ��Ԫ�ر�Ϊ���һ��Ԫ��
                        previousNode.setCur(0);
                    }else{
                        //����ɾ��Ԫ�ص�ǰһ��Ԫ��ָ��ɾ��Ԫ�صĺ��Ԫ��
                        previousNode.setCur(removedNode.getCur());
                    }
                    //����ɾ��Ԫ�ص�Ԫ�ػ��յ������������ͷ��㴦
                    removedNode.setCur(this.linkList[0].getCur());
                    this.linkList[0].setCur(removeIndex);
                }
            }
            this.size--;
        }
    }
}
