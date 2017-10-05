package ford.surveymonkey.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AuthTokenService {

	@GET("oauth/authorize")
	Call<String> authToken(@Query("response-type") String responseType, @Query("client_id")String clientId, @Query("redirect_uri")String redirectURI);
}
