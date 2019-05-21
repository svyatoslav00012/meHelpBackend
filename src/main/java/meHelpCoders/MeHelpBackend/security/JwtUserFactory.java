package meHelpCoders.MeHelpBackend.security;

import meHelpCoders.MeHelpBackend.model.Authority;
import meHelpCoders.MeHelpBackend.model.AuthorityName;
import meHelpCoders.MeHelpBackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    @Autowired
    private static AuthorityName authorityName;

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(authorityName.ROLE_USER);

        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                list,
                true,
                new Date()
        );
    }
}
