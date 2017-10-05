package ford.surveymonkey.mapper.response;

import lombok.Data;

@Data
public class Option {
	 private String id; 
	 private String text;
	 private int value;
	
	 public void incrementValue() {
		 value++;
	}

}
