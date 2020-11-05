package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.APIException;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.ShoppingCartAPIClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * Repository to access shoppingcart and shoppingcartproduct data
 */
public class ShoppingCartRepository {

  /**
   * delete product from shopping cart
   * @param idShoppingCart
   * @param idShoppingCartProduct
   * @throws IOException
   */
  public void deleteProductToShoppingCart(Long idShoppingCart, Long idShoppingCartProduct) throws IOException {
    ShoppingCartAPIClient apiClient = RetroFitUtils.buildAPIClient(ShoppingCartAPIClient.class);

    //Hacer el Request
    Call<Void> request = apiClient.deleteProductToShoppingCart(idShoppingCart, idShoppingCartProduct);
    Response<Void> response = request.execute();

    //Pocesar la respuesta
    if (!response.isSuccessful()) {
      throw APIErrorHandler.throwApiException(response);
    }
  }
}
