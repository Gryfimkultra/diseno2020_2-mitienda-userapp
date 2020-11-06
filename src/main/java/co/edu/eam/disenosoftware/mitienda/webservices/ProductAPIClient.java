package co.edu.eam.disenosoftware.mitienda.webservices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Product api web service client
 */
public interface ProductAPIClient {

    public static final String PRODUCT_URL = "/api/products/";

    @GET(PRODUCT_URL + "/by-name")
    Call<List> getProductByName(@Path("name") String name);
}
