package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;

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

  public void userLogin(UserLoginRequest userLoginRequest) throws IOException {
    userRepository = new UserRepository();

    userRepository.loginUser(userLoginRequest);
  }


}
