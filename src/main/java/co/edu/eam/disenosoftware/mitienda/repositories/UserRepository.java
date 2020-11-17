package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.TecnicalException;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.UserAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * user data repository
 */
public class UserRepository {

  /**
   * login user
   *
   * @param userLoginRequest
   * @return
   * @
   */
  public User loginUser(UserLoginRequest userLoginRequest) {
    UserAPIClient apiClient = RetroFitUtils.buildAPIClient(UserAPIClient.class);
    Call<User> request = apiClient.loginUser(userLoginRequest);
    try {
      Response<User> response = request.execute();

      if (!response.isSuccessful()) {
        throw APIErrorHandler.throwApiException(response);
      }

      return response.body();
    } catch (IOException exc) {
      throw new TecnicalException(exc);
    }
  }

  /**
   * Create user
   *
   * @param user
   * @
   */
  public void createUser(User user) {
    UserAPIClient apiClient = RetroFitUtils.buildAPIClient(UserAPIClient.class);
    Call<Void> request = apiClient.registerUser(user);
    try {
      Response<Void> response = request.execute();

      if (!response.isSuccessful()) {
        throw APIErrorHandler.throwApiException(response);
      }
    } catch (IOException exc) {
      throw new TecnicalException(exc);
    }
  }

  public List<Order> ordersUser(Long userId) {
    UserAPIClient apiClient = RetroFitUtils.buildAPIClient(UserAPIClient.class);
    try {
      Call<List<Order>> ordersRequest = apiClient.getOrdersUser(userId);
      Response<List<Order>> ordersResponse = ordersRequest.execute();

      if (ordersResponse.isSuccessful()) {
        return ordersResponse.body();
      } else {
        throw APIErrorHandler.throwApiException(ordersResponse);
      }
    } catch (IOException exc) {
      throw new TecnicalException(exc);
    }

  }
}
