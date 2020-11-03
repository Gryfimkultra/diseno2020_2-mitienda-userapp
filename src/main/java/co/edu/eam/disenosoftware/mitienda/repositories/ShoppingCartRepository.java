package co.edu.eam.disenosoftware.mitienda.repositories;


import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.StoreAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import co.edu.eam.disenosoftware.mitienda.webservices.ShoppingCartAPIClient;


/**
 * Repository to access shoppingcart and shoppingcartproduct data
 */
public class ShoppingCartRepository {
  public ShoppingCart getShoppingCartByUserIdAndStoreId(Long storeId, Long userId) throws IOException {

    StoreAPIClient apiClient =  RetroFitUtils.buildAPIClient(StoreAPIClient.class);

    Call<ShoppingCart> request = apiClient.getShoppingCartByUserIdAndStoreId(storeId,userId);
    Response<ShoppingCart> response = request.execute();

    if (response.isSuccessful()) {
      return response.body();
    } else {
      throw APIErrorHandler.throwApiException(response);
    }
  }
  /**
   * delete product from shopping cart
   * @param idShoppingCart
   * @param idShoppingCartProduct
   * @throws IOException
   */
  public void deleteProductToShoppingCart(Long idShoppingCart, Long idShoppingCartProduct) throws IOException {
    ShoppingCartAPIClient apiClient = RetroFitUtils.buildAPIClient(ShoppingCartAPIClient.class);

    //Hacer el Request
    Call<Void> request = apiClient.deleteProductToShoppingCart(idShoppingCart, idShoppingCartProduct);
    Response<Void> response = request.execute();

    //Pocesar la respuesta
    if (!response.isSuccessful()) {
      throw APIErrorHandler.throwApiException(response);
    }
  }
}
