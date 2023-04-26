
package ai.lentra.modal;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyTlStatus() {
        return agencyTlStatus;
    }

    public void setAgencyTlStatus(String agencyTlStatus) {
        this.agencyTlStatus = agencyTlStatus;
    }

    public String getAgencyTmStatus() {
        return agencyTmStatus;
    }

    public void setAgencyTmStatus(String agencyTmStatus) {
        this.agencyTmStatus = agencyTmStatus;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getApplicantCategory() {
        return applicantCategory;
    }

    public void setApplicantCategory(String applicantCategory) {
        this.applicantCategory = applicantCategory;
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

    public String getBranchTlStatus() {
        return branchTlStatus;
    }

    public void setBranchTlStatus(String branchTlStatus) {
        this.branchTlStatus = branchTlStatus;
    }

    public String getBranchTmStatus() {
        return branchTmStatus;
    }

    public void setBranchTmStatus(String branchTmStatus) {
        this.branchTmStatus = branchTmStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInspectedBy() {
        return inspectedBy;
    }

    public void setInspectedBy(String inspectedBy) {
        this.inspectedBy = inspectedBy;
    }

    public Date getInspectedDate() {
        return inspectedDate;
    }

    public void setInspectedDate(Date inspectedDate) {
        this.inspectedDate = inspectedDate;
    }

    public String getIsAgency() {
        return isAgency;
    }

    public void setIsAgency(String isAgency) {
        this.isAgency = isAgency;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
