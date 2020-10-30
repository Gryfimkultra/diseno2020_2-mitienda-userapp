package co.edu.eam.disenosoftware.mitienda.model.entities;

import java.io.Serializable;

/**
 * Category class
 */
public class Category implements Serializable{

  /**
   * Category - Primary key
   */
  private Long id;

  /**
   * Category icon
   */
  private String icon;

  /**
   * Category name
   */
  private String name;

  /**
   * Store categories - Foreign key
   */
  private Store store;

  /**
   * Category's constructors
   */
  public Category() {
  }

  public Category(String icon, String name, Store store) {
    this.icon = icon;
    this.name = name;
    this.store = store;
  }

  /**
   * category's Get Id method
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * category's Set method
   *
   * @param id , id we want to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * category's Get method
   * @return icon
   */
  public String getIcon() {
    return icon;
  }

  /**
   * category's Set method
   *
   * @param icon , icon we want to set
   */
  public void setIcon(String icon) {
    this.icon = icon;
  }

  /**
   * category's Get name
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * category's Set name
   *
   * @param name , name we want to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * category's Get store
   * @return  store
   */
  public Store getStore() {
    return store;
  }

  /**
   * category's Set store
   *
   * @param store , store we want to set
   */
  public void setStore(Store store) {
    this.store = store;
  }
}
