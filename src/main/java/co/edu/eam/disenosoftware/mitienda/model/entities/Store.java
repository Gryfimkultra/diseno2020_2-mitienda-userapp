package co.edu.eam.disenosoftware.mitienda.model.entities;

import java.io.Serializable;

/**
 * Store's class
 */
public class Store implements Serializable {

  /**
   * Store's - Primary key
   */
  private Long id;

  /**
   * Store's name
   */
  private String name;

  /**
   * Store's owner
   */
  private String owner;

  /**
   * Store's address
   */
  private String address;

  /**
   * Store's image
   */
  private String image;

  /**
   * Store's delivery
   */
  private boolean delivery;

  /**
   * Store's is open
   */
  private boolean isOpen;

  /**
   * Store's phone
   */
  private String phone;

  /**
   * Store's email
   */
  private String email;

  /**
   * Store's password
   */
  private String password;

  /**
   * Store's constructors
   */
  public Store() {
  }

  /**
   * Constructor
   * @param name
   * @param owner
   * @param address
   * @param phone
   * @param email
   * @param password
   */
  public Store(String name, String owner, String address, String phone, String email, String password) {
    this.name = name;
    this.owner = owner;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.password = password;
  }

  /**
   * Get id
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * Get Store's name
   *
   * @return Store's name
   */
  public String getName() {
    return name;
  }

  /**
   * Set Store's name
   *
   * @param name Store's name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Set Store's id
   * @param id Store's id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get Store's owner
   * @return store's owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Set store's owner
   * @param owner store's owner
   */
  public void setOwner(String owner) {
    this.owner = owner;
  }

  /**
   * Get store's address
   * @return store's address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Set store's address
   * @param address store's address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Get store's image
   * @return store's image
   */
  public String getImage() {
    return image;
  }

  /**
   * Set store's image
   * @param image store's image
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * boolean delivery
   * @return delivery
   */
  public boolean isDelivery() {
    return delivery;
  }

  /**
   * Set Store's delivery
   * @param delivery store's delivery
   */
  public void setDelivery(boolean delivery) {
    this.delivery = delivery;
  }

  /**
   * boolean open
   * @return boolean
   */
  public boolean isOpen() {
    return isOpen;
  }

  /**
   * Set store's open
   * @param open open store's
   */
  public void setOpen(boolean open) {
    isOpen = open;
  }

  /**
   * Get store's phone
   * @return store's phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set store's phone
   * @param phone store's phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Get store's password
   * @return store's password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set store's password
   * @param password store's password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get Store's email
   *
   * @return Store's email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set Store's email
   *
   * @param email Store's email
   */
  public void setEmail(String email) {
    this.email = email;
  }
}


