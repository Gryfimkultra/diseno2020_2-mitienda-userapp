package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.requests.AddShoppingCartProductRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.CategoryRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoresRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;

import java.io.IOException;

public class ShoppingCartAddProductControllers {

  /**
   * Product Store Repository
   */
  private ShoppingCartRepository shoppingCartRepository;

  public ShoppingCartAddProductControllers() {
    shoppingCartRepository = new ShoppingCartRepository();
  }

  public void shoppingCartAddProductControllers(Long storeId, Long productId, Long userId, int quantity) throws IOException {
    AddShoppingCartProductRequest productRequest = new AddShoppingCartProductRequest(storeId, productId, userId, quantity);
    shoppingCartRepository.addProductToShoppingCart(productRequest);
  }

}
