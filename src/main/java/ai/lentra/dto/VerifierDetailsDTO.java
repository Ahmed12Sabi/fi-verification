
package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerifierDetailsDTO {
    private String mAgencyName;
    private String mApplicantName;
    @NotBlank(message = "Please enter a valid application id")
    @NotNull(message = "Please enter a valid application Id")
    private String mApplicationId;
    @NotBlank(message = "Please enter a valid applicant type")
    @NotNull(message = "Please enter a valid applicant type")
    private String mApplicationType;
    private String mAssignedBy;
    private String mAssignedTo;
    private String mBranchName;
    private String mInspectedBy;
    private String mInspectedDate;
    private String mIsAgency;
    private Long mLoanAmount;
    private String mRemark;
    private String mRole;
    private String mStatus;
    private String mVerificationStage;
    private String mVerificationStatus;
    private String token;
    private String username;
    private String roleType;
    private Long applicationId;
    private String applicationType;
    private String institutionId;
    private String branchName;

    private String productType;
}
