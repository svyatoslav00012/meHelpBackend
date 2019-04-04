package meHelpCoders.MeHelpBackend.services.api;

import meHelpCoders.MeHelpBackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> getById(String id);

    List<User> getAll();

    User add(User user);

    User update(User user) throws Exception;

    boolean delete(String id);

}
