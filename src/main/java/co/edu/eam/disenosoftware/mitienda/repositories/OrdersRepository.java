package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.TecnicalException;
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

  /**
   * Function to get order by id
   *
   * @param id , id
   * @return , the response body
   * @ , if response fails throws the exception
   */
  public Order getOrderById(long id) {
    OrderAPIClient orderAPIClient = RetroFitUtils.buildAPIClient(OrderAPIClient.class);
    Call<Order> request = orderAPIClient.getOrderById(id);
    Response<Order> response = null;
    try {
      response = request.execute();

      if (response.isSuccessful()) {
        return response.body();
      }
      throw APIErrorHandler.throwApiException(response);
    } catch (IOException e) {
      throw new TecnicalException(e);
    }
  }


  public void createOrder(Long idShoppingcart) {
    OrderAPIClient apiClient = RetroFitUtils.buildAPIClient(OrderAPIClient.class);
    try {
      Call<Void> request = apiClient.createOrder(idShoppingcart);
      Response<Void> response = request.execute();

      if (!response.isSuccessful()) {
        throw APIErrorHandler.throwApiException(response);
      }
    } catch (IOException exc) {
      throw new TecnicalException(exc);
    }
  }

}
