package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.repositories.OrdersRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;

public class ShoppingCartController {

  /**
   * ShoppingCard Repository
   */
  private final ShoppingCartRepository shoppingCartRepository;
  private OrdersRepository ordersRepository;

  public ShoppingCartController() {
    shoppingCartRepository = new ShoppingCartRepository();
    ordersRepository=new OrdersRepository();
  }

  /**
   * get the shoppingCard
   *
   * @param userId  id to get user
   * @param storeId id to get store
   * @return order
   */
  public ShoppingCart getShoppingCard(Long storeId, Long userId) {

    ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByUserIdAndStoreId(storeId, userId);

    return shoppingCart;
  }

  public void deleteShoppingCart(Long idShoppingCart, Long idShoppingCartProduct) {

    shoppingCartRepository.deleteProductToShoppingCart(idShoppingCart, idShoppingCartProduct);

  }

  public void createOrden(Long idShoppingcart) {

    ordersRepository.createOrder(idShoppingcart);
  }
}
