package stackApply;

/**
 * Created by 18435 on 2017/10/9.
 */
public class SuffixExpression {
    /**
     * ����׺���ʽת��Ϊ��׺���ʽ(ջ������������ķ���)
     * ���磺��׺���ʽ -----> a + b * c +(d * e + f) * g
     *       ��׺���ʽ -----> a b c * + d e * f + g * +
     * ת������
     * �����ұ�����׺���ʽ��ÿ�����ֺͷ��ţ�
     * �������־����������Ϊ��׺���ʽ��һ���֣�
     * ���Ƿ��ţ����ж�����ջ�����ŵ����ȼ���
     * �������ţ���ջԪ�ص������������ķ���д��ֱ������һ����Ӧ�������ţ�
     * �����ȼ�����ջ�����ţ��˳����ȼӼ�����ջ�е���ջԪ��ֱ���������ȼ����͵�Ԫ��Ϊֹ��
     * ��ջ��Ԫ�����γ�ջ�������������ǰ���Ž�ջ��һֱ�����������׺���ʽΪֹ
     * @param infixExpression
     * @return
     */
    public String getSuffixExpression(String infixExpression){
        StringBuffer suffix = new StringBuffer();

        return suffix.toString();
    }

    /**
     * ��׺���ʽ��ֵ��ջ���������������ֵ��
     * �������:
     *         ������һ����ʱ�Ͱ�������ջ�У�������һ�������ʱ������������ڴӸ�ջ�����������������ţ��ϣ�
     *     �ٽ����ý������ջ�С�
     * @param suffixExpression  ��׺���ʽ
     */
    public void getSuffixExpressionEvaluation(String suffixExpression){

    }

    /**
     * ��׺���ʽת��ɱ��ʽ����ջ���������������ֵ��
     * ת������:
     *         ����һ��һ�����ŵض�����ʽ����������ǲ���������ô�ͽ���һ�������������������ջ�У�����������������
     *     ��ô�ʹ�ջ�е���������T1��T2(T1�ȵ���)���γ�һ���µ����������ĸ����ǲ��������������Һ��ӷֱ���T2��T1��Ȼ��
     *     �������ѹ��ջ�С�
     * @param suffixExpression
     */
    public void getExpressionTree(String suffixExpression){

    }
}
