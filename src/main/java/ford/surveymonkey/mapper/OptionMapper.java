package ford.surveymonkey.mapper;

import java.util.ArrayList;
import java.util.List;

import ford.surveymonkey.mapper.response.Option;
import ford.surveymonkey.service.surveydetail.Answer;
import ford.surveymonkey.service.surveydetail.Choices;

public class OptionMapper {

	public List<Option> buildOption(Answer answers) {
		List<Option> options = new ArrayList<>();
		if(answers != null) {
			Option option;
			for(Choices choice: answers.getChoices()) {
				option = new Option();
				option.setId(choice.getId());
				option.setText(choice.getText());
				option.setValue(0);
				options.add(option);
			}
		}
		return options;
	}

}
