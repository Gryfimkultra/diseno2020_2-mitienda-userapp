package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;

/**
 * controlador del userLogin
 */
public class UserLoginController {

  /**
   * Users repository
   */
  private final UserRepository userRepository;

  /**
   * User Login controller
   */
  public UserLoginController() {
    userRepository = new UserRepository();
  }

  /**
   * User Login
   *
   * @param userLoginRequest request
   * @
   */
  public User userLogin(UserLoginRequest userLoginRequest) {

    User user = userRepository.loginUser(userLoginRequest);

    LocalStorage.saveData("userId", user.getId());

    return user;
  }


}
