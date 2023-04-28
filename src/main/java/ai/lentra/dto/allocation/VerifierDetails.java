
package ai.lentra.dto.allocation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VerifierDetails {
    private Long applicationId;
    private String fiId;
    private long applicantId;
    private String caseId;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getFiId() {
        return fiId;
    }

    public void setFiId(String fiId) {
        this.fiId = fiId;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getApplicantPincode() {
        return applicantPincode;
    }

    public void setApplicantPincode(String applicantPincode) {
        this.applicantPincode = applicantPincode;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVerificationStage() {
        return verificationStage;
    }

    public void setVerificationStage(String verificationStage) {
        this.verificationStage = verificationStage;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
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

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getComKey() {
        return comKey;
    }

    public void setComKey(String comKey) {
        this.comKey = comKey;
    }

    public String getAssignedBranchName() {
        return assignedBranchName;
    }

    public void setAssignedBranchName(String assignedBranchName) {
        this.assignedBranchName = assignedBranchName;
    }

    public String getAssignedAgencyName() {
        return assignedAgencyName;
    }

    public void setAssignedAgencyName(String assignedAgencyName) {
        this.assignedAgencyName = assignedAgencyName;
    }

    public String getAssignedBranchCode() {
        return assignedBranchCode;
    }

    public void setAssignedBranchCode(String assignedBranchCode) {
        this.assignedBranchCode = assignedBranchCode;
    }

    public String getAssignedAgencyCode() {
        return assignedAgencyCode;
    }

    public void setAssignedAgencyCode(String assignedAgencyCode) {
        this.assignedAgencyCode = assignedAgencyCode;
    }

    public String getAssignedDateTime() {
        return assignedDateTime;
    }

    public void setAssignedDateTime(String assignedDateTime) {
        this.assignedDateTime = assignedDateTime;
    }

    public String getvStatus() {
        return vStatus;
    }

    public void setvStatus(String vStatus) {
        this.vStatus = vStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    private String remarks;
    private String agencyName;
    private String applicantName;
    private String applicantType;
    private String mobileNumber;
    private String applicantPincode;
    private String assignedBy;
    private String assignedTo;
    private String branchName;
    private Long loanAmount;
    private String applicantAddress;
    private String remark;
    private String role;
    private String status;
    private String verificationStage;
    private String verificationStatus;
    private String username;
    private String roleType;
    private String institutionId;
    private String productType;
    private String comKey;
    private String assignedBranchName;
    private String assignedAgencyName;
    private String assignedBranchCode;
    private String assignedAgencyCode;
    private String assignedDateTime;
    private String vStatus; // -->accept /reject / raiseQuery
    private String address; // --> applicant address
    private String addressType;
    private String refId;
}
