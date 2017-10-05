package ford.surveymonkey.service;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class CreateSurveyBody {

	@SerializedName("from_survey_id")
	String templateId;
	@SerializedName("title")
	String surveyName;
	
	public CreateSurveyBody(String templateId, String surveyName) {
		this.templateId = templateId;
		this.surveyName = surveyName;
	}
	
}
