package ford.surveymonkey.service.surveydetail;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class SurveyDetail {
	
	@SerializedName("response_count")
	private int responseCount;
	private String id;
	@SerializedName("analyze_url")
	private String analyzeURL;
	private List<Page> pages;
	@SerializedName("summary_url")
	private String summaryURL;
	private String title; 
	@SerializedName("collect_url")
	private String collectURL;
	
}
