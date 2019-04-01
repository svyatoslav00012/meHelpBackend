package meHelpCoders.MeHelpBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="email")
    private String email;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="adress")
    private String adress;

    @ManyToMany
    private List<CallForHelp> callForHelpList;
    
    @ManyToMany
    private List<ReadyToHelpRequest> readyToHelpRequestList;

}
