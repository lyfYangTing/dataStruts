package stackApply;

/**
 * Created by 18435 on 2017/10/9.
 */
public class SuffixExpression {
    /**
     * 将中缀表达式转化为后缀表达式(栈用来进出运算的符号)
     * 例如：中缀表达式 -----> a + b * c +(d * e + f) * g
     *       后缀表达式 -----> a b c * + d e * f + g * +
     * 转化规则：
     * 从左到右遍历中缀表达式的每个数字和符号，
     * 若是数字就输出，即成为后缀表达式的一部分；
     * 若是符号，则判断其与栈顶符号的优先级，
     * 是右括号（将栈元素弹出，将弹出的符号写出直至遇到一个对应的左括号）
     * 或优先级低于栈顶符号（乘除优先加减，从栈中弹出栈元素直到发现优先级更低的元素为止）
     * 则栈顶元素依次出栈并输出，并将当前符号进栈，一直到最终输出后缀表达式为止
     * @param infixExpression
     * @return
     */
    public String getSuffixExpression(String infixExpression){
        StringBuffer suffix = new StringBuffer();

        return suffix.toString();
    }

    /**
     * 后缀表达式求值（栈用来进出运算的数值）
     * 运算规则:
     *         当见到一个数时就把它推入栈中；在遇到一个运算符时该算符就作用于从该栈弹出的两个数（符号）上，
     *     再将所得结果推入栈中。
     * @param suffixExpression  后缀表达式
     */
    public void getSuffixExpressionEvaluation(String suffixExpression){

    }

    /**
     * 后缀表达式转变成表达式树（栈用来进出运算的数值）
     * 转换规则:
     *         我们一次一个符号地读入表达式。如果符号是操作数，那么就建立一个单结点树并将它推入栈中；如果符号是运算符，
     *     那么就从栈中弹出两棵树T1和T2(T1先弹出)并形成一颗新的树，该树的根就是操作符，它的左右孩子分别是T2和T1。然后，
     *     将这棵树压入栈中。
     * @param suffixExpression
     */
    public void getExpressionTree(String suffixExpression){

    }
}
