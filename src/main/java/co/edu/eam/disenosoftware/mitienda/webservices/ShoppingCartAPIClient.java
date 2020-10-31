package co.edu.eam.disenosoftware.mitienda.webservices;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

/**
 * ShoppingCart and ShoppingCartProduct api web service client
 */
public interface ShoppingCartAPIClient {

  public static final String SHOPPING_CART_URL = "/api/shopping-cart";

  @DELETE(SHOPPING_CART_URL + "/{idShoppingCart}/shopping-cart-product/{idShoppingCartProduct}")
  Call<Void> deleteProductToShoppingCart(@Path("idShoppingCart") Long idShoppingCart, @Path("idShoppingCartProduct") Long idShoppingCartProduct);

}
