package ford.surveymonkey.mapper;

import java.util.ArrayList;
import java.util.List;

import ford.surveymonkey.mapper.response.IndividualResponse;
import ford.surveymonkey.mapper.response.Response;
import ford.surveymonkey.service.surveydetail.SurveyDetail;
import ford.surveymonkey.service.surveyresponse.SurveyResponse;

public class Mapper {

	public IndividualResponse buildQuestions(SurveyDetail surveyDetail) {
		IndividualResponse response = new IndividualResponse();
		response.setId(surveyDetail.getId());
		response.setTitle(surveyDetail.getTitle());
		response.setResponses(new ResponsesMapper().buildResponses(surveyDetail.getPages()));
		return response;
	}

	public IndividualResponse fillResponses(IndividualResponse emptyResponse, SurveyResponse surveyResponse) {
		List<Response> responses = new ArrayList<>();
		for(Response response: emptyResponse.getResponses()) {
			Response newResponse = new Response();
			newResponse.setId(response.getId());
			newResponse.setTitle(response.getTitle());
			newResponse.setOptions(surveyResponse.optionsForQuestionId(response.getId(),response.getOptions()));
			newResponse.setComments(surveyResponse.commentsForQuestionId(response.getId()));
			responses.add(newResponse);
		}
		IndividualResponse returnVal = new IndividualResponse();
		returnVal.setId(emptyResponse.getId());
		returnVal.setTitle(emptyResponse.getTitle());
		returnVal.setResponses(responses);
		return returnVal;
	}


}
