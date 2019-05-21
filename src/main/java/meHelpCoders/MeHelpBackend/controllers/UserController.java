package meHelpCoders.MeHelpBackend.controllers;

import meHelpCoders.MeHelpBackend.model.User;
import meHelpCoders.MeHelpBackend.model.dto.Credentials;
import meHelpCoders.MeHelpBackend.security.JwtTokenUtil;
import meHelpCoders.MeHelpBackend.security.JwtUser;
import meHelpCoders.MeHelpBackend.security.controller.AuthenticationException;
import meHelpCoders.MeHelpBackend.security.services.JwtAuthenticationRequest;
import meHelpCoders.MeHelpBackend.security.services.JwtAuthenticationResponse;
import meHelpCoders.MeHelpBackend.services.api.UserService;
import meHelpCoders.MeHelpBackend.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value="/api/user/signup")
    public String register(@RequestBody Credentials credentials){
        System.out.println(credentials.getUsernameOrEmail());
        return "kek";
    }

    @PostMapping(value="/api/user/signin")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        authenticate(authenticationRequest.getUsernameOrEmail(), authenticationRequest.getPassword());

        // Reload password post-security so we can generate the token
        final UserDetails userDetails = userServiceImpl.loadUserByUsername(authenticationRequest.getUsernameOrEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @GetMapping("/api/user/getById/{id}")
    public User getUserById(@PathVariable(value = "id") String id) throws Exception {
        return userServiceImpl.getById(id).orElseThrow(() -> new Exception("User with id '" + id + "' not found"));
    }

    @GetMapping("/api/users/getAll")
    public List<User> getAll() {
        return userServiceImpl.getAll();
    }

    @PostMapping(value="/api/user/add")
    public User add(User user) {
        return userServiceImpl.add(user);
    }


    @PutMapping(value="/api/user/update")
    public User updateUser(@RequestBody User user) throws Exception {
        return userServiceImpl.update(user);
    }

    @DeleteMapping("/api/user/delete")
    public boolean delete(String id) {
        return userServiceImpl.delete(id);
    }

    /**
     * Authenticates the user. If something is wrong, an {@link AuthenticationException} will be thrown
     */
    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled!", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Bad credentials!", e);
        }
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
