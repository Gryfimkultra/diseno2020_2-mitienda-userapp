package co.edu.eam.disenosoftware.mitienda.model.entities;

import java.io.Serializable;

/**
 * Product's store class
 */
public class ProductStore implements Serializable {

  /**
   * Product's store - Primary key
   */
  private Long id;

  /**
   * Product of the store's - Foreign key
   */
  private Product product;

  /**
   * Product's store stock
   */
  private int stock;

  /**
   * Product's store price
   */
  private double price;

  /**
   * Category of the store product's - Foreign key
   */
  private Category category;

  /**
   * Store of the product - Foreign key
   */
  private Store store;

  /**
   * Product's store constructor
   */
  public ProductStore() {
  }

  public ProductStore(Product product, int stock, double price, Category category, Store store) {
    this.product = product;
    this.stock = stock;
    this.price = price;
    this.category = category;
    this.store = store;
  }

  public ProductStore(Long id, Product product, int stock, double price, Category category, Store store) {
    this.id = id;
    this.product = product;
    this.stock = stock;
    this.price = price;
    this.category = category;
    this.store = store;
  }

  public ProductStore(Long id) {
    this.id = id;
  }

  /**
   * ProductStore getId
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * ProductStore setId
   *
   * @param id parametro id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * ProductStore getProduct
   *
   * @return product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * ProductStore setProduct
   *
   * @param product parametro product
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * ProductStore getStock
   *
   * @return stock
   */
  public int getStock() {
    return stock;
  }

  /**
   * ProductStore setStock
   *
   * @param stock parametro
   */
  public void setStock(int stock) {
    this.stock = stock;
  }

  /**
   * ProductStore getPrice
   *
   * @return price
   */
  public double getPrice() {
    return price;
  }

  /**
   * ProductStore setPrice
   *
   * @param price parametro
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * ProductStore getCategory
   *
   * @return category
   */
  public Category getCategory() {
    return category;
  }

  /**
   * ProductStore setCategory
   *
   * @param category parametro
   */
  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   * ProductStore getStore
   *
   * @return store
   */
  public Store getStore() {
    return store;
  }

  /**
   * ProductStore setStore
   *
   * @param store parametro
   */
  public void setStore(Store store) {
    this.store = store;
  }

  @Override
  public String toString() {
    return "ProductStore{" +
        "id=" + id +
        ", product=" + product +
        ", stock=" + stock +
        ", price=" + price +
        ", category=" + category +
        ", store=" + store +
        '}';
  }
}
