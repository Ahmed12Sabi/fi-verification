
package ai.lentra.modal;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class ApplicantCategory {
    private String address;
    private String agencyName;
    private String agencyTlStatus;
    private String agencyTmStatus;
    private String applicantName;
    @Id
    private Long applicationId;
    private Long applicantId;
    private String applicationType;
    private String applicantCategory;
    private String assignedBy;
    private String assignedTo;
    private String branchName;
    private String branchTlStatus;
    private String branchTmStatus;
    private Long id;
    private String inspectedBy;
    private Date inspectedDate;
    private String isAgency;
    private Long loanAmount;
    private Long mobileNumber;
    private String remarks;
    private String role;
    private String verificationStage;
    private String verificationStatus;
}
