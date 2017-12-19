package stackTest.sxccStackTest;

/**
 * Created by 18435 on 2017/9/25.
 * 两栈共享空间
 */
public class ShareStack {
    private String[] stack;
    private int maxSize = 10;
    private int topOne;//第一个栈的栈顶
    private int topTwo;//第二个栈的栈顶

    //初始化栈
    public ShareStack(){
        this.stack = new String[this.maxSize];
        this.topOne = -1;
        this.topTwo = this.maxSize;
    }

    //第一个栈的进栈
    public void pushOne(String data){
        if(this.topOne<this.topTwo-1){
            this.topOne++;
            this.stack[this.topOne] = data;
        }else{
            System.out.println("栈容量已满");
        }
    }
    //第一个栈的出栈
    public String  popOne(){
        if(this.topOne<0){
            return "该栈是空栈，暂时没有数据。。。";
        }else {
            String data = this.stack[this.topOne];
            this.topOne--;
            return data;
        }
    }

    //第二个栈进栈
    public void pushTwo(String data){
        if(this.topTwo > this.topOne + 1){
            this.topTwo--;
            this.stack[this.topTwo] = data;
        }else{
            System.out.println("栈容量已满");
        }
    }
    //第二个栈的出栈
    public String  popTwo(){
        if(this.topTwo>this.maxSize-1){
            return "该栈是空栈，暂时没有数据。。。";
        }else {
            String data = this.stack[this.topTwo];
            this.topTwo++;
            return data;
        }
    }

    //循环输出数组中的数据
    public void showData(){
        for (int i=0;i<this.maxSize;i++){
            System.out.println(i+"--------------"+this.stack[i]);
        }
    }
}
