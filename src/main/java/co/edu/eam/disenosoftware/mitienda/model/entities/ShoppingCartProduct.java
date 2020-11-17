package co.edu.eam.disenosoftware.mitienda.model.entities;

import java.io.Serializable;

/**
 * Shopping Cart's Product class
 */
public class ShoppingCartProduct implements Serializable {

  /**
   * Shopping Cart's Product's - Primary key
   */
  private Long id;

  /**
   * Shopping cart of the product shopping cart's - Foreign Key
   */
  private ShoppingCart shoppingCart;

  /**
   * Shopping Cart's Product
   */
  private ProductStore product;

  /**
   * Shopping Cart's Product quantity
   */
  private int quantity;

  /**
   * Shopping Cart's Product constructor
   */
  public ShoppingCartProduct() {
  }

  public ShoppingCartProduct(ShoppingCart shoppingCart, ProductStore product, int quantity) {
    this.shoppingCart = shoppingCart;
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * ShoppingCartProduct's Get Id method
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * ShoppingCartProduct's Set Id method
   *
   * @param id , id we want to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * ShoppingCartProduct's Get Shopping Cart method
   *
   * @return Shopping Cart
   */
  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  /**
   * ShoppingCartProduct's Set Shopping Cart method
   *
   * @param shoppingCart , Shopping cart we want to set
   */
  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

  /**
   * ShoppingCartProduct's Get Product method
   *
   * @return Product
   */
  public ProductStore getProduct() {
    return product;
  }

  /**
   * ShoppingCartProduct's Set Product method
   *
   * @param product , product we want to set
   */
  public void setProduct(ProductStore product) {
    this.product = product;
  }

  /**
   * ShoppingCartProduct's Get Quantity method
   *
   * @return Quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * ShoppingCartProduct's Set Quantity method
   *
   * @param quantity , Quantity we want to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "ShoppingCartProduct{" +
            "id=" + id +
            ", shoppingCart=" + shoppingCart +
            ", product=" + product +
            ", quantity=" + quantity +
            '}';
  }
}
