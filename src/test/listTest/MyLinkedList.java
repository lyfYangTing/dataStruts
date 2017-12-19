package test.listTest;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 18435 on 2017/11/1.
 */
public class MyLinkedList {

    /**
     * 判断该链表中存不存在环
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
//            //一个指针移动得快，一个指针移动得慢，如果存在环的话，一定存在有两个指针指向同一个元素
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

        //建立关系
        head.setNext(first);
        first.setNext(second);
        second.setNext(three);

        System.out.println(MyLinkedList.hasCycle(head));
    }

}
