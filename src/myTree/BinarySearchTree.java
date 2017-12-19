package myTree;

import java.util.Stack;

/**
 * Created by 18435 on 2017/11/3.
 * ����������(����������)���������:
 * 1.���������������գ��������������н���ֵ��С�����ĸ�����ֵ��
 * 2.���������������գ��������������н���ֵ���������ĸ�����ֵ��
 * 3.������������Ҳ�ֱ�Ϊ������������
 */
public class BinarySearchTree {
    private Stack<Integer> stack = new Stack<Integer>();

    /**
     * @param node
     * @param min
     * @param max
     * @return
     */
    boolean check(Node node, int min, int max) {
        if (node == null) {
            return true;
        } else {
            return check(node.getLeft(), min, node.getData()) && check(node.getRight(), node.getData(), max) && (node.getData() > min && node.getData() < max);
        }
    }

    /**
     * @param root
     * @return
     * �����˼���ӽڵ��Ƿ�Ը��ڵ�����и��ڵ�����ȷ�����⡣
     * ��ע�⣬������checkʱ��
     * ��min���͡�max�����������ϱ����¡�
     * �ڽ�root.data���ݸ�min��maxһ��֮�����к������ý�������ͬ��min�����ֵ��
     * ������������������xxx_ֵ��
     */
    boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * �������Ķ���������������������������������������һ�������� ��С�������еĹ���
     * �����������ֵ�д�С��ϵ
     * ���㵱ǰ��ֵ�������ջ��Ԫ�أ��򽫸�ֵѹ��ջ�У����߽�ԭ����ջ��Ԫ���ȵ������ٽ���ǰֵѹ��ջ������������
     * ��ǰ��ֵС��ջ��Ԫ�أ����ʾ�����������������������Ĺ��ɣ�����fasle
     *
     * @param root
     * @return
     */
    boolean checkBST_Two(Node root) {
        if(root==null){
            return true;
        }
        boolean leftCheck = checkBST(root.getLeft());
        System.out.println(root.getData());
        if (stack.empty()) {
            stack.push(root.getData());
        } else {
            if (root.getData() > (int) stack.pop()) {
                stack.push(root.getData());
            } else {
                return false;
            }
        }
        boolean rightCheck = checkBST(root.getRight());
        return leftCheck && rightCheck;
    }

    /**
     * ������жϷ���:
     * ����ԭ��:
     * �����������н���ֵ��С�����ĸ�����ֵ��
     * ��������ȫ����ֻ�ж��˵�ǰԪ�غ����㣬�ҽ��Ĵ�С��ϵ��
     *
     * @param root
     * @return
     */
    boolean wrongCheck(Node root) {
        int currentData = root.getData();
        if (root.getLeft() == null && root.getRight() == null) {//���ֵ�����:������   �������ϣ����н�㣩��ֵ��С�����ĸ��ڵ��ֵ   �����������н���ֵ���������ĸ�����ֵ
            return true;
        } else if (root.getLeft() != null && root.getRight() == null) {
            return checkBST(root.getLeft()) && root.getLeft().getData() < currentData;
        } else if (root.getLeft() == null && root.getRight() != null) {
            return checkBST(root.getRight()) && currentData < root.getRight().getData();
        } else {
            return checkBST(root.getLeft()) && checkBST(root.getRight()) && (root.getLeft().getData() < currentData && currentData < root.getRight().getData());
        }
    }
}
