import stackTest.lsccStackTest.LinkStack;

public class Main {

    public static void main(String[] args) {

//        StaticLinkedList list = new StaticLinkedList();
//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.showAllNodes();
//        System.out.println("------------------------");
//        list.add("four", 2);
//        list.showAllNodes();
//        System.out.println("------------------------");
//        list.add("five", 3);
//        list.showAllNodes();
//        System.out.println("------------------------");
//        list.remove(4);
//        list.showAllNodes();
//        Node node = list.get(2);
//        System.out.println(node);

//        StackText st = new StackText();
//        st.push("one");
//        st.push("two");
//        st.push("three");
//        System.out.println("pop data=========>"+st.pop());
//        System.out.println("pop data1=========>"+st.pop());
//        System.out.println("pop data2=========>"+st.pop());

//        ShareStack ss = new ShareStack();
//        ss.pushOne("oneOne");
//        ss.pushOne("oneTwo");
//        ss.pushOne("oneThree");
//        ss.pushOne("oneFour");
//        ss.pushOne("oneFive");
//
//        ss.pushTwo("twoOne");
//        ss.pushTwo("twoTwo");
//        ss.pushTwo("twoThree");
//        ss.pushTwo("twoFour");
//
//        ss.showData();
//        System.out.println("pop One data=========>"+ss.popOne());
//        System.out.println("pop Two data=========>"+ss.popTwo());
//        System.out.println("pop One data=========>"+ss.popOne());
//        System.out.println("pop Two data=========>"+ss.popTwo());
        LinkStack ls = new LinkStack();
        ls.push("one");
        ls.push("two");
        ls.push("three");

        ls.show();
        System.out.println("pop data 1=========>"+ls.pop());
        System.out.println("pop data 2=========>"+ls.pop());
        System.out.println("pop data 3=========>"+ls.pop());
        System.out.println("pop data 3=========>"+ls.pop());

        System.exit(0);

    }
}
