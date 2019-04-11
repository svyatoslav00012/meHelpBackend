package meHelpCoders.MeHelpBackend.model.dto;

import lombok.Data;

@Data
public class Credentials {
    private String usernameOrEmail;
    private String password;
}
