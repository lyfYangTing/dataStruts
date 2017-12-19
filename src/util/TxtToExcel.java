package util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;

import java.io.*;

/**
 * Created by 18435 on 2017/11/1.
 */
public class TxtToExcel {


    //将txt文件中的json类型数据 读取到excel表格中
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
                String jsonStr = tempString.substring(tempString.indexOf("{"));
                System.out.println("json数据为------------->" + jsonStr);
                //将json字符串转换成json对象
                JSONObject jsonobject = JSONObject.fromObject(jsonStr);
                System.out.println("json数据为------------->" + jsonobject.get("businessNum"));
                System.out.println("json数据为------------->" + jsonobject.get("carStatus"));

                row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue((String)jsonobject.get("businessNum"));
                for(int j=0;j<name.length;j++){
                    if(name[j].equals("imgList")){
                        JSONArray jsonArray = (JSONArray)jsonobject.get("imgList");
                        StringBuffer sb = new StringBuffer();
                        for(int k=0;k<jsonArray.size();k++){
                            sb.append(jsonArray.get(k)+",");
                        }
                        row.createCell(j+1).setCellValue(sb.toString());
                    }else{
                        row.createCell(j+1).setCellValue((String)jsonobject.get(name[j]));
                    }
                }
                i++;
            }
            reader.close();

            FileOutputStream fout = new FileOutputStream("E:/rizhi.xls");
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        TxtToExcel.readFileByLines("c://localDataFile.log");
    }
}
