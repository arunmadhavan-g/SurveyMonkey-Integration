package ford.surveymonkey.service.surveyresponse;

import java.util.List;

import lombok.Data;

@Data
public class Response {
	private String id;
	private List<Page> pages;
}
