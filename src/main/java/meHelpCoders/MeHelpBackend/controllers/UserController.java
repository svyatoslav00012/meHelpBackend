package meHelpCoders.MeHelpBackend.controllers;

import meHelpCoders.MeHelpBackend.model.User;
import meHelpCoders.MeHelpBackend.services.api.UserService;
import meHelpCoders.MeHelpBackend.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/user/getById/{id}")
    public User getUserById(@PathVariable(value = "id") String id) throws Exception {
        return userService.getById(id).orElseThrow(() -> new Exception("User with id '" + id + "' not found"));
    }

    @GetMapping("/api/users/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/api/user/add")
    public User add(User user) {
        return userService.add(user);
    }


    @PutMapping("/api/user/update")
    public User updateUser(@RequestBody User user) throws Exception {
        return userService.update(user);
    }

    @DeleteMapping("/api/user/delete")
    public boolean delete(String id) {
        return userService.delete(id);
    }
}
