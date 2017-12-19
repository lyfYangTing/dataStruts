package util;

/**
 * Created by 18435 on 2017/10/25.
 */
public class MyTime {

    /**
     * ��ʮ��Сʱ�Ƶ�ʱ���ַ���ת���ɶ�ʮ��Сʱ�Ƶ�ʱ���ַ���
     *
     * @param shiErhourTime  ������ʽ��hh:mm:ssAM ���� hh:mm:ssPM(01<=hh<=12 and mm>=00 , ss<=12)
     * @return  ����ֵ��ʽ:hh:mm:ss (00<=hh<=23)
     * ע�� ͨ�� �����ʾΪ 12��00PM             ��ҹ��ʾΪ  12��00AM
     *
     */
    public static String get24HourTime(String shiErhourTime){
        String[] hourtimes = shiErhourTime.split(":");
        if(hourtimes[2].contains("PM")){
            String hourTime = Integer.parseInt(hourtimes[0])== 12 ? "12" : String.valueOf(Integer.parseInt(hourtimes[0])+12);
            return shiErhourTime.replace(hourtimes[0],hourTime).substring(0,8);
        }else{
            if(Integer.parseInt(hourtimes[0])== 12){
                return shiErhourTime.replace(hourtimes[0],"00").substring(0,8);
            }else{
                return shiErhourTime.substring(0,8);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(MyTime.get24HourTime("00:05:45AM"));
    }
}
