package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;


/**
 * Store api client
 */
public interface StoreAPIClient {

  String STORES_URL = "/api/stores/";

  @GET(STORES_URL + "is-open")
  Call<List<Store>> getAllStoresOpen();

  /**
   * Store Categories - Web Services
   *
   * @param storeId of a store
   * @return List of categories
   */

  @GET(STORES_URL + "{storeId}/categories")
  Call<List<Category>> getCategoriesByStoreId(@Path("storeId") Long storeId);


  String SHOPPINGCART_URL = "/api/stores/";

  @GET(SHOPPINGCART_URL + "{storeId}/users/{userId}/shopping-carts")
  Call<ShoppingCart> getShoppingCartByUserIdAndStoreId(@Path("storeId") Long storeId, @Path("userId") Long userId);
}
