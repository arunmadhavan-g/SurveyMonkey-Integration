package ford.surveymonkey.writer;

import org.junit.Before;

import ford.surveymonkey.mapper.Mapper;
import ford.surveymonkey.mapper.TestSupportHelper;
import ford.surveymonkey.mapper.response.IndividualResponse;
import ford.surveymonkey.service.surveydetail.SurveyDetail;
import ford.surveymonkey.service.surveyresponse.SurveyResponse;

public class ExcelWriterTest {

	private IndividualResponse response;

	@Before
	public void setup() throws Exception{
		Mapper mapper = new Mapper();
		SurveyDetail surveyDetail= new TestSupportHelper().mockedSurveyDetails();
		SurveyResponse surveyResponse = new TestSupportHelper().mockedSurveyResponse();
		IndividualResponse emptyResponse = mapper.buildQuestions(surveyDetail);
		response = mapper.fillResponses(emptyResponse,surveyResponse);
	}
	
	
}
