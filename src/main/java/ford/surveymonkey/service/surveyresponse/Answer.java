package ford.surveymonkey.service.surveyresponse;

import com.google.gson.annotations.SerializedName;

import ford.surveymonkey.mapper.response.Option;
import lombok.Data;

@Data
public class Answer {
	@SerializedName("choice_id")
	private String choiceId;
	private String text;
	
	public void updateOptionForId(Option option, String id) {
		if(option.getId().equals(id)) {
			option.incrementValue();
		}
	}
}
