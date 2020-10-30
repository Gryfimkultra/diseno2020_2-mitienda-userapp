package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * User api web service client
 */
public interface UserAPIClient {

  public static final String USER_URL = "/api/users/";

  @GET(USER_URL +"{user_id}/orders")
  Call<List<Order>> getOrdersByUserId(@Path("user_id") Long userId);

}
