package meHelpCoders.MeHelpBackend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="readyToHelpRequest")
@Document(collection="ReadyToHelpRequest")
public class ReadyToHelpRequest {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="helpTopic")
    private String helpTopic;

    @Column(name="summary")
    private String summary;

    @Column(name="description")
    private String description;

    @Column(name="location")
    private String location;

    @Column(name="peopleCanBeHandled")
    private String amountOfPeopleCanBeHandled;

    @Column(name="regularity")
    private String regularity;

    @Column(name="status")
    private String status;

    @ManyToMany
    private List<User> userList;
}
