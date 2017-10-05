package ford.surveymonkey.service;

import java.util.Map;

import ford.surveymonkey.service.survey.Surveys;
import ford.surveymonkey.service.surveydetail.SurveyDetail;
import ford.surveymonkey.service.surveyresponse.SurveyResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SurveyListService {

	@GET("/v3/surveys")
	Call<Surveys> surveys(@HeaderMap Map<String, String> headers);

	@GET("/v3/surveys/{id}/details")
	Call<SurveyDetail> surveyDetails(@HeaderMap Map<String, String> headers, @Path("id") String id);

	@GET("/v3/surveys/{id}/responses/bulk")
	Call<SurveyResponse> surveyResponses(@HeaderMap Map<String, String> headers, @Path("id") String id);

	@POST("/v3/surveys")
	Call<ResponseBody> createSurvey(@HeaderMap Map<String, String> headers, @Body CreateSurveyBody body);

	@DELETE("/v3/surveys/{id}")
	Call<ResponseBody> deleteSurvey(@HeaderMap Map<String, String> headers, @Path("id") String surveyId); 
	
}
