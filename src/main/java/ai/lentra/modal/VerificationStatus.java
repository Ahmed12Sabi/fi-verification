package ai.lentra.modal;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Data
@Entity
public class VerificationStatus {
    @Id
    private Long applicationId;
    private String applicationType;
    private String assignedBy;
    private String assignedTo;
    private String verificationStatus;
    private String verificationStage;
    private String inspectedBy;
    private Date inspectedDate;
    private String role;
    private String branchName;
    private String isAgency;
    private String status;
    private String remarks;
    private String token;
    private String username;
    private String roleType;
    private String institutionId;
}
