package stackTest.sxccStackTest;

/**
 * Created by 18435 on 2017/9/25.
 * 线性存储结构实现
 */
public class StackText {
    private String[] stack;
    private int maxSize = 1000;
    private int top;

    //初始化栈
    public StackText(){
        this.stack = new String[maxSize];//栈的容量
        this.top = -1;
    }

    //进栈
    public void push(String data){
        if(this.top<this.maxSize-1){
            this.top++;
            this.stack[this.top] = data;
        }else{
            System.out.println("栈容量已满");
        }
    }

    //出栈
    public String  pop(){
        if(this.top<0){
            return "该栈是空栈，暂时没有数据。。。";
        }else {
            String data = this.stack[this.top];
            this.top--;
            return data;
        }
    }
}
