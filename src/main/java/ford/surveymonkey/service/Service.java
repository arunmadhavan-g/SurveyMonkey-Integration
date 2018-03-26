package ford.surveymonkey.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ford.surveymonkey.api.ServiceHeader;
import ford.surveymonkey.service.survey.SurveyLink;
import ford.surveymonkey.service.surveydetail.SurveyDetail;
import ford.surveymonkey.service.surveyresponse.SurveyResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

	private final Retrofit request;

	public Service(String accessToken) {
		request = new Retrofit.Builder()
				.baseUrl("https://api.surveymonkey.net/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

    private Map<String, String> header(ServiceHeader header) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", String.format("Bearer %s",header.getApiKey()));
        return headers;
    }

    public List<SurveyLink> surveys(ServiceHeader header) throws IOException {
		return request.create(SurveyListService.class)
					.surveys(header(header))
					.execute()
					.body()
					.getSurveyLinks();
	}

	public SurveyDetail surveyDetails(String surveyId, ServiceHeader header) throws IOException {
		return request.create(SurveyListService.class)
				.surveyDetails(header(header), surveyId)
				.execute()
				.body();
	}

	public SurveyResponse surveyResponses(String surveyId, ServiceHeader header) throws IOException {
		return request.create(SurveyListService.class)
				.surveyResponses(header(header), surveyId)
				.execute()
				.body();
	}
	
	public void createSurvey(String surveyName, ServiceHeader header) throws IOException{
		
		try {
		request.create(SurveyListService.class)
				.createSurvey(header(header), new CreateSurveyBody(header.getSampleId(), surveyName))
				.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println(response.code());
		//System.out.println(response.errorBody().string());
	}
	
	public void deleteSurvey(String surveyId, ServiceHeader header) throws IOException{
		request.create(SurveyListService.class)
		.deleteSurvey(header(header), surveyId)
		.execute();
	}

}
