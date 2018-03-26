package ford.surveymonkey.api;

import lombok.Data;

import java.util.List;

@Data
public class CreateInput {

    private List<String> names;
}
