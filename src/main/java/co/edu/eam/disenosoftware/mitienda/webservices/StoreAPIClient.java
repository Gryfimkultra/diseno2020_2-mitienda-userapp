package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface StoreAPIClient {

  @GET("/api/stores/is-open")
  Call<List<Store>> getOpenStores();

}
