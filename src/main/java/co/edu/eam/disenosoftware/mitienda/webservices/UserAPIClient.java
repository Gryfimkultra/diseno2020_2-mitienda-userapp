package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * User api web service client
 */
public interface UserAPIClient {

  public static final String USER_URL="/api/users/";

  /**
   * User login - Web Services
   * @param request UserLoginRequest
   */
  @POST(USER_URL + "login")
  Call<User> loginUser(@Body UserLoginRequest request);

  /**
   * User Register - Web Services
   * @param request user
   */
  @POST(USER_URL + "register")
  Call<Void> registerUser(@Body User request);
}
