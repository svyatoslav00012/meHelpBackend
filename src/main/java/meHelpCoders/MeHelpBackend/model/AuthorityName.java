package meHelpCoders.MeHelpBackend.model;

import org.springframework.security.core.GrantedAuthority;

public enum AuthorityName implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_USER";
    }
}