package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.APIException;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.requests.AddProductToOrderRequest;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.OrderAPIClient;
import co.edu.eam.disenosoftware.mitienda.webservices.UserAPIClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * Repository to access orders data
 */
public class OrdersRepository {

  public OrderProduct addProduct(Long orderId, AddProductToOrderRequest body) throws IOException {
    OrderAPIClient apiClient = RetroFitUtils.buildAPIClient(OrderAPIClient.class);

    Call<OrderProduct> request = apiClient.addProduct(orderId, body);
    Response<OrderProduct> response = request.execute();

    //procesar la respuesta
    if (response.isSuccessful()) {
      return response.body();
    } else {
      throw APIErrorHandler.throwApiException(response);
    }
  }

  public List<Order> getOrdersByUser(Long userId) throws IOException {
    //crear el cliente del API - crear quien hace el request
    Retrofit retrofit = new Retrofit.Builder().
            baseUrl("https://mitiendaappeam.herokuapp.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    UserAPIClient apiClient = retrofit.create(UserAPIClient.class);

    //hacer el request
    Call<List<Order>> request = apiClient.getOrdersByUserId(userId);
    Response<List<Order>> response = request.execute();

    //procesar la respuesta
    if (response.isSuccessful()) {
      return response.body();
    } else {

      String errorResponse = response.errorBody().string();
      int status = response.code();

      ObjectMapper objectMapper = new ObjectMapper();
      ErrorResponse error = objectMapper.readValue(errorResponse, ErrorResponse.class);

      throw new APIException(error.getMessage(), error.getErrorCode(), status);
    }
  }

  public static void main(String[] args) {
    OrdersRepository repo = new OrdersRepository();

    OrderProduct order = null;
    try {
      order = repo.addProduct(13L, new AddProductToOrderRequest(56l, 1));
    } catch (APIException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getStatus());
      System.out.println(e.getErrorCode());

      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(order);
  }

}
