package ford.surveymonkey.api;

import ford.surveymonkey.coordinator.Coordinator;
import ford.surveymonkey.service.survey.SurveyLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
public class SurveyAPIController {

    @Autowired
    private Coordinator coordinator;

    @RequestMapping("/")
    public List<SurveyLink> allSurveys(@RequestHeader String apiKey, @RequestHeader String sampleId) throws IOException{
        return coordinator.getAllSurveys(new ServiceHeader(apiKey, sampleId));
    }

    @RequestMapping(value = "/",
                 method = RequestMethod.POST,
                 consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.TEXT_PLAIN_VALUE)
    public void create(@RequestBody CreateInput names, @RequestHeader String apiKey, @RequestHeader String sampleId) throws IOException{
        coordinator.createSurveys(names.getNames(), new ServiceHeader(apiKey, sampleId));
    }

    @RequestMapping(value = "/",
                    method= RequestMethod.DELETE)
    public void deleteAll(@RequestHeader String apiKey, @RequestHeader String sampleId) throws IOException{
        coordinator.deleteSurveys(new ServiceHeader(apiKey, sampleId));
    }

    @RequestMapping(path="/collect",
                method =  RequestMethod.GET,
                produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void collectResponses(HttpServletResponse response, @RequestHeader String apiKey, @RequestHeader String sampleId) throws Exception{
        OutputStream os = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment: filename=Responses.xls");
        coordinator.collectResponses(os, new ServiceHeader(apiKey, sampleId));
    }

}
