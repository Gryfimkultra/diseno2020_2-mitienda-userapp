package co.edu.eam.disenosoftware.mitienda.model.entities;

import java.io.Serializable;

/**
 * User address Entity
 */
public class UserAddress implements Serializable {

  /**
   * Primary Key
   */
  private Long id;

  /**
   * User's order - Foreign key
   */
  private User user;

  /**
   * User adress
   */
  private String address;

  /**
   * Constructor
   */
  public UserAddress() {
  }

  /**
   * Constructor with params
   */
  public UserAddress(Long id, User user, String address) {
    this.id = id;
    this.user = user;
    this.address = address;
  }

  /**
   * UserAddress's Get id method
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * UserAddress's set id
   *
   * @param id UserAddress
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * UserAddress's Get user method
   *
   * @return user
   */
  public User getUser() {
    return user;
  }

  /**
   * UserAddress's set user
   *
   * @param user object user
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * UserAddress's Get Address method
   *
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   * UserAddress's set address
   *
   * @param address String address
   */
  public void setAddress(String address) {
    this.address = address;
  }
}
