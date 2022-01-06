/*
 * 대학입학정보포털 사이트
 * 
 * 한국대학교육협의회
 * 폭스소프트 개발팀
 */
package kcue.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.util.FileCopyUtils;

/**  
 * @Class Name : ExcelUtil.java
 * @Description : ExcelUtil Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2012.06.14           최초생성
 * 
 * @author 폭스소프트 개발팀
 * @since 2012.06.14
 * @version 1.0
 * @see
 */
public class ExcelUtil {

    Logger log = Logger.getLogger(this.getClass());

	public void writeExcel (HashMap<String, String[]> infos, List<HashMap<String, Object>> models, String fileName, HttpServletRequest request, HttpServletResponse response) {

		if ( infos == null || models == null) {
			return;
		}
		
		String[] titles	= infos.get("titles"); 
		String[] cols	= infos.get("cols"); 

		if (titles.length != cols.length ) {
			return;
		}
		
		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet("Sheet1");
		HSSFRow row = sheet.createRow((short)0);

		HSSFCellStyle styleTitle = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);

		styleTitle.setBorderBottom(CellStyle.BORDER_THIN);
		styleTitle.setBorderTop(CellStyle.BORDER_THIN);
		styleTitle.setBorderLeft(CellStyle.BORDER_THIN);
		styleTitle.setBorderRight(CellStyle.BORDER_THIN);
		styleTitle.setFillPattern((short)1);
		styleTitle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		styleTitle.setAlignment(CellStyle.ALIGN_CENTER);
		styleTitle.setFont(font);

		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(titles[i]);
			cell.setCellStyle(styleTitle);
		}

		HashMap<String, Object> data;
		Object obj;

		HSSFCellStyle styleBody = wb.createCellStyle();
		styleBody.setBorderBottom(CellStyle.BORDER_THIN);
		styleBody.setBorderTop(CellStyle.BORDER_THIN);
		styleBody.setBorderLeft(CellStyle.BORDER_THIN);
		styleBody.setBorderRight(CellStyle.BORDER_THIN);
		
		for (int i = 0; i < models.size(); i++) {

			data = models.get(i);
			HSSFRow rowData = sheet.createRow((short)1+i);

			for (int j = 0; j < cols.length; j++) {
				
				HSSFCell cell = rowData.createCell(j);
				
				obj = data.get(cols[j]);
				
				if ( obj == null) {
					cell.setCellValue("");
				} else if ( obj instanceof String ) {
					styleBody.setAlignment(CellStyle.ALIGN_LEFT);
					cell.setCellValue((String)obj);
				} else {
					styleBody.setAlignment(CellStyle.ALIGN_RIGHT);
					cell.setCellValue(Double.parseDouble(""+obj));
				}

				cell.setCellStyle(styleBody);
			}
		}
		
		for (int i = 0; i < titles.length; i++) {
			sheet.autoSizeColumn(i);
		}

		File file;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		OutputStream out = null;
		
		try{
			
			file = new File(fileName);
			fos = new FileOutputStream(file);
			wb.write(fos);
			
			String mimetype = "application/x-msdownload";
			response.setContentType(mimetype);
			BrowserUtil.setDisposition(fileName, request, response);
			
			response.setContentLength((int)file.length());

			out = response.getOutputStream();
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);

			out.flush();
			
			//file.delete();

		} catch (Exception e) {
			// Do nothing....
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception ex) {
					this.log.debug(">> 무시된 오류: " + ex.getMessage());
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception ex) {
					this.log.debug(">> 무시된 오류: " + ex.getMessage());
				}
			}
		}
	}
}