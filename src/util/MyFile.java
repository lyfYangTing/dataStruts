package util;

import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;

import java.io.*;

/**
 * Created by 18435 on 2017/11/2.
 */
public class MyFile {
    public static void readFileByLines(String fileName) throws Exception {


        // ���ļ�
        String path = "";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("��־��");
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);


        HSSFCell cell = row.createCell(0);
        cell.setCellValue("businessNum");
        cell.setCellStyle(style);

        String[] name = {"carStatus","numPlate","picType","signature","pic1-truncated","psId","deviceNo","type", "token","__flowId__","entryTime","licenseColor","isManualCheck","recordCode","recordState","pic2-truncated","timestamp","imgList"};
        for(int i=0;i<name.length;i++){
            cell = row.createCell(i+1);
            cell.setCellValue(name[i]);
            cell.setCellStyle(style);
        }

        // ����txt�е�����
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(isr);
            String tempString = null;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            int i = 0;
            while ((tempString = reader.readLine()) != null) {
                System.out.println("��ȡ��һ������Ϊ------------->" + tempString);
                String s = new String(tempString.getBytes("ISO-8859-1"),"GBK");
                System.out.println("��ȡ����Ϊ------------->" + s);
                //�Զ�ȡ����һ�����ݽ��н���
                String jsonStr = tempString.substring(tempString.indexOf("{"));
                System.out.println("json����Ϊ------------->" + jsonStr);
                //��json�ַ���ת����json����
                JSONObject jsonobject = JSONObject.fromObject(jsonStr);
                System.out.println("json����Ϊ------------->" + jsonobject.get("businessNum"));
                System.out.println("json����Ϊ------------->" + jsonobject.get("carStatus"));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MyFile.readFileByLines("c://localDataFile.log");
    }
}
