package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;

import java.util.List;

/**
 * Controller del HistoryOrders
 */
public class HistoryOrdersController {

  /**
   * Contralador de las ordenes de un usuario
   */
  private UserRepository userRepository;

  /**
   * User Repository
   */
  public HistoryOrdersController() {
    userRepository = new UserRepository();
  }

  /**
   * get orders user
   *
   * @param userId user id
   * @return list orders user
   * @ exception
   */
  public List<Order> getOrderList(Long userId) {
    userRepository = new UserRepository();
    return userRepository.ordersUser(userId);
  }
}
