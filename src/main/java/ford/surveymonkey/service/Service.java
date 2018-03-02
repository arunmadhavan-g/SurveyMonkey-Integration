package ford.surveymonkey.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ford.surveymonkey.service.survey.SurveyLink;
import ford.surveymonkey.service.surveydetail.SurveyDetail;
import ford.surveymonkey.service.surveyresponse.SurveyResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

	private final Retrofit request;
	private final Map<String, String> headers;

	public Service(String accessToken) {
		headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", String.format("Bearer %s",accessToken));

		request = new Retrofit.Builder()
				.baseUrl("https://api.surveymonkey.net/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	public List<SurveyLink> surveys() throws IOException {
		return request.create(SurveyListService.class)
					.surveys(headers)
					.execute()
					.body()
					.getSurveyLinks();
	}

	public SurveyDetail surveyDetails(String surveyId) throws IOException {
		return request.create(SurveyListService.class)
				.surveyDetails(headers, surveyId)
				.execute()
				.body();
	}

	public SurveyResponse surveyResponses(String surveyId) throws IOException {
		return request.create(SurveyListService.class)
				.surveyResponses(headers, surveyId)
				.execute()
				.body();
	}
	
	public void createSurvey(String surveyName, String templateId) throws IOException{
		
		try {
		request.create(SurveyListService.class)
				.createSurvey(headers, new CreateSurveyBody(templateId, surveyName))
				.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println(response.code());
		//System.out.println(response.errorBody().string());
	}
	
	public void deleteSurvey(String surveyId) throws IOException{
		request.create(SurveyListService.class)
		.deleteSurvey(headers, surveyId)
		.execute();
	}

}
