package co.edu.eam.disenosoftware.mitienda.model.request;

/**
 * User login request class
 */
public class UserLoginRequest {

  /**
   * Username from user
   */
  private String username;

  /**
   * Password from user
   */
  private String password;

  /**
   * Get username
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Ser username from user
   * @param username username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get password from user
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set password from user
   * @param password password
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
