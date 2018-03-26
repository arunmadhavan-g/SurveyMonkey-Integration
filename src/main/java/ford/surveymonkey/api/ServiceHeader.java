package ford.surveymonkey.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceHeader {

    private String apiKey;
    private String sampleId;

}
