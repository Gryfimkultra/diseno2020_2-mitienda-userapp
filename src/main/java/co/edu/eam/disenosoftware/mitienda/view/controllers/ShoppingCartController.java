package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;

import java.io.IOException;

public class ShoppingCartController {

  /**
   * ShoppingCard Repository
   */
  private ShoppingCartRepository shoppingCartRepository;

  public ShoppingCartController(){
    shoppingCartRepository=new ShoppingCartRepository();
  }
  /**
   * get the shoppingCard
   * @param userId  id to get user
   * @param storeId  id to get store
   * @return order
   */
  public ShoppingCart getShoppingCard(Long storeId,Long userId) throws IOException {

    ShoppingCart shoppingCart=shoppingCartRepository.getShoppingCartByUserIdAndStoreId(storeId,userId);

    return  shoppingCart;
  }
  public void deleteShoppingCart(Long idShoppingCart, Long idShoppingCartProduct) throws IOException {

    shoppingCartRepository.deleteProductToShoppingCart(idShoppingCart,idShoppingCartProduct);

  }

  public void createOrder(Long idShoppingcart){


  }
}
