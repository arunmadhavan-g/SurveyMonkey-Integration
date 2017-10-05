package ford.surveymonkey.mapper.response;

import java.util.List;

import lombok.Data;

@Data
public class IndividualResponse {

	/**title
	 * id
	 * List<Responses>
	 	* 	id	
	 	 * 	Title		
		 *  List<Answer> 
		 *  	-> id : 
		 *  	->Text : All options From Details
		 *  	->Value : Count per option from Survey Aggregation
		 *  List<Comments> Text Aggregated
	 *  
	 */
	
	private String title;
	private String id;
	private List<Response> responses;
}
