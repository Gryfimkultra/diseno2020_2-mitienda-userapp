package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Store api client
 */
public interface StoreAPIClient {

  public static final String STORES_URL = "/api/stores/";

  @GET(STORES_URL + "is-open")
  Call<List<Store>> getAllStoresOpen();

  /**
   * Store Categories - Web Services
   * @param storeId of a store
   * @return List of categories
   */

  @GET(STORES_URL+ "{storeId}/categories")
  Call<List<Category>> getCategoriesByStoreId(@Path("storeId") Long storeId);

}
