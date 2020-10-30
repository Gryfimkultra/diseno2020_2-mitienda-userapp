package co.edu.eam.disenosoftware.mitienda.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Order's class
 */
public class Order implements Serializable {

  /**
   * Order's - Primary key
   */
  private Long id;

  /**
   * Order's products
   */
  private List<OrderProduct> product;

  /**
   * Store's order - Foreign key
   */
  private Store store;

  /**
   * User's order - Foreign key
   */
  private User user;

  /**
   * Order's state
   */
  private String state;

  /**
   * Order's date
   */
  private Date date;

  /**
   * orders total value
   */
  private Double totalValue;

  /**
   * Order's constructor
   */
  public Order() {
  }

  /**
   *  Method Order
   * @param store Order Store
   * @param user  Order User
   * @param state Order State
   * @param date Order Date
   */
  public Order(Store store, User user, String state, Date date) {
    this.store = store;
    this.user = user;
    this.state = state;
    this.date = date;
  }

  /**
   * Order's Get totalValue method
   * @return totalValue
   */
  public Double getTotalValue() {
    return totalValue;
  }

  /**
   * Order's set totalValue method
   * @param totalValue totalValueParam
   */
  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }

  /**
   * Order's Get Id method
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * Order's set Id method
   *
   * @param id address
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Order's Get products' list method
   *
   * @return product
   */
  public List<OrderProduct> getProduct() {

    return product;
  }

  /**
   * Order's set products' list method
   *
   * @param product list
   */
  public void setProduct(List<OrderProduct> product) {
    this.product = product;
  }

  /**
   * Order's Get store method
   *
   * @return store
   */
  public Store getStore() {
    return store;
  }

  /**
   * Order's set store
   *
   * @param store object store
   */
  public void setStore(Store store) {
    this.store = store;
  }

  /**
   * Order's Get User method
   *
   * @return user
   */
  public User getUser() {
    return user;
  }

  /**
   * Order's set User
   *
   * @param user object user
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Order's Get state method
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * Order's set state
   *
   * @param state of order
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Order's Get date method
   *
   * @return date
   */
  public Date getDate() {
    return date;
  }
}
