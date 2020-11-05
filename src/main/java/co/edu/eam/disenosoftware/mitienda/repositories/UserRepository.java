package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.UserAPIClient;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * user data repository
 */
public class UserRepository {

  public void loginUser(UserLoginRequest userLoginRequest) throws IOException {

    UserAPIClient apiClient= RetroFitUtils.buildAPIClient(UserAPIClient.class);
    Call<Void>request = apiClient.loginUser(userLoginRequest);
    Response<Void>response=request.execute();

    if(!response.isSuccessful()){
      throw APIErrorHandler.throwApiException(response);
    }

  }


  public void createUser(User user) throws IOException {

    UserAPIClient apiClient = RetroFitUtils.buildAPIClient(UserAPIClient.class);
    Call<Void>request = apiClient.registerUser(user);

    Response<Void> response = request.execute();

    if (!response.isSuccessful()) {
      throw APIErrorHandler.throwApiException(response);
    }
  }
}
