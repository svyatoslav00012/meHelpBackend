package meHelpCoders.MeHelpBackend.dao;

import meHelpCoders.MeHelpBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, String> {
}
