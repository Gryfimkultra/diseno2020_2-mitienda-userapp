package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.requests.AddProductToOrderRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Orders api web service client
 */
public interface OrderAPIClient {

  public static final String ORDERS_URL = "/api/orders/";

  @PUT(ORDERS_URL + "{id_order}/add-product")
  Call<OrderProduct> addProduct(@Path("id_order") Long orderId, @Body AddProductToOrderRequest body);

}
