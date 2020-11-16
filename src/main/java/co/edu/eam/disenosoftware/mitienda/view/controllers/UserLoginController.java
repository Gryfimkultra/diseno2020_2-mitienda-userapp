package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;

import java.io.IOException;

/**
 * controlador del userLogin
 */
public class UserLoginController {

  /**
   * Users repository
   */
  private UserRepository userRepository;

  /**
   * User Login controller
   */
  public UserLoginController() {
   userRepository = new UserRepository();
  }

  /**
   * User Login
   * @param userLoginRequest request
   * @throws IOException
   */
  public void userLogin(UserLoginRequest userLoginRequest) throws IOException {
    LocalStorage.saveData("user", userLoginRequest);

    userRepository.loginUser(userLoginRequest);
  }


}
