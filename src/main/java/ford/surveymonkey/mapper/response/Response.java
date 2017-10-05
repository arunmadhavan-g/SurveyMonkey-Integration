package ford.surveymonkey.mapper.response;

import java.util.List;

import lombok.Data;

@Data
public class Response {

	private String id;
	private String title;
	private List<Option> options;
	private List<String> comments;
}
