package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.TecnicalException;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.ProductStoreAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Repository to access productstores data
 */
public class ProductStoresRepository {

  /**
   * get store products
   *
   * @param storeId
   * @return
   * @
   */
  public List<ProductStore> getAllProductStoreByStoreId(Long storeId) {
    ProductStoreAPIClient apiClient = RetroFitUtils.buildAPIClient(ProductStoreAPIClient.class);

    Call<List<ProductStore>> request = apiClient.getAllProductStoreByStoreId(storeId);
    try {
      Response<List<ProductStore>> response = request.execute();
      if (response.isSuccessful()) {
        return response.body();
      } else {
        throw APIErrorHandler.throwApiException(response);
      }
    } catch (IOException exc) {
      throw new TecnicalException(exc);
    }
  }
}
