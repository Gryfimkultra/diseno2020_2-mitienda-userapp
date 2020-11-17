package co.edu.eam.disenosoftware.mitienda.model.requests;

/**
 * Request for shopping cart product creation
 */
public class AddShoppingCartProductRequest {

  /**
   * stores id
   */
  private Long storeId;

  /**
   * products id
   */
  private Long productId;

  /**
   * users id
   */
  private Long userId;

  /**
   * quantity
   */
  private int quantity;

  /**
   * Constructor
   *
   * @param storeId   , store id
   * @param productId , product id
   * @param userId    , user id
   * @param quantity
   */

  public AddShoppingCartProductRequest(Long storeId, Long productId, Long userId, int quantity) {
    this.storeId = storeId;
    this.productId = productId;
    this.userId = userId;
    this.quantity = quantity;
  }

  /**
   * function to get the stores id
   *
   * @return , stores id
   */
  public Long getStoreId() {
    return storeId;
  }

  /**
   * function to set the stores id
   *
   * @param storeId , the stores id
   */
  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  /**
   * function to get the product id
   *
   * @return , the product id
   */
  public Long getProductId() {
    return productId;
  }

  /**
   * function to set the products id
   *
   * @param productId , the products id
   */
  public void setProductId(Long productId) {
    this.productId = productId;
  }

  /**
   * function to get the users id
   *
   * @return , the users id
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * function to set the users id
   *
   * @param userId , the users id
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  /**
   * function to get quantity
   *
   * @return , the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * function to set the quantity
   *
   * @param quantity , the quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}