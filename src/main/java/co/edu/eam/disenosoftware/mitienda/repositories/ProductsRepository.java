package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.APIException;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.ProductAPIClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * Repository to access products data
 */
public class ProductsRepository {

    /**
     * List getProductByName
     * @param name , name
     * @return list products
     * @throws IOException , if response fail
     */
    public List<Product> getProductByName(String name) throws IOException{
        ProductAPIClient productAPIClient = RetroFitUtils.buildAPIClient(ProductAPIClient.class);
        Call<List> request = productAPIClient.getProductByName(name);
        Response <List> response = request.execute();

        if(response.isSuccessful()){
            return response.body();
        }else{
            throw APIErrorHandler.throwApiException(response);
        }
    }
}
