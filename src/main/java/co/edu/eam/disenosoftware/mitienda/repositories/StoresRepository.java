package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.APIException;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.StoreAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Repository to access stores data
 */
public class StoresRepository {

  public List<Store> getAllStoresOpen() throws IOException {
    StoreAPIClient storeAPIClient = RetroFitUtils.buildAPIClient(StoreAPIClient.class);

    Call<List<Store>> storeRequest = storeAPIClient.getAllStoresOpen();
    Response<List<Store>> storeResponse = storeRequest.execute();

    if(storeResponse.isSuccessful()) {
      return storeResponse.body();
    } else {
      throw APIErrorHandler.throwApiException(storeResponse);
    }
  }
}
