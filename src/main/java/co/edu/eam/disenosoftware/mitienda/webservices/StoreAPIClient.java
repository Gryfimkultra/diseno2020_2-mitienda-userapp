package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Store api client
 */
public interface StoreAPIClient {

  public static final String STORES_URL = "/api/stores/";

  @GET(STORES_URL + "is-open")
  Call<List<Store>> getAllStoresOpen();

}
