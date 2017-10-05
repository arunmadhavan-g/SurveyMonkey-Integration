package ford.surveymonkey.mapper;

import java.io.File;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import ford.surveymonkey.service.survey.Surveys;
import ford.surveymonkey.service.surveydetail.SurveyDetail;
import ford.surveymonkey.service.surveyresponse.SurveyResponse;

public class TestSupportHelper {
	
	
	private <T> T mockedObject(String fileName, Class<T> type) throws Exception{
		Gson gson = new Gson();
		File file = new File(String.format("src/test/resources/%s", fileName));
		FileReader in = new FileReader(file);
		JsonReader reader = new JsonReader(in);
		return gson.fromJson(reader, type);
	}
	
	public Surveys mockedSurveys() throws Exception {
		return mockedObject("surveys-json.json", Surveys.class);
	}
	
	public SurveyDetail mockedSurveyDetails() throws Exception {
		return mockedObject("details-response.json", SurveyDetail.class);
	}
	
	public SurveyResponse mockedSurveyResponse() throws Exception{
		return mockedObject("bulk-response.json", SurveyResponse.class);
	}
	
}
