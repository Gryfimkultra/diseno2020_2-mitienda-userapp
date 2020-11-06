package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Orders api web service client
 */
public interface OrderAPIClient {

  /**
   * order api base url
   */
  public static final String ORDER_URL = "/api/orders/";

  /**
   * get order by id
   * @param id
   * @return order
   */
  @GET(ORDER_URL+"{id}")
  Call<Order>  getOrderById(@Path("id") long id);

}
