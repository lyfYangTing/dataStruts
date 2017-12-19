package staticLinkedList;

/**
 * Created by 18435 on 2017/9/22.
 */
public class Node {//数组中存放的一个元素
    private String data;//存放的数据元素
    private int cur;//游标  存放该元素的后继在数组中的下标

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
