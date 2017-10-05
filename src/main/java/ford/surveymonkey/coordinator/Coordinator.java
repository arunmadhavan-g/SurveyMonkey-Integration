package ford.surveymonkey.coordinator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ford.surveymonkey.mapper.Mapper;
import ford.surveymonkey.mapper.response.IndividualResponse;
import ford.surveymonkey.service.Service;
import ford.surveymonkey.service.ServiceConstants;
import ford.surveymonkey.service.survey.SurveyLink;
import ford.surveymonkey.writer.ExcelWriter;

public class Coordinator {

	private Service service = new Service(ServiceConstants.accessToken);
	
	public void collectResponses() throws Exception {
		List<IndividualResponse> results = new ArrayList<>();
		Mapper mapper = new Mapper();
		for(SurveyLink link: service.surveys()) {
			IndividualResponse emptyResponses = mapper.buildQuestions(service.surveyDetails(link.getId()));
			results.add(mapper.fillResponses(emptyResponses, service.surveyResponses(link.getId())));
		}
		
		ExcelWriter writer = new ExcelWriter("C:\\Arun\\Test.xls");
		writer.write(results);
	}
	
	public void createSurveys(List<String> names) throws IOException {
		for(String name: names) {
			service.createSurvey(String.format("%s - Peer to Peer review", name), ServiceConstants.sampleSurveyId);
		}
	}
	
	public void deleteSurveys()  throws IOException {
		for(SurveyLink link: service.surveys()) {
			if(link.getId() != ServiceConstants.sampleSurveyId)
				service.deleteSurvey(link.getId());
		}
	}
	
}
