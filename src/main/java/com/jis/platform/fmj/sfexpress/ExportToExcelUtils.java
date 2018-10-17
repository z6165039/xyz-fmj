package com.jis.platform.fmj.sfexpress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 功能：导出到Excel报表
 * fileName：导出文件名
 * sumCount：数字格式化 列表
 * isCount：数字格式化列表是否参加合计
 * dataList：数据源(含有title数据)
 * response:用户请求
 * @author SunRise
 * 2018-1-10
 */
public class ExportToExcelUtils {



	public void ex(){
		List<String> showNameList = new ArrayList<>();
		showNameList.add("姓名");
		showNameList.add("组别");
		showNameList.add("车型");
		showNameList.add("发动机");
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Set<String> set =  map.keySet();
		for(String s : set){
			map.put(s, s);
		}
	}


	public static void exportReportToExcel(String fileName, List<LinkedHashMap<String, Object>> dataList, Map<String,Double> sumCount, HttpServletResponse response){
		exportReportToExcel(fileName, dataList, sumCount,false, response);
	}
	
	public static void exportReportToExcel(String fileName,List<LinkedHashMap<String, Object>> dataList,Map<String,Double> sumCount,Boolean isCount,HttpServletResponse response){
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMDDhhmmss");
		String nowDate = dateFormat.format(new Date());
		//文件名
		String exportFileName = fileName+nowDate+".xlsx";
		//声明一个工作薄
		XSSFWorkbook workbook =null;
		workbook = new XSSFWorkbook();
		//生成一个表格
		XSSFSheet sheet =null;
		sheet = workbook.createSheet();
		workbook.setSheetName(0,fileName);
		//导入数据
		int dataLength = dataList.size();
		XSSFRow lastLineRow = sheet.createRow(dataLength);
		if(isCount){
			lastLineRow.createCell(0).setCellValue("合计：");
		}
		for(int i = 0; i < dataLength; i++){
			XSSFRow newRow = sheet.createRow(i);
			Map<String, Object> newRowDataMap = dataList.get(i);
			int temp = 0;
			for (String key : newRowDataMap.keySet()) {
				if(newRowDataMap.get(key)!=null){
					String newColumnValueString = newRowDataMap.get(key).toString();
					Double rowCountvalueDouble = sumCount.get(key);
					if(rowCountvalueDouble!=null && i>0){//key在格式化统计列表中
						Double newColumnValueDouble = Double.parseDouble(newColumnValueString);
						newRow.createCell(temp).setCellValue(newColumnValueDouble);
						if(isCount){  //需要统计
							Double newColumnCountValueDouble = rowCountvalueDouble.doubleValue()+newColumnValueDouble;
							if(i > dataLength-2){ //如果插入数据为最后一行，则将统计的数据列并行添加在尾部
								lastLineRow.createCell(temp).setCellValue(newColumnCountValueDouble);
							}else{
								sumCount.put(key, newColumnCountValueDouble);
							}
						}
					}else{
						newRow.createCell(temp).setCellValue(newColumnValueString);
					}
				}else{
					newRow.createCell(temp).setCellValue("");
				}
				temp++;
		    }
		}
		
		//文件输出
		File file = new File("./"+exportFileName);
		FileOutputStream outStream = null;
		try{
			outStream = new FileOutputStream(file);
			workbook.write(outStream);
			outStream.flush();
			outStream.close();
			//如果文件下载成功
			if(DowloadExccelToLocal("./"+exportFileName,exportFileName,response)){
				file.delete(); //服务器缓存文件清除
			}
		}catch(Exception e){
			System.out.println("生成Excel报表IO异常:"+e.toString());
			e.printStackTrace();  
		}	
	}

	/**
	 * 功能：下载报表到本地
	 * fileUrl:下载文件路径
	 * fileName:输出文件名
	 * response:用户请求
	 */
	
	private static boolean DowloadExccelToLocal(String fileUrl,String fileName,HttpServletResponse response) throws FileNotFoundException, IOException{
		  response.setContentType("application/x-download");    
		  response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));  
		  OutputStream outp = null;  
		  FileInputStream in = null;  
		  try  
		  {  
			  outp = response.getOutputStream();  
			  in = new FileInputStream(fileUrl);  
			  byte[] b = new byte[1024];  
			  int i = 0;  
			  while((i = in.read(b)) > 0)  
			  {  
				  outp.write(b, 0, i);  
			  }
			  in.close();
			  outp.close();
		  }  
		  catch(Exception e)  
		  {  
			  System.out.println("文件下载异常!");  
			  e.printStackTrace();  
			  return false;
		  }
		  return true;
	}
	
}
