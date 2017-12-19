package util;

import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;

import java.io.*;

/**
 * Created by 18435 on 2017/11/2.
 */
public class MyFile {
    public static void readFileByLines(String fileName) throws Exception {


        // 打开文件
        String path = "";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("日志表");
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

        // 读入txt中的内容
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(isr);
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            int i = 0;
            while ((tempString = reader.readLine()) != null) {
                System.out.println("读取的一行数据为------------->" + tempString);
                String s = new String(tempString.getBytes("ISO-8859-1"),"GBK");
                System.out.println("读取数据为------------->" + s);
                //对读取到的一行数据进行解析
                String jsonStr = tempString.substring(tempString.indexOf("{"));
                System.out.println("json数据为------------->" + jsonStr);
                //将json字符串转换成json对象
                JSONObject jsonobject = JSONObject.fromObject(jsonStr);
                System.out.println("json数据为------------->" + jsonobject.get("businessNum"));
                System.out.println("json数据为------------->" + jsonobject.get("carStatus"));
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
