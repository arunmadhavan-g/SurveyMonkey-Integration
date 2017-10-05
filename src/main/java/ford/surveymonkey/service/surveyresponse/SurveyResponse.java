package ford.surveymonkey.service.surveyresponse;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import ford.surveymonkey.mapper.response.Option;
import lombok.Data;

@Data
public class SurveyResponse {

	private int total;
	@SerializedName("data")
	private List<Response> response;
	
	
	public List<Option> optionsForQuestionId(String id, List<Option> options) {
		for(Response response: response) {
			for(Question question: response.getPages().get(0).getQuestions()) {
				question.updateOptionsForId(options, id);
			}
		}
		return options;
	}
	
	public List<String> commentsForQuestionId(String id) {
		List<String> comments = new ArrayList<>();
		for(Response response: response) {
			for(Question question: response.getPages().get(0).getQuestions()) {
				comments.addAll(question.getCommentsForId(id));
			}
		}
		return comments;
	}
	
}
