/**
 * 
 */
package py.com.sif.curso.session;


/**
 * @author bsandoval
 *
 */
public class AuthenticationInfo {
  
  private String username;
  private String password;
  private String newPassword;
  
  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }
  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
  /**
   * @return the newPassword
   */
  public String getNewPassword() {
    return newPassword;
  }
  /**
   * @param newPassword the newPassword to set
   */
  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }
}
