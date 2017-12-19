package util;

/**
 * Created by 18435 on 2017/10/25.
 * ϣ�������൱��ֱ�Ӳ������������������ͬ���ڲ���������
 * �������൱�ڼ�ѡ�����������������ͬ����ѡ��������
 * ���������൱��ð�����������������ͬ���ڽ���������
 */
public class MySort {
    /**
     * �������򷨣���С��������  ������򵥵����򷽷�,����Ч�ʼ���
     *
     * @param array
     */
    public static void positiveOrderSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
    }

    /**
     * �������򷨣��Ӵ�С����
     *
     * @param array
     */
    public static void descendingOrderSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
    }

    /**
     * ð������:�����Ƚ�  ���ڼ�¼   �Ĺؼ���,��������򽻻�,ֱ��û�з���ļ�¼Ϊֹ
     *
     * @param array
     */
    public static void bubblingSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {//�Ӻ���ǰѭ��  ��Խ�С��ֵ����ǰð
                if (array[j - 1] > array[j]) {//�Ƚϵ�������Ԫ�صĴ�С
                    int a = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = a;
                }
            }
        }
    }

    /**
     * ð������Ľ���:���ٶ� �Ѿ���������н��з����Ƚ�(���ٱȽϴ���)  �������Ѿ�����������������ѭ���ж�
     * ʱ�临�Ӷȷ���:
     * ��õ����:Ҫ����ı�����������    (n-1)�εıȽ�                   û�����ݽ���    ʱ�临�Ӷ�Ϊ O(n)
     * ������:��������������(1+2+3+...+(n-1))=[n*(n-1)/2]�εıȽ�      �����������ļ�¼�ƶ�   ʱ�临�Ӷ�ΪO(n*n)
     *
     * @param array
     */
    public static void bubblingSortingImprove(int[] array) {
        boolean isOrderliness = false;//�ж���Ҫ�Ƚϵĺ����Ԫ�������Ƿ�����  false--->����    true--->������(����������±Ƚ�)
        for (int i = 0; i < array.length && !isOrderliness; i++) {
            isOrderliness = true;
            for (int j = array.length - 1; j > i; j--) {//û���κ����ݽ���,���˵���������Ѿ�����,����Ҫ�ټ��������ѭ���жϹ�����
                if (array[j - 1] > array[j]) {
                    int a = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = a;
                    isOrderliness = false;
                }
            }
        }
    }

    /**
     * ��ѡ������:����ͨ��(n-i)�ιؼ��ּ�ıȽ�,��(n-i+1)����¼��ѡ���ؼ�����С�ļ�¼,���͵�i(1<=i<=n)����¼����
     * ʱ�临�Ӷȷ���:  �ܵ�ʱ�临�Ӷ�Ϊ O(n*n)
     * �Ƚϴ���:��õ�������������Ƚϴ���һ�������� n*(n-1)/2 ��
     * ��������:��õ��������Ϊ0�Σ�����������Ϊ��n-1����
     *
     * @param array
     */
    public static void simpleSelectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {//�ҵ���Сֵ  �Ż���н�������
                int min = array[minIndex];
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

    /**
     * ֱ�Ӳ��������㷨:���������ǽ�һ����¼���뵽�Ѿ��ź����������У��Ӷ��õ�һ���µģ���¼����1�������
     * ��������֤��λ��0��λ��p-1�ϵ�Ԫ��Ϊ������״̬
     * ʱ�临�Ӷȷ���:
     * ��õ����: Ҫ����ı�����������ģ� �Ƚϴ��� (n-1) ��   û���ƶ�  ʱ�临�Ӷ�ΪO(n)
     * ������: Ҫ����ı��������   �Ƚϴ��� (2+3+4+5+...+n)��(n+2)*(n-1)/2 �� �ƶ����� (3+4+5+...+(n+1))��(n+4)*(n-1)/2
     * �����¼�������,��ƽ���ȽϺ��ƶ�����ԼΪ n*n/4 ��  ��������򷨵�ʱ�临�Ӷ�ΪO(n*n)
     *
     * @param array
     */
    public static void straightInsertionSort(int[] array) {
        //�ڲ����i��Ԫ�ص�ʱ��i֮ǰ�Ĳ����Ѿ�������������
        int j;
        for (int i = 1; i < array.length; i++) {//array[i]Ϊ���ڲ����Ԫ��
            if (array[i] < array[i - 1]) {//��Ҫ�����ڲ����Ԫ�ز��ܲ嵽��������β�� ��Ҫͨ���Ƚϲ��뵽ǰ����������е��ʵ�λ��
                int tmp = array[i];
                for (j = i; j > 0 && array[j - 1] > tmp; j--) {
                    array[j] = array[j - 1];//��¼����ƶ�
//                    if (array[j] < array[j - 1]) {//��Ҫ����ֵ�����Ƚ�Ҫ�����Ԫ�ص�ֵ���뵽һ����ʱ��������¼������ƶ��Ľ���������
//                        int x = array[j];
//                        array[j] = array[j - 1];
//                        array[j - 1] = x;
//                    } else {
//                        break;
//                    }
                }
                array[j] = tmp;//��Ԫ�ز��뵽��λ��   ���λ�õ�ǰһ��Ԫ��ֵС�ڲ����Ԫ��
            }
        }
    }

    /**
     * ϣ������(Ҳ��һ�ֲ�������  ��С��������):�Ѽ�¼���±��һ���������飬��ÿ��ʹ��ֱ�Ӳ��������㷨����
     * ���������𽥼��٣�ÿ������Ĺؼ���Խ��Խ�࣬����������1ʱ�������ļ�ǡ���ֳ�һ�飬�㷨����ֹ��
     * �ؼ����������е�ѡ��
     * һ������ȡֵ�����������ŵ��������У�:gap=length/2����С����������gap = gap/2�ķ�ʽ��
     * ��������ѡ�����ǿ�����һ����������ʾ��{n/2,(n/2)/2...1}����Ϊ�������С�(�������е����һ��ֵ������1)
     *
     * @param array
     */
    public static void donaldShellSorting(int[] array) {
        int increment = array.length / 2;   //�������������Խ������зֳ� increment ��  ��ͬһ���Ԫ�ؽ���ֱ�Ӳ�������
        int j;
        while (increment > 0) {
            for (int i = increment; i < array.length; i++) {
                if (array[i] < array[i - increment]) {//�����������Ԫ�ر�ͬһ���ǰһ��Ԫ��С
                    int temporary = array[i];//��ʱ������ڲ���Ԫ�ص�ֵ
                    for (j = i; j >= increment && array[j - increment] > temporary; j -= increment) {//ͬ��Ԫ��ֱ�Ӳ���
                        array[j] = array[j - increment];
                    }
                    array[j] = temporary;
                }
            }
            increment = increment / 2;
        }
    }

    /**
     * �ѣ����Ǿ����������ʵ���ȫ��������ÿ������ֵ�����ڻ���������Һ��ӽ���ֵ����Ϊ�󶥶ѣ�
     * ÿ������ֵ��С�ڻ���������Һ��ӽ���ֵ,��ΪС���ѡ�
     * ���ղ�������ķ�ʽ������1��ʼ��ţ�����֮���������¹�ϵ:
     * k(i)>=k(2i) && k(i)>=k(2i+1)  ��   k(i)<=k(2i) && k(i)<=k(2i+1)      1<=i<=[n/2]
     * ���������ʣ�һ����ȫ�����������i=1,����i�Ƕ������ĸ�����˫�ף����i>1,����˫���ǽ��[i/2]
     * �����򣺽�����������й����һ���󶥶ѡ���ʱ���������е����ֵ���ǶѶ��ĸ���㡣
     * �������ߣ���ʵ���ǽ�����������ĩβԪ�ؽ�������ʱĩβԪ�ؾ������ֵ����
     * Ȼ��ʣ��ģ�n-1���������¹����һ���ѣ������ͻ�ĵ�n��Ԫ���еĴ�Сֵ��
     * ��˷���ִ�У����ܵõ�һ�����������ˡ�
     * ��Ҫ��Ҫ���������:
     * 1)�����һ���������й�����һ����?
     * 2)���������Ѷ�Ԫ�غ󣬵���ʣ��Ԫ�س�Ϊһ���µĶ�?
     *
     * @param array
     */
    public static void heapSorting(int[] array) {
        for (int i = array.length; i > 1; i--) {
            //�����鹹�������󶥶����ʵ���ʽ
            MySort.getLargeRoofHeap(array, i);//�����󶥶�
            //���󶥶ѵ����Ԫ��(����ѵ����ֵ)�� ��i��Ԫ�ؽ���
            MySort.swap(array, 0, i - 1);//����Ԫ����ĩβԪ�ؽ���
        }
    }

    /**
     * �����鹹ת���ɴ󶥶�  (�Լ����뷨)  ȱ�㣺���ݽ���������   �������¹�����
     *
     * @param array  ת��������
     * @param length ��ת�������鳤��
     */
    public static void getLargeRoofHeap(int[] array, int length) {
        //System.out.println("length/2-1----------------->"+(length/2-1));
        for (int i = length / 2 - 1; i >= 0; i--) { //�����һ�����������ת��
            //System.out.println("i--------->"+i+"------a[i]------------->"+array[i]);
            if (2 * (i + 1) == length && array[i] < array[2 * (i + 1) - 1]) {
                MySort.swap(array, i, 2 * (i + 1) - 1);
            }
            if ((array[i] < array[2 * (i + 1) - 1] || array[i] < array[2 * (i + 1)]) && 2 * (i + 1) < length) {//��  k(i)<k(2i) ����������������ӵ�ֵ
                if (array[2 * (i + 1) - 1] > array[2 * (i + 1)]) {//2*(i+1)  =  2*(i+1)+1-1  ��ʾ���ڵ���Һ����±�    Ԫ�ؽ����Ĵ����϶�
                    MySort.swap(array, i, 2 * (i + 1) - 1);
                } else {
                    MySort.swap(array, i, 2 * (i + 1));
                }
            }
            //System.out.println("i--------->"+i+"------a[i]------------->"+array[i]);
        }
    }

    /**
     * �����򣺲ο����ϵ��뷨
     * 1.������ʱ�佨��һ����
     * 2.ÿ�ν����е����һ��Ԫ�����һ��Ԫ�ؽ���
     * 3.���ѵĴ�С����1����ʣ��ģ�n-1���������¹����һ����
     *
     * @param array
     */
    public static void heapSort(int[] array) {

        //����һ���󶥶�
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            MySort.percDown(array, i, array.length);
        }
        for (int a : array) {
            System.out.print(a + ",");
        }
        System.out.println("-----------------------------------");

        for (int i = array.length - 1; i > 0; i--) {
            //�����е����һ��Ԫ�����һ��Ԫ�ؽ���
            MySort.swap(array, 0, i);
            for (int a : array) {
                System.out.print(a + ",");
            }
            System.out.println();
            //ʣ��Ԫ�����µ�����һ���󶥶�   ��ԭ���ѵĻ����ϣ���array[0]���������ʵ�λ��
            MySort.percDown(array, 0, i);
        }
    }

    /**
     * ���ҽ���array[i]Ϊ��������������㣬������ŵ�array[i]��
     *
     * @param array           �����ѵ�ԭ����
     * @param currentRootNode ��ǰ�������ڵ�
     * @param heapSize        �ѵĳ���  ������Ԫ�غ��ѱ�ɾ����Ԫ��ͬ��array�����У�������heapSize�������ڶѵĳ��ȣ�
     */
    public static void percDown(int[] array, int currentRootNode, int heapSize) {
        int child;
        int tmp;//һֱ��ŵ��Ǵ���������ֵ   ѭ��һ�ν��� ִ��һ�� currentRootNode = child
        for (tmp = array[currentRootNode]; MySort.getLeftChild(currentRootNode) < heapSize; currentRootNode = child) {
            child = MySort.getLeftChild(currentRootNode);//������¼ ��ǰ�������ֵ���±�
            if (child != heapSize - 1 && array[child + 1] > array[child]) {//�Һ��ӱ����ӵ�ֵ��
                child++;
            }
            if (tmp < array[child]) {
                array[currentRootNode] = array[child];//��tem���뵽����λ�ã���tem���Ԫ�ػ�������ǰ�ƶ�����
            } else {
                break;
            }
        }
        array[currentRootNode] = tmp;
    }

    /**
     * �鲢����ԭ��
     * �����ʼ���к���n����¼������Կ�����n������������У�ÿ�������еĳ���Ϊ1��Ȼ�������鲢��
     * �õ�[n/2]������Ϊ2��1�����������У��������鲢...����ظ���ֱ���õ�һ������Ϊn����������Ϊֹ��
     * �鲢��������������ϲ�����������ĵı�
     *
     * @param array
     */
    public static void mergeSort(int[] array) {
        int[] temporaryArray = new int[array.length];
        //MySort.mergingSortByRecursion(array, temporaryArray, 0, array.length);
        MySort.mergingSortByCycle(array, temporaryArray);
    }

    /**
     * ͨ���ݹ�ʵ��
     *
     * @param originalArray  Դ����
     * @param temporaryArray ��ʱ���飬������ʱ���������ϲ��������
     * @param startIndex
     * @param endIndex
     */
    public static void mergingSortByRecursion(int[] originalArray, int[] temporaryArray, int startIndex, int endIndex) {
        int middle = (startIndex + endIndex) / 2;
        if (startIndex < endIndex) {
            mergingSortByRecursion(originalArray, temporaryArray, startIndex, middle);//������ǰ�벿������
            mergingSortByRecursion(originalArray, temporaryArray, middle + 1, endIndex);//�������벿������
            merge(originalArray, temporaryArray, startIndex, middle + 1, endIndex);//�ϲ�����������������
        }
    }

    /**
     * ͨ��ѭ��ʵ��
     *
     * @param originalArray
     * @param temporaryArray
     */
    public static void mergingSortByCycle(int[] originalArray, int[] temporaryArray) {
        //���ֽ������ϲ�
        int subSequenceLength = 1;
        while (subSequenceLength < originalArray.length) {
            subSequenceLength *= 2;
            int subSeqCount = originalArray.length % subSequenceLength == 0 ? originalArray.length / subSequenceLength : originalArray.length / subSequenceLength + 1;
            for (int start = 0; start < subSeqCount; start++) {
                //�ϲ���������
                if ((start * subSequenceLength + subSequenceLength / 2) <= originalArray.length - 1) {
                    int behindIndex = start * subSequenceLength + subSequenceLength - 1 < originalArray.length ? start * subSequenceLength + subSequenceLength - 1 : originalArray.length - 1;
//                    System.out.println("frontStartIndex--------->"+subSequenceLength*start);
//                    System.out.println("behindIndex------->"+(start*subSequenceLength+subSequenceLength-1));
                    MySort.merge(originalArray, temporaryArray, start * subSequenceLength, start * subSequenceLength + subSequenceLength / 2, behindIndex);
                }
            }
        }
    }

    /**
     * �鲢������   �ϲ�����������
     *
     * @param originalArray    Դ����
     * @param temporaryArray   ��ʱ����
     * @param frontStartIndex  ǰһ�������еĿ�ʼ����
     * @param behindStartIndex ��һ�������еĿ�ʼ����
     * @param behindEndIndex   ���������кϲ����  �������һ������
     */
    public static void merge(int[] originalArray, int[] temporaryArray, int frontStartIndex, int behindStartIndex, int behindEndIndex) {
        int tempPos = frontStartIndex;
        int frontEnd = behindStartIndex - 1;
        int num = behindEndIndex - frontStartIndex + 1;
        while (frontStartIndex <= frontEnd && behindStartIndex <= behindEndIndex) {
            if (originalArray[frontStartIndex] < originalArray[behindStartIndex]) {
                temporaryArray[tempPos++] = originalArray[frontStartIndex++];
            } else {
                temporaryArray[tempPos++] = originalArray[behindStartIndex++];
            }
        }

        while (frontStartIndex <= frontEnd) {
            temporaryArray[tempPos++] = originalArray[frontStartIndex++];
        }

        while (behindStartIndex <= behindEndIndex) {
            temporaryArray[tempPos++] = originalArray[behindStartIndex++];
        }

        for (int i = 0; i < num; i++, behindEndIndex--) {
            originalArray[behindEndIndex] = temporaryArray[behindEndIndex];
        }
    }

    /**
     * ����������������
     * <p>
     * �����������˼��:(ð�������������ͬ����������)
     * ͨ��һ�����򽫴��ż�¼�ָ�ɶ����������֣�����һ���ּ�¼�Ĺؼ��־�����һ���ּ�¼�Ĺؼ���С��
     * ��ɷֱ���������ּ�¼�������������Դﵽ�������������Ŀ�ġ�
     * <p>
     * һ�㲽�裺
     * 1)���S��Ԫ�ظ�����0��1���򷵻�
     * 2)ȡS����һԪ��v,��֮Ϊ��ŦԪ
     * 3)��S-{v}(S������Ԫ��)���ֳ��������ཻ�ļ���
     * 4)����quickSort(S1)���v�̶�����quicksort(S2)
     *
     * @param array
     */
    public static void quickSort(int[] array) {

        //MySort.quickSortRecursion(array,0,array.length-1);
        MySort.quickSort(array, 0, array.length - 1);
    }

    public static void quickSortRecursion(int[] array, int startIndex, int endIndex) {
        //�Ƚ��Լ��ⲿ�ֽ�����Ӧ����
        MySort.quickSorting(array, startIndex, endIndex);
//        System.out.println("startIndex------->"+startIndex);
//        System.out.println("endIndex--------->"+endIndex);
//        for(int i:array){
//            System.out.print(i+",");
//        }
//        System.out.println();

        //����¼���Ϸֳ�������
        if (endIndex > startIndex) {
            int middle = startIndex + (endIndex - startIndex) / 2;
            MySort.quickSortRecursion(array, startIndex, middle);
            MySort.quickSortRecursion(array, middle + 1, endIndex);
        }
    }

    /**
     * ����Ҫ����Ĳ��֣��ٷֳ������֣����н�������  (�Լ����뷨��Ч�ʵͣ�̫��)
     * ͨ�����ѡȡ��ŦԴ������Ҫ����Ĳ��� �ٷֳ������֣��������ֿ��Բ��ǵȳ��ģ�
     * Ŀ�ģ�����Ҫ����Ĳ���  ������  ǰ�벿�ּ�¼�Ĺؼ��־��Ⱥ�벿�ּ�¼�Ĺؼ���
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSorting(int[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i <= startIndex + (endIndex - startIndex) / 2; i++) {
            int minIndex = i;
            for (int j = startIndex + (endIndex - startIndex) / 2 + 1; j <= endIndex; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {//��Сֵ�Ѿ��ı�  ��������Ԫ��λ��
                MySort.swap(array, i, minIndex);
            }
        }
    }

    /**
     * ���������Ż���:
     * (1)ѡȡ��ŦԪ
     * 1)��ȫ�������������ѡȡ
     * 2)������ֵ�ָ��ʹ��������ˣ��Ҷˣ�����λ���ϵ�����Ԫ�ص���ֵ��Ϊ��ŦԪ
     * (2)�ָ����:
     * 1)����ŦԪ������Ԫ�ؽ���ʹ����ŦԪ�뿪Ҫ���ָ�����ݶΡ�
     * 2)�ָ�׶Σ�������СԪ���Ƶ��������ߣ�������Ԫ���Ƶ�������ұߡ�"С"��"��"���������ŦԪ
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {

        if(endIndex - startIndex>0){
            int middle = MySort.medianOfThree(array, startIndex, endIndex);

            //��i��jֹͣʱ,iָ��һ����Ԫ�ض�jָ��һ��СԪ�أ����i��j����ߣ���ô��������Ԫ�ػ���
            int i = startIndex;//��ǰ�����ң���i�������ƣ��ƹ���ЩС����ŦԪ��Ԫ��
            int j = endIndex - 2;//�Ӻ���ǰ����j�������ƣ��ƹ���Щ������ŦԪ��Ԫ��
            while (true) {
                while (array[i] < middle) {
                    ++i;
                }
                while (array[j] > middle) {
                    --j;
                }
                //i��jֹͣ���ƶ�   array[i]��array[j]��middleֵ���ʱ��i��jҲ��ֹͣ�ƶ�
                if (i < j) {
                    MySort.swapBytemp(array, i, j);
                } else {
                    break;
                }
            }
            //��i�ƶ���j���ұ�ʱ��ֹͣ�ƶ�������ѭ��  ������ŦԪ��i��ָ���Ԫ��
            MySort.swapBytemp(array, i, endIndex - 1);

            MySort.quickSort(array, startIndex, i - 1);
            MySort.quickSort(array, i + 1, endIndex);
        }else{
            return;
        }
    }

    /**
     * ����������ֵ�ָ��ȡ
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int medianOfThree(int[] array, int left, int right) {
        int middle = (right + left) / 2;
        if (array[left] > array[middle]) {
            MySort.swapBytemp(array, left, middle);
        }
        if (array[left] > array[right]) {//���������е���Сֵ�ŵ�������leftλ��
            MySort.swapBytemp(array, left, right);
        }
        if (array[middle] > array[right]) {
            MySort.swapBytemp(array, middle, right);
        }
        //����ŦԪ������Ԫ�ؽ���ʹ����ŦԪ�뿪Ҫ���ָ�����ݶ�
        MySort.swapBytemp(array, middle, right - 1);
        return array[right - 1];
    }

    /**
     * ��������Ԫ��  ��bug,��a=bʱ������������
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void swapBytemp(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    /**
     * ��ȡ��Ԫ��(array[0]Ϊ��һ����Ԫ��)�����ӽ������
     *
     * @param i
     * @return
     */
    public static int getLeftChild(int i) {
        return 2 * i + 1;//���ڵ�һ������������0  ������ȫ�����������(��1��ʼ)�����ӽ����Ա�ʾΪ��2*i-1��
        // ��i��0��ʼ��ʱ ���ӽ���±�ɱ�ʾ 2*(i+1)-1 = 2*i+1
    }

    public static void main(String[] args) {
        int[] a = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        int[] b = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
        MySort.quickSort(b);
        //System.out.println(a);
        for (int i : b) {
            System.out.print(i + ",");
        }
    }
}
