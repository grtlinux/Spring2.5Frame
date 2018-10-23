package kame.spring.chap05.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kame.spring.chap05.controller.PageRank;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class PageRanksView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HSSFSheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet);

		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRanks");
		short rowNum = 1;
		for (PageRank rank : pageRanks) {
			createPageRankRow(sheet, rank, rowNum++);
		}
	}

	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "페이지 순위", HSSFWorkbook.ENCODING_UTF_16);
		sheet.setColumnWidth((short) 1, (short) (256 * 20));
		return sheet;
	}

	private void createColumnLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow((short) 0);
		HSSFCell cell = firstRow.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("순위");

		cell = firstRow.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("페이지");
	}

	private void createPageRankRow(HSSFSheet sheet, PageRank rank, short rowNum) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(rank.getRank());

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(rank.getPage());

	}
}
