package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.StoreAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class StoresRepository {

  public List<Store> getOpenStores() throws IOException {
    StoreAPIClient apiClient = RetroFitUtils.buildAPIClient(StoreAPIClient.class);
    Call<List<Store>> stores =  apiClient.getOpenStores();

    Response<List<Store>> respose = stores.execute();

    if (respose.isSuccessful()) {
      return respose.body();
    }else{
      throw APIErrorHandler.throwApiException(respose);
    }
  }

  public static void main(String[] args) throws IOException {
    StoresRepository repo = new StoresRepository();

    System.out.println(repo.getOpenStores());
  }
}
