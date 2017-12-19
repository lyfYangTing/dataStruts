package stackTest.sxccStackTest;

/**
 * Created by 18435 on 2017/9/25.
 * ��ջ����ռ�
 */
public class ShareStack {
    private String[] stack;
    private int maxSize = 10;
    private int topOne;//��һ��ջ��ջ��
    private int topTwo;//�ڶ���ջ��ջ��

    //��ʼ��ջ
    public ShareStack(){
        this.stack = new String[this.maxSize];
        this.topOne = -1;
        this.topTwo = this.maxSize;
    }

    //��һ��ջ�Ľ�ջ
    public void pushOne(String data){
        if(this.topOne<this.topTwo-1){
            this.topOne++;
            this.stack[this.topOne] = data;
        }else{
            System.out.println("ջ��������");
        }
    }
    //��һ��ջ�ĳ�ջ
    public String  popOne(){
        if(this.topOne<0){
            return "��ջ�ǿ�ջ����ʱû�����ݡ�����";
        }else {
            String data = this.stack[this.topOne];
            this.topOne--;
            return data;
        }
    }

    //�ڶ���ջ��ջ
    public void pushTwo(String data){
        if(this.topTwo > this.topOne + 1){
            this.topTwo--;
            this.stack[this.topTwo] = data;
        }else{
            System.out.println("ջ��������");
        }
    }
    //�ڶ���ջ�ĳ�ջ
    public String  popTwo(){
        if(this.topTwo>this.maxSize-1){
            return "��ջ�ǿ�ջ����ʱû�����ݡ�����";
        }else {
            String data = this.stack[this.topTwo];
            this.topTwo++;
            return data;
        }
    }

    //ѭ����������е�����
    public void showData(){
        for (int i=0;i<this.maxSize;i++){
            System.out.println(i+"--------------"+this.stack[i]);
        }
    }
}
