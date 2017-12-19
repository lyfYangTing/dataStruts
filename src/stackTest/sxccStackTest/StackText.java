package stackTest.sxccStackTest;

/**
 * Created by 18435 on 2017/9/25.
 * ���Դ洢�ṹʵ��
 */
public class StackText {
    private String[] stack;
    private int maxSize = 1000;
    private int top;

    //��ʼ��ջ
    public StackText(){
        this.stack = new String[maxSize];//ջ������
        this.top = -1;
    }

    //��ջ
    public void push(String data){
        if(this.top<this.maxSize-1){
            this.top++;
            this.stack[this.top] = data;
        }else{
            System.out.println("ջ��������");
        }
    }

    //��ջ
    public String  pop(){
        if(this.top<0){
            return "��ջ�ǿ�ջ����ʱû�����ݡ�����";
        }else {
            String data = this.stack[this.top];
            this.top--;
            return data;
        }
    }
}
