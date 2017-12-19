package myTree;

import java.util.Stack;

/**
 * Created by 18435 on 2017/11/3.
 * 二分搜索树(二叉排序树)满足的条件:
 * 1.若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 2.若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 3.它的左、右子树也分别为二叉排序树。
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
     * 考虑了检查子节点是否对根节点的所有父节点是正确的问题。
     * 请注意，当调用check时，
     * “min”和“max”变量将不断被更新。
     * 在将root.data传递给min和max一次之后，所有后续调用将共享相同的min和最大值，
     * 而不是整数。定义了xxx_值。
     */
    boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 将给定的二叉树做中序遍历，二分搜索树的中序遍历序列一定是满足 从小到达排列的规律
     * 将中序遍历的值有大小关系
     * 满足当前的值必须大于栈顶元素，则将该值压入栈中（或者将原来的栈顶元素先弹出，再将当前值压入栈顶）继续遍历
     * 当前的值小于栈顶元素，则表示这棵树不能满足二分搜索树的规律，返回fasle
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
     * 错误的判断方法:
     * 错误原因:
     * 左子树上所有结点的值均小于它的根结点的值；
     * （忽略了全部，只判断了当前元素和左结点，右结点的大小关系）
     *
     * @param root
     * @return
     */
    boolean wrongCheck(Node root) {
        int currentData = root.getData();
        if (root.getLeft() == null && root.getRight() == null) {//出现的问题:忽略了   左子树上（所有结点）的值均小于它的根节点的值   右子树上所有结点的值均大于它的根结点的值
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
