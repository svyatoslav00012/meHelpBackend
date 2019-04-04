package meHelpCoders.MeHelpBackend.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="callForHelp")
@Document(collection="CallForHelp")
public class CallForHelp {

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

    @Column(name="amountOfPeopleRequired")
    private String amountOfPeopleRequired;

    @Column(name="regularity")
    private String regularity;

    @Column(name="isRewarded")
    private boolean isRewarded;

    @Column(name="status")
    private String status;

    @ManyToMany
    private List<User> userList;
}
