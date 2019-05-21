package meHelpCoders.MeHelpBackend.security.services;

import java.io.Serializable;

/**
 * Created by stephan on 20.03.16.
 */
public class  JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String usernameOrEmail;
    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.setUsernameOrEmail(username);
        this.setPassword(password);
    }

    public String getUsernameOrEmail() {
        return this.usernameOrEmail;
    }

    public void setUsernameOrEmail(String username) {
        this.usernameOrEmail = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
