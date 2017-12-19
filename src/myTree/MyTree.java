package myTree;

/**
 * Created by 18435 on 2017/11/3.
 */
public class MyTree {
    // private Stack stack = new Stack();
    //int currentData = root.data;
    //boolean left = checkBST(root.left);
    //System.out.println(root.data);
    //if(stack.empty()){
    //stack.push(root.data);
    //}else{
    //if(root.data > stack.peek()){
    //    stack.push(root.data);
    // }else{
    //       return false;
    //  }
    //  }
    //  boolean right = checkBST(root.right);
    //  return true;
    //二叉查找树满足的条件： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均         //大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
    //if(root.left==null && root.right==null){出现的问题:忽略了   左子树上（所有结点）的值均小于它的根节点的值
    //    return true;
    //}else if(root.left !=null && root.right==null){
    //    return checkBST(root.left) && root.left.data<currentData;
    // }else if(root.left ==null && root.right!=null){
    //    return checkBST(root.right) && currentData<root.right.data;
    //}else{
    //    return checkBST(root.left) && checkBST(root.right) && (root.left.data<currentData && currentData<root.right.data);

}
