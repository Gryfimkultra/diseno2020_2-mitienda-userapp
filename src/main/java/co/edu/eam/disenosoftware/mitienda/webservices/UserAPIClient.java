package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * User api web service client
 */
public interface UserAPIClient {

  public static final String USER_URL="/api/users/";

  @POST(USER_URL + "login")
  Call<Void> loginUser(@Body UserLoginRequest request);

}