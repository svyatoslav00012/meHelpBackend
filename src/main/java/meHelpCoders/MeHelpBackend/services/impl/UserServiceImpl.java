package meHelpCoders.MeHelpBackend.services.impl;

import meHelpCoders.MeHelpBackend.dao.UserDAO;
import meHelpCoders.MeHelpBackend.model.User;
import meHelpCoders.MeHelpBackend.security.JwtUserFactory;
import meHelpCoders.MeHelpBackend.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public Optional<User> getById(String id) {
        return userDAO.findById(id);
    }

    public List<User> getAll() {
        return userDAO.findAll();
    }

    public User add(User user) {
        return userDAO.save(user);
    }

    public User update(User user) throws Exception{
        return userDAO.findById(user.getId()+"").map(foundUser -> userDAO.save(user))
        .orElseThrow(
                () -> new Exception("Couldn't update. User with id '" + user.getId() + "' not found")
        );
    }

    public boolean delete(String id) {
        Optional<User> userOptional = getById(id);
        if (userOptional.isPresent()) {
            userDAO.delete(userOptional.get());
            return true;
        } else
            return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }

}
