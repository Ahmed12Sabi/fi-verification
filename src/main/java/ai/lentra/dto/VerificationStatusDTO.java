package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationStatusDTO {
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

}
