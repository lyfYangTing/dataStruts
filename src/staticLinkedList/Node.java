package staticLinkedList;

/**
 * Created by 18435 on 2017/9/22.
 */
public class Node {//�����д�ŵ�һ��Ԫ��
    private String data;//��ŵ�����Ԫ��
    private int cur;//�α�  ��Ÿ�Ԫ�صĺ���������е��±�

    public Node(){}

    public Node(String data,int cur){
        this.cur = cur;
        this.data = data;
    }

    public Node(int cur){
        this.cur = cur;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }

    @Override
    public String toString() {
        return this.data +"----------------"+ this.cur;
    }
}
