package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.requests.AddShoppingCartProductRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;

public class ShoppingCartAddProductControllers {

  /**
   * Product Store Repository
   */
  private final ShoppingCartRepository shoppingCartRepository;

  public ShoppingCartAddProductControllers() {
    shoppingCartRepository = new ShoppingCartRepository();
  }

  public void shoppingCartAddProductControllers(Long storeId, Long productId, Long userId, int quantity) {
    AddShoppingCartProductRequest productRequest = new AddShoppingCartProductRequest(storeId, productId, userId, quantity);
    shoppingCartRepository.addProductToShoppingCart(productRequest);
  }

}
