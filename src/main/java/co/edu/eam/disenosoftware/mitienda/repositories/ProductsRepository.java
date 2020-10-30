package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.ProductAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Repository to access products data
 */
public class ProductsRepository {

  public List<Product> getProductsByName(String name) throws IOException {
    ProductAPIClient apiClient = RetroFitUtils.buildAPIClient(ProductAPIClient.class);

    Call<List<Product>> productsRequest = apiClient.getProductsByName(name);
    Response<List<Product>> response = productsRequest.execute();

    if (response.isSuccessful()) {
      return response.body();
    } else {
      throw APIErrorHandler.throwApiException(response);
    }
  }

  public static void main(String[] args) throws IOException {
    ProductsRepository repo = new ProductsRepository();

    List<Product> ps = repo.getProductsByName("leche");
    System.out.println(ps);
  }

}
