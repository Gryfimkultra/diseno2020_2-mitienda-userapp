package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.repositories.OrdersRepository;

import java.io.IOException;

/**
 * COntrolador de la pagina del detalle de una orden.
 */
public class OrderDetailController {

  /**
   * order repository
   */
  private OrdersRepository ordersRepository;

  public OrderDetailController() {
    ordersRepository = new OrdersRepository();
  }

  /**
   * get the order
   * @param id order id to get
   * @return order
   */
  public Order getOrder(Long id) throws IOException {
    ordersRepository = new OrdersRepository();

    return ordersRepository.getOrderById(id);
  }
}
