package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.OrderAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Repository to access orders data
 */
public class OrdersRepository {

  public Order getOrderById(long id) throws IOException {
    OrderAPIClient orderAPIClient = RetroFitUtils.buildAPIClient(OrderAPIClient.class);
    Call<Order> request = orderAPIClient.getOrderById(id);
    Response<Order> response = request.execute();

    if (response.isSuccessful()) {
      return response.body();
    }
    throw APIErrorHandler.throwApiException(response);
  }
}
