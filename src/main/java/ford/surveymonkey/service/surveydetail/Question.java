package ford.surveymonkey.service.surveydetail;

import java.util.List;

import lombok.Data;

@Data
public class Question {

	private List<Heading> headings;
	private Answer answers;
	private String id;
}
