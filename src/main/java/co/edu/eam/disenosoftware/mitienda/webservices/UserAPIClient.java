package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;


/**
 * User api web service client
 */
public interface UserAPIClient {

  String USER_URL = "/api/users/";

  /**
   * User login - Web Services
   *
   * @param request UserLoginRequest
   */
  @POST(USER_URL + "login")
  Call<User> loginUser(@Body UserLoginRequest request);

  /**
   * User Register - Web Services
   *
   * @param request user
   */
  @POST(USER_URL + "register")
  Call<Void> registerUser(@Body User request);

  /**
   * User Orders - Web Services
   *
   * @param userId UserOrdersRequest
   * @return list Orders
   */
  @GET(USER_URL + "{userId}/orders")
  Call<List<Order>> getOrdersUser(@Path("userId") Long userId);
}
