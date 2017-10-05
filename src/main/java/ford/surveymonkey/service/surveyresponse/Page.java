package ford.surveymonkey.service.surveyresponse;

import java.util.List;

import lombok.Data;

@Data
public class Page {

	private List<Question> questions;
}
