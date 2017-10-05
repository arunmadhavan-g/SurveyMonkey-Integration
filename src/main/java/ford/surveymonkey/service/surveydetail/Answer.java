package ford.surveymonkey.service.surveydetail;

import java.util.List;

import lombok.Data;

@Data
public class Answer {

	private String id;
	private List<Choices> choices;
}
