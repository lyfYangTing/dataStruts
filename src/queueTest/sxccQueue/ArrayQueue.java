package queueTest.sxccQueue;

/**
 * Created by 18435 on 2017/9/26.
 * 循环队列：头尾相接的顺序存储结构
 */
public class ArrayQueue {
    private String[] arrayQueue;//队列数组
    private int queueMaxSize;//队列最大容量
    private int front;//指向队头元素（出队不移动元素位置 改变该值即可）
    private int area;//指向下一个存储位置 即队尾元素的后一个位置（后面满了 就从头开始）
    private int queueSize;//队列长度

    /**
     * 初始化队列
     */
    public ArrayQueue() {
        this.queueMaxSize = 6;
        this.arrayQueue = new String[this.queueMaxSize];
        this.front = 0;
        this.area = 0;
        this.queueSize = 0;
    }

    /**
     * 入队
     *
     * @param data
     */
    public void inQueue(String data) {
        if (this.queueSize + 1 >= this.queueMaxSize) {//队列已满
            System.out.println("队列已满！！！");
        } else {
            this.arrayQueue[this.area] = data;
            if (this.area == this.queueMaxSize - 1) {
                this.area = 0;
            } else {
                this.area++;
            }
            this.queueSize++;
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public String outQueue() {
        if (this.queueSize <= 0) {
            return "队列为空";
        } else {
            String data = this.arrayQueue[this.front];
            //释放元素空间
            this.arrayQueue[this.front] = null;
            //将front指向原队头元素的后一个元素
            if (this.front == this.queueMaxSize - 1) {
                this.front = 0;
            } else {
                this.front++;
            }
            this.queueSize--;
            return data;
        }
    }

    /**
     * 显示数组中所有元素
     */
    public void showAll() {
        for (int i = 0; i < this.queueMaxSize; i++) {
            System.out.println("第" + (i + 1) + "个元素" + this.arrayQueue[i]);
        }
    }
}
