package co.edu.eam.disenosoftware.mitienda.model.responses;

/**
 * Error response class
 */
public class ErrorResponse {

  /**
   * Error message
   */
  private String message;

  /**
   * Error code
   */
  private String errorCode;

  public ErrorResponse() {
  }

  /**
   * Constructor
   * @param message error message
   * @param errorCode error code
   */
  public ErrorResponse(String message, String errorCode) {
    this.message = message;
    this.errorCode = errorCode;
  }

  /**
   * GEt the error message
   * @return error message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Get the error code
   * @return error code
   */
  public String getErrorCode() {
    return errorCode;
  }
}
