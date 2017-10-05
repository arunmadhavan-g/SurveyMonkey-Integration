package ford.surveymonkey.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import ford.surveymonkey.mapper.response.IndividualResponse;
import ford.surveymonkey.service.surveydetail.SurveyDetail;
import ford.surveymonkey.service.surveyresponse.SurveyResponse;

public class MapperTest {

	Mapper mapper = new Mapper();
	
	@Test
	public void fromSurveyDetails_CreateQuestionListOfAnswersOptions() throws Exception {
		SurveyDetail surveyDetail= new TestSupportHelper().mockedSurveyDetails();
		IndividualResponse response = mapper.buildQuestions(surveyDetail);
		assertThat(response.getTitle()).isEqualTo("Marudhu - Peer to Peer Feedback");
		assertThat(response.getResponses()).hasSize(10);
		System.out.println(response);
	}
	
	@Test
	public void withSurveyResponse_FillIndividualResponse() throws Exception {
		SurveyDetail surveyDetail= new TestSupportHelper().mockedSurveyDetails();
		SurveyResponse surveyResponse = new TestSupportHelper().mockedSurveyResponse();
		IndividualResponse emptyResponse = mapper.buildQuestions(surveyDetail);
		IndividualResponse response = mapper.fillResponses(emptyResponse,surveyResponse);
		//assertThat(response.getResponses().get(0).getOptions().get(0).getValue()).isGreaterThan(0);
		System.out.println(response);
	}
	
	@Test
	public void testSurveyResponseMapper() throws Exception {
		SurveyResponse surveyResponse = new TestSupportHelper().mockedSurveyResponse();
		System.out.println(surveyResponse);
	}
}
