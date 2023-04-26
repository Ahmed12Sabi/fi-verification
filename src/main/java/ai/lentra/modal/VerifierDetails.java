
package ai.lentra.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity

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

    public Long getmApplicationId() {
        return mApplicationId;
    }

    public void setmApplicationId(Long mApplicationId) {
        this.mApplicationId = mApplicationId;
    }

    public String getmAgencyName() {
        return mAgencyName;
    }

    public void setmAgencyName(String mAgencyName) {
        this.mAgencyName = mAgencyName;
    }

    public String getmApplicantName() {
        return mApplicantName;
    }

    public void setmApplicantName(String mApplicantName) {
        this.mApplicantName = mApplicantName;
    }

    public String getmApplicationType() {
        return mApplicationType;
    }

    public void setmApplicationType(String mApplicationType) {
        this.mApplicationType = mApplicationType;
    }

    public String getmAssignedBy() {
        return mAssignedBy;
    }

    public void setmAssignedBy(String mAssignedBy) {
        this.mAssignedBy = mAssignedBy;
    }

    public String getmAssignedTo() {
        return mAssignedTo;
    }

    public void setmAssignedTo(String mAssignedTo) {
        this.mAssignedTo = mAssignedTo;
    }

    public String getmBranchName() {
        return mBranchName;
    }

    public void setmBranchName(String mBranchName) {
        this.mBranchName = mBranchName;
    }

    public String getmInspectedBy() {
        return mInspectedBy;
    }

    public void setmInspectedBy(String mInspectedBy) {
        this.mInspectedBy = mInspectedBy;
    }

    public Date getmInspectedDate() {
        return mInspectedDate;
    }

    public void setmInspectedDate(Date mInspectedDate) {
        this.mInspectedDate = mInspectedDate;
    }

    public String getmIsAgency() {
        return mIsAgency;
    }

    public void setmIsAgency(String mIsAgency) {
        this.mIsAgency = mIsAgency;
    }

    public Long getmLoanAmount() {
        return mLoanAmount;
    }

    public void setmLoanAmount(Long mLoanAmount) {
        this.mLoanAmount = mLoanAmount;
    }

    public String getmRemark() {
        return mRemark;
    }

    public void setmRemark(String mRemark) {
        this.mRemark = mRemark;
    }

    public String getmRole() {
        return mRole;
    }

    public void setmRole(String mRole) {
        this.mRole = mRole;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getmVerificationStage() {
        return mVerificationStage;
    }

    public void setmVerificationStage(String mVerificationStage) {
        this.mVerificationStage = mVerificationStage;
    }

    public String getmVerificationStatus() {
        return mVerificationStatus;
    }

    public void setmVerificationStatus(String mVerificationStatus) {
        this.mVerificationStatus = mVerificationStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
