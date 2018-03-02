import java.io.File;
import java.io.FileOutputStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Lists;

import ford.surveymonkey.coordinator.Coordinator;

public class Runner {

	//@BeforeClass
	public static void proxy() {
		System.setProperty("http.proxyHost", "proxyvipfmcc.nb.ford.com");
		System.setProperty("http.proxyPort", "83");
		System.setProperty("https.proxyHost", "proxyvipfmcc.nb.ford.com");
		System.setProperty("https.proxyPort", "83");
	}

	Coordinator coordinator = new Coordinator();

	@Test
	public void collect() throws Exception {
		coordinator.collectResponses(new FileOutputStream(new File("C:\\Arun\\iOS.xls")));
	}

	private static final String names[] = {"BalakrishnanRagavan",
			"FebinV",
			"SureshNaik",
			"Vignaya",
			"ArunKumarP",
			"DGanesh",
			"RElumalai" 
	};

	@Test
	public void create() throws Exception {
		System.out.println(names.length);
		coordinator.createSurveys(Lists.newArrayList(names));
	}

	@Test
	public void delete() throws Exception {
		coordinator.deleteSurveys();
	}

}
