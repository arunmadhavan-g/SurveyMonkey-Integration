package ford.surveymonkey.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import ford.surveymonkey.service.surveyresponse.SurveyResponse;

public class ServiceTest {

	private static final String SURVEY_ID = "122832932";
	private final Service service = new Service(ServiceConstants.accessToken);

	//@BeforeClass
	public static void proxy() {
		 System.setProperty("http.proxyHost", "proxyvipfmcc.nb.ford.com");
	        System.setProperty("http.proxyPort", "83");
	        System.setProperty("https.proxyHost", "proxyvipfmcc.nb.ford.com");
	        System.setProperty("https.proxyPort", "83");
	}
	
	@Test
	public void givenAccessToken_getSurveys() throws Exception {
		assertThat(service.surveys()).hasSize(11);
	}
	
	@Test
	public void givenSurveyId_ReadSurveyDetails() throws Exception {
		assertThat(service.surveyDetails(SURVEY_ID).getResponseCount()).isEqualTo(4);
	}
	
	@Test
	public void givenSurveyId_ReadSurveyResponses() throws Exception {
		SurveyResponse surveyResponses = service.surveyResponses(SURVEY_ID);
		assertThat(surveyResponses.getTotal()).isEqualTo(4);
	}
	
}
