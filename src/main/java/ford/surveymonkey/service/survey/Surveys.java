package ford.surveymonkey.service.survey;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Surveys {
	
	@SerializedName("data")
	private List<SurveyLink> surveyLinks;
	
}
