import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Lists;

import ford.surveymonkey.coordinator.Coordinator;

public class Runner {

	@BeforeClass
	public static void proxy() {
		 System.setProperty("http.proxyHost", "proxyvipfmcc.nb.ford.com");
	        System.setProperty("http.proxyPort", "83");
	        System.setProperty("https.proxyHost", "proxyvipfmcc.nb.ford.com");
	        System.setProperty("https.proxyPort", "83");
	}
	
	Coordinator coordinator = new Coordinator();

	@Test
	public void collect() throws Exception {
		coordinator.collectResponses();
	}
	
	@Test
	public void create() throws Exception {
		coordinator.createSurveys(Lists.newArrayList("1","2","3"));
	}
	
	@Test
	public void delete() throws Exception {
		coordinator.deleteSurveys();
	}
	
	
}
