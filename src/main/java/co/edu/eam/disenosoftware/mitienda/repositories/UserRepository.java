package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.UserAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class UserRepository {

  public void registerUser(User user) throws IOException {
    UserAPIClient apiClient = RetroFitUtils.buildAPIClient(UserAPIClient.class);

    Call request = apiClient.registerUser(user);
    Response response = request.execute();

    if(!response.isSuccessful()) {
      throw APIErrorHandler.throwApiException(response);
    }
  }

  public static void main(String[] args) throws IOException {
    new UserRepository().registerUser(new User("username", "phone", "email", "password", "name"));
  }
}
