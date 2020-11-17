package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;

import java.io.IOException;

public class UserRegistreController {

  private UserRepository userRepository;

  public void UserRegisterController() {
    userRepository = new UserRepository();
  }

  public void userRegister(User user) throws IOException {
    userRepository = new UserRepository();

    userRepository.createUser(user);
  }

}
