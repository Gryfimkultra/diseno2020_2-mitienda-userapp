package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import okhttp3.Cache;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Product api web service client
 */
public interface ProductAPIClient {

  public static final String USER_URL = "/api/products/";

  @GET(USER_URL + "by-name")
  Call<List<Product>> getProductsByName(@Query("name_product") String name);

}
