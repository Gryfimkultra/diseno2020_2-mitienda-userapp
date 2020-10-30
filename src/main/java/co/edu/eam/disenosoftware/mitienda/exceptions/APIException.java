package co.edu.eam.disenosoftware.mitienda.exceptions;

/**
 * API Exception clas
 */
public class APIException extends RuntimeException{

  /**
   * Error code
   */
  private String errorCode;

  /**
   * http status code
   */
  private int status;

  public APIException(String message, String errorCode, int status) {
    super(message);
    this.errorCode = errorCode;
    this.status = status;
  }

  /**
   * Get the error code
   * @return error code
   */
  public String getErrorCode() {
    return errorCode;
  }

  /**
   * get http status code
   * @return status code
   */
  public int getStatus() {
    return status;
  }
}
