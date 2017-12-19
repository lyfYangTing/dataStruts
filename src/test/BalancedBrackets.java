package test;

import java.util.Stack;

/**
 * Created by 18435 on 2017/11/2.
 * 平衡括号:'{' '}' '[' ']' '(' ')'
 */
public class BalancedBrackets {

    public static String isBalanced(String bracket){
        char[]  brackets = bracket.toCharArray();
        if(brackets.length%2==1){
            return "NO";
        }
        Stack stack = new Stack();
        for(int i=0;i<brackets.length;i++){
            if(stack.size()==0){//空栈，直接入栈
                stack.push(brackets[i]);
            }else{
                char top = (char)stack.peek();//获取栈顶元素，但不会弹出
                if((brackets[i]-top)<=2 && brackets[i]>top){//表示配对成功，弹出栈顶元素
                    stack.pop();
                }else{//匹配失败 将新元素压入栈中
                    stack.push(brackets[i]);
                }
            }
        }
        if(stack.size()!=0){
            return "NO";
        }
        return "YES";
    }

    public static boolean is_balanced(String expression){
        Stack stack = new Stack();
        for(char c:expression.toCharArray()){
            if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='('){
                stack.push(')');
            }else{
                if(stack.empty() || c!=(char)stack.peek()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static boolean is_Balanced(String expression){
        Stack stack = new Stack();
        for(char c:expression.toCharArray()){
            switch (c){
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if(stack.empty() || c != (char)stack.peek())
                        return false;
                    stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args){
//        System.out.println((int)'{');//123
//        System.out.println((int)'}');//125
//        System.out.println((int)'[');//91
//        System.out.println((int)']');//93
//        System.out.println((int)'(');//40
//        System.out.println((int)')');//41

        System.out.println(BalancedBrackets.isBalanced("{{[[(())]]}}"));
        System.out.println(BalancedBrackets.is_balanced("{{[[(())]]}}"));
        System.out.println(BalancedBrackets.is_Balanced("{{[[(())]]}}"));

    }
}
