package co.edu.eam.disenosoftware.mitienda.model.entities;

import java.io.Serializable;

/**
 * User's class
 */
public class User implements Serializable {

  /**
   * User's - Primary key
   */
  private Long id;

  /**
   * User's username
   */
  private String username;

  /**
   * User's phone
   */
  private String phone;

  /**
   * User's email
   */
  private String email;

  /**
   * User's password
   */
  private String password;

  /**
   * User's name
   */
  private String name;

  /**
   * User's constructor
   */
  public User() {
  }

  /**
   * User's constructor
   *
   * @param username, username
   * @param phone,    phone
   * @param email,    email
   * @param password, password
   * @param name,     name
   */
  public User(String username, String phone, String email, String password, String name) {
    this.username = username;
    this.phone = phone;
    this.email = email;
    this.password = password;
    this.name = name;
  }

  /**
   * Users constructor
   *
   * @param username
   * @param phone
   * @param email
   * @param password
   */
  public User(String username, String phone, String email, String password) {
    this.username = username;
    this.phone = phone;
    this.email = email;
    this.password = password;
  }

  /**
   * get id
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * set id
   *
   * @param id primary key
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * get Username
   *
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * set Username
   *
   * @param username username to setUsername
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get phone
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set phone
   *
   * @param phone phone to setPhone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Get email
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set email
   *
   * @param email email to setEmail
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get password
   *
   * @return pasword
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set password
   *
   * @param password password to setPassword
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get name
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Set name
   *
   * @param name name to setName
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}
