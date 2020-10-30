package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * User api web service client
 */
public interface UserAPIClient {

  /**
   * call user register api operation
   * @param user
   * @return user created
   */
  @POST("/api/users/register")
  Call<Void> registerUser(@Body User user);


}
