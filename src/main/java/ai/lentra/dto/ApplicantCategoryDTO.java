
package ai.lentra.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicantCategoryDTO {
    private String address;
    private String agencyName;
    private String agencyTlStatus;
    private String agencyTmStatus;
    private String applicantName;
    @NotBlank(message = "Please enter a valid application id")
    @NotNull(message = "Please enter a valid application Id")
    private Long applicationId;
    @NotBlank(message = "Please enter a valid application type")
    @NotNull(message = "Please enter a valid application type")
    private String applicationType;
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
