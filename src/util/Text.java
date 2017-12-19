package util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;

import java.io.*;

public class Text {//��ȡ�ļ�  ������
    public static String sourceFilePath = "logTxt/";
    public static String objectiveFilePath = "/resources/logExcel/";

    public void readFileByLines(String fileName) throws Exception {
        // ���ļ�
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

        // //ͨ����ȡclassloader����ȡresource�ļ� ����txt�е�����
        System.out.println(Text.sourceFilePath+fileName+".log");
        InputStream fis = Text.class.getClassLoader().getResourceAsStream(Text.sourceFilePath+fileName+".log");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(isr);
            String tempString;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            int i = 0;
            while ((tempString = reader.readLine()) != null) {
                System.out.println("��ȡ��һ������Ϊ------------->" + tempString);
                String jsonStr = tempString.substring(tempString.indexOf("{"));
                System.out.println("json����Ϊ------------->" + jsonStr);
                //��json�ַ���ת����json����
                JSONObject jsonobject = JSONObject.fromObject(jsonStr);
                System.out.println("json����Ϊ------------->" + jsonobject.get("businessNum"));
                System.out.println("json����Ϊ------------->" + jsonobject.get("carStatus"));

                row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue((String)jsonobject.get("businessNum"));
                for(int j=0;j<name.length;j++){
                    if(name[j].equals("imgList")){
                        JSONArray jsonArray = (JSONArray)jsonobject.get("imgList");
                        for (Object aJsonArray : jsonArray) {
                            row.createCell(j+1).setCellValue((String)aJsonArray);
                            j++;
                        }

                    }else{
                        row.createCell(j+1).setCellValue((String)jsonobject.get(name[j]));
                    }
                }
                i++;
            }
            reader.close();
            //F:\gitCloneProject\dataStructure System.getProperty("user.dir") �÷�����ȡ�����̵ľ���·��
            String relativelyPath = System.getProperty("user.dir");
            //F:\gitCloneProject\dataStructure/resources/logExcel/localDataFile.xls
            System.out.println("--------------"+relativelyPath+Text.objectiveFilePath + fileName + ".xls");
            FileOutputStream fout = new FileOutputStream(relativelyPath+Text.objectiveFilePath + fileName + ".xls");
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
        new Text().readFileByLines(args[0]);
    }
}
