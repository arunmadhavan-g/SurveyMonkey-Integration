package ford.surveymonkey.mapper;

import java.util.ArrayList;
import java.util.List;

import ford.surveymonkey.mapper.response.Response;
import ford.surveymonkey.service.surveydetail.Page;
import ford.surveymonkey.service.surveydetail.Question;

public class ResponsesMapper {

	public List<Response> buildResponses(List<Page> pages) {
		Page page = pages.get(0);
		List<Response> responses = new ArrayList<>();
		Response response; 
		for(Question question: page.getQuestions()) {
			response = new Response();
			response.setTitle(question.getHeadings().get(0).getHeading());
			response.setId(question.getId());
			response.setOptions(new OptionMapper().buildOption(question.getAnswers()));
			response.setComments(new ArrayList<>());
			responses.add(response);
		}
		return responses;
	}

}
