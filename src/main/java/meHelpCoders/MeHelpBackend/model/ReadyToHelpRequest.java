package meHelpCoders.MeHelpBackend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="readyToHelpRequest")
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
}
