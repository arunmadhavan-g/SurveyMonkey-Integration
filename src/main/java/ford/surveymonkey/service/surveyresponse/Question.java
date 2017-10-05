package ford.surveymonkey.service.surveyresponse;

import java.util.ArrayList;
import java.util.List;

import ford.surveymonkey.mapper.response.Option;
import lombok.Data;

@Data
public class Question {

	private String id;
	private List<Answer> answers;

	public List<String> getCommentsForId(String id) {
		List<String> comments = new ArrayList<>();
		if(this.id.equals(id)) {
			for(Answer answer: answers) {
				if(answer.getText()!= null)
					comments.add(answer.getText());
			}
		}
		return comments;
	}

	public void updateOptionsForId(List<Option> options, String id) {
		if(this.id.equals(id)) {
			for(Answer answer: answers) {
				Option option = getOptionForId(answer.getChoiceId(), options);
				if(option != null)
					answer.updateOptionForId(option, answer.getChoiceId());
			}
		}
	}
	
	private Option getOptionForId(String id, List<Option> options) {
		for(Option option: options) {
			if(option.getId().equals(id))
				return option;
		}
		return null;
	}
}
