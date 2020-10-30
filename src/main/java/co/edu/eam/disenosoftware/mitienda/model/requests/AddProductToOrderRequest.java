package co.edu.eam.disenosoftware.mitienda.model.requests;

/**
 * Add product to order request class
 */
public class AddProductToOrderRequest {

  /**
   * Primary key - Product
   */
  private Long id;

  /**
   * Quantity from Order product
   */
  private Integer quantity;

  public AddProductToOrderRequest() {
  }

  /**
   * Constructor
   * @param id
   * @param quantity
   */
  public AddProductToOrderRequest(Long id, Integer quantity) {
    this.id = id;
    this.quantity = quantity;
  }

  /**
   * Get Id
   * @return primary key
   */
  public Long getId() {
    return id;
  }

  /**
   * Set Id
   * @param id primary key
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get quantity of the order product
   * @return quantity
   */
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * Set quantity of the order product
   * @param quantity quantity
   */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
