package meHelpCoders.MeHelpBackend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="user")
@Document(collection = "Users")
public class User {

    @Id
    private Long id;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String adress;

    @ManyToMany
    private List<CallForHelp> callForHelpList;
    
    @ManyToMany
    private List<ReadyToHelpRequest> readyToHelpRequestList;

}
