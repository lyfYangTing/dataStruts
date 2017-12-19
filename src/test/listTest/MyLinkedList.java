package test.listTest;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 18435 on 2017/11/1.
 */
public class MyLinkedList {

    /**
     * �жϸ������д治���ڻ�
     * @param head
     * @return
     */
//    public static boolean hasCycle(Node head){
//        if(head==null){
//            return false;
//        }
//
//        Node slow = head;
//        Node fast = head.getNext();
//
//        while(slow!=fast){
//            if (slow==null || fast==null){
//                return false;
//            }
//            //һ��ָ���ƶ��ÿ죬һ��ָ���ƶ�������������ڻ��Ļ���һ������������ָ��ָ��ͬһ��Ԫ��
//            slow = slow.getNext();
//            fast = fast.getNext().getNext();
//        }
//        return true;
//    }

    public static boolean hasCycle(Node head){
        if (head == null) return false;

        Map<Node,Integer> map = new TreeMap<Node,Integer>();
        Node node = head.getNext();
        while(node!=null){
            if(map.get(node)==null){
                map.put(node,1);
            }else{
                return true;
            }
            node = node.getNext();
        }
        return false;
    }
    public static void main(String[] args){
        Node head = new Node(0);
        Node first = new Node(1);
        Node second = new Node(2);
        Node three = new Node(3);

        //������ϵ
        head.setNext(first);
        first.setNext(second);
        second.setNext(three);

        System.out.println(MyLinkedList.hasCycle(head));
    }

}
