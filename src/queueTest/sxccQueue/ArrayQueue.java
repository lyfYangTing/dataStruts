package queueTest.sxccQueue;

/**
 * Created by 18435 on 2017/9/26.
 * ѭ�����У�ͷβ��ӵ�˳��洢�ṹ
 */
public class ArrayQueue {
    private String[] arrayQueue;//��������
    private int queueMaxSize;//�����������
    private int front;//ָ���ͷԪ�أ����Ӳ��ƶ�Ԫ��λ�� �ı��ֵ���ɣ�
    private int area;//ָ����һ���洢λ�� ����βԪ�صĺ�һ��λ�ã��������� �ʹ�ͷ��ʼ��
    private int queueSize;//���г���

    /**
     * ��ʼ������
     */
    public ArrayQueue() {
        this.queueMaxSize = 6;
        this.arrayQueue = new String[this.queueMaxSize];
        this.front = 0;
        this.area = 0;
        this.queueSize = 0;
    }

    /**
     * ���
     *
     * @param data
     */
    public void inQueue(String data) {
        if (this.queueSize + 1 >= this.queueMaxSize) {//��������
            System.out.println("��������������");
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
     * ����
     *
     * @return
     */
    public String outQueue() {
        if (this.queueSize <= 0) {
            return "����Ϊ��";
        } else {
            String data = this.arrayQueue[this.front];
            //�ͷ�Ԫ�ؿռ�
            this.arrayQueue[this.front] = null;
            //��frontָ��ԭ��ͷԪ�صĺ�һ��Ԫ��
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
     * ��ʾ����������Ԫ��
     */
    public void showAll() {
        for (int i = 0; i < this.queueMaxSize; i++) {
            System.out.println("��" + (i + 1) + "��Ԫ��" + this.arrayQueue[i]);
        }
    }
}
