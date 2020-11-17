package co.edu.eam.disenosoftware.mitienda.model.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Shopping Cart's class
 */
public class ShoppingCart implements Serializable {

  /**
   * Shopping Cart's - Primary key
   */
  private Long id;

  /**
   * Store of the shopping cart - Foreign key
   */
  private Store store;

  /**
   * Shopping Cart's Product
   */
  private List<ShoppingCartProduct> product;

  /**
   * User of the shopping cart - Foreign Key
   */
  private User user;

  /**
   * orders total value
   */
  private Double totalValue;

  /**
   * Shopping Cart's constructors
   */
  public ShoppingCart() {
  }

  /**
   * ShoppingCart constructor with store, user
   *
   * @param store , store
   * @param user  , user
   */
  public ShoppingCart(Store store, User user) {
    this.store = store;
    this.user = user;
    this.totalValue = totalValue;
  }

  /**
   * ShoppingCart's Get Id method
   *
   * @return Id
   */
  public Long getId() {
    return id;
  }

  /**
   * ShoppingCart's Set Id method
   *
   * @param id , id we want to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * ShoppingCart's Get Store method
   *
   * @return Store
   */
  public Store getStore() {
    return store;
  }

  /**
   * ShoppingCart's Set Store method
   *
   * @param store , store we want to set
   */
  public void setStore(Store store) {
    this.store = store;
  }

  /**
   * ShoppingCart's Get List of Shopping Cart Products method
   *
   * @return List of ShoppingCartProduct
   */
  public List<ShoppingCartProduct> getProduct() {
    return product;
  }

  /**
   * ShoppingCart's Set List of Shopping Cart Products method
   *
   * @param product , product we want to set
   */
  public void setProduct(List<ShoppingCartProduct> product) {
    this.product = product;
  }

  /**
   * ShoppingCart's Get User method
   *
   * @return User
   */
  public User getUser() {
    return user;
  }

  /**
   * ShoppingCart's Set User method
   *
   * @param user , user we want to set
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * get the shopping cart total value
   *
   * @return shopping cart total value
   */
  public Double getTotalValue() {
    return totalValue;
  }

  /**
   * Set the shopping cart total value
   *
   * @param totalValue shopping cart total value
   */
  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }

  @Override
  public String toString() {
    return "ShoppingCart{" +
            "id=" + id +
            ", store=" + store +
            ", product=" + product +
            ", user=" + user +
            ", totalValue=" + totalValue +
            '}';
  }
}
