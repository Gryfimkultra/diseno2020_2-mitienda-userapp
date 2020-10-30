package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.webservices.StoreAPIClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

public class StoresRepository {

  public List<Store> getOpenStores() throws IOException {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://mitiendaappeam.herokuapp.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    StoreAPIClient apiClient = retrofit.create(StoreAPIClient.class);

    Call<List<Store>> stores =  apiClient.getOpenStores();

    Response<List<Store>> respose = stores.execute();
    if (respose.isSuccessful()) {
      return respose.body();
    }else{
      throw new IOException("res");
    }
  }

  public static void main(String[] args) throws IOException {
    StoresRepository repo = new StoresRepository();

    System.out.println(repo.getOpenStores());
  }
}
