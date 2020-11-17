package co.edu.eam.disenosoftware.mitienda.util;

import co.edu.eam.disenosoftware.mitienda.exceptions.APIException;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Response;

import java.io.IOException;

/**
 * class to parse http error response to an exception
 */
public class APIErrorHandler {

  /**
   * parse error response to an APIException
   *
   * @param errorResponse
   * @return
   */
  public static APIException throwApiException(Response errorResponse) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    ErrorResponse error = objectMapper.readValue(errorResponse.errorBody().string(), ErrorResponse.class);

    return new APIException(error.getMessage(), error.getErrorCode(), errorResponse.code());
  }
}
