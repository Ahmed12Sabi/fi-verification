package ai.lentra.modal;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Embeddable
@Data
public class UserTl {

    @Id
    long id;
    private long assignedId;
    private String fiId;
    private String caseId;
    private long insId;
    private String applicationId;
    private String applicantId;
    private String comKey;
    private String applicantName;
    private String assignedBy;
    private String assignedBranchName;
    private String assignedAgencyName;
    private String assignedTo;
    private String assignedDateTime;
    private String status; // --> cancel / suspend /onGoing
    private String vStatus; // -->accept /reject / raiseQuery
    private String address; // -->
    private String addressType;
    private String refId;
}
