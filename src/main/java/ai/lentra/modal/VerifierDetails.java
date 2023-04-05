
package ai.lentra.modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class VerifierDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mApplicationId;
    private String mAgencyName;
    private String mApplicantName;
    private String mApplicationType;
    private String mAssignedBy;
    private String mAssignedTo;
    private String mBranchName;
    private String mInspectedBy;
    private Date mInspectedDate;
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
