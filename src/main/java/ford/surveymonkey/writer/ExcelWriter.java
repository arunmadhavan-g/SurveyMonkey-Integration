package ford.surveymonkey.writer;

import java.io.OutputStream;
import java.util.List;

import ford.surveymonkey.mapper.response.IndividualResponse;
import ford.surveymonkey.mapper.response.Option;
import ford.surveymonkey.mapper.response.Response;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelWriter {

	private WritableWorkbook workBook;

	public ExcelWriter(OutputStream os) throws Exception{
		workBook = Workbook.createWorkbook(os);
	}

	public void write(List<IndividualResponse> responses) throws Exception {
		int sheetNo = 0;
		for(IndividualResponse response: responses) {
			WritableSheet sheet = workBook.createSheet(response.getTitle(), sheetNo);
			sheetNo++;
			printQuestions(sheet, response.getResponses());
		}
		workBook.write();
		workBook.close();
	}

	private void printQuestions(WritableSheet sheet, List<Response> responses) throws Exception {
		int row = 0;
		for(Response response: responses) {
			row = printQuestion(response, sheet, row);
		}
	}

	private int printQuestion(Response response, WritableSheet sheet, int row) throws Exception {
		Label questionTxt = new Label( 0,row, response.getTitle());
		sheet.addCell(questionTxt);
		row++;
		row = printAnswerOptions(response, sheet, row);
		row = printComments(response, sheet, row);
		row++;
		return row;
	}

	private int printComments(Response response, WritableSheet sheet, int row)
			throws WriteException, RowsExceededException {
		for (String comment : response.getComments()) {
			Label comments = new Label(0, row, comment);
			sheet.addCell(comments);
			row++;
		}
		return row;
	}

	private int printAnswerOptions(Response response, WritableSheet sheet, int row) throws WriteException, RowsExceededException {
		for (Option answer : response.getOptions()) {
			Label answerTxt = new Label(0, row, answer.getText());
			sheet.addCell(answerTxt);

			Number answerCount = new Number(1, row, answer.getValue());
			sheet.addCell(answerCount);
			row++;
		}
		return row;
	}


}
