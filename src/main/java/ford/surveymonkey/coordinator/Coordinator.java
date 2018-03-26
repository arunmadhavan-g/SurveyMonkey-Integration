package ford.surveymonkey.coordinator;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import ford.surveymonkey.api.ServiceHeader;
import ford.surveymonkey.mapper.Mapper;
import ford.surveymonkey.mapper.response.IndividualResponse;
import ford.surveymonkey.service.Service;
import ford.surveymonkey.service.ServiceConstants;
import ford.surveymonkey.service.survey.SurveyLink;
import ford.surveymonkey.service.surveyresponse.SurveyResponse;
import ford.surveymonkey.writer.ExcelWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class Coordinator {

	private Service service = new Service(ServiceConstants.accessToken);
	
	public void collectResponses(OutputStream os, ServiceHeader header) throws Exception {
		List<IndividualResponse> results = new ArrayList<>();
		Mapper mapper = new Mapper();
		for(SurveyLink link: service.surveys(header)) {
			IndividualResponse emptyResponses = mapper.buildQuestions(service.surveyDetails(link.getId(), header));
			if(emptyResponses != null)
				System.out.println(String.format("No. of Questions for the Survey %s is %d", link.getTitle(), emptyResponses.getResponses().size()));
			SurveyResponse surveyResponses = service.surveyResponses(link.getId(), header);
			if(surveyResponses != null)
				System.out.println(String.format("No. of Questions for the Survey %s is %d", link.getTitle(), surveyResponses.getResponse().size()));
			results.add(mapper.fillResponses(emptyResponses, surveyResponses));
		}
		
		ExcelWriter writer = new ExcelWriter(os);
		writer.write(results);
	}
	
	public void createSurveys(List<String> names, ServiceHeader header) throws IOException {
		for(String name: names) {
			service.createSurvey(String.format("%s - Peer to Peer review", name),header);
		}
	}
	
	public void deleteSurveys(ServiceHeader header)  throws IOException {
		for(SurveyLink link: service.surveys(header)) {
			if(!ServiceConstants.sampleSurveyId.equals(link.getId()))
				service.deleteSurvey(link.getId(), header);
		}
	}

	public List<SurveyLink> getAllSurveys(ServiceHeader header) throws IOException{
	    return service.surveys(header);
    }
	
}
