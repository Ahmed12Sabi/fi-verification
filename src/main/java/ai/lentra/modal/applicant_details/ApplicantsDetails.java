package ai.lentra.modal.applicant_details;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Embeddable
@Table(name = "applicants_details")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicantsDetails {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicantId;
    private String id;
    private long caseId;
    @NotBlank
    private String applicantType;
    private String applicantName;
    private String applicantCategory;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private List<ApplicantsAddress> addresses= new ArrayList<>();
    private Long mobileNumber;
    private String assignedBy;
    private String assignedTo;
    private int loanAmount;
    private String status;
    private String userStatus;
    private String verifierProgress;
    private String inspectedBy;
    private Date inspectedDate;
    private String inspectedById;
    private String appRole;
    private String branchName;
    private boolean isAgency;
    private String token;
    private String roleType;
    private String insId;
    private String productType;
    private  boolean retrigger;
    private boolean reVerification;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantCategory() {
        return applicantCategory;
    }

    public void setApplicantCategory(String applicantCategory) {
        this.applicantCategory = applicantCategory;
    }

    public List<ApplicantsAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<ApplicantsAddress> addresses) {
        this.addresses = addresses;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getVerifierProgress() {
        return verifierProgress;
    }

    public void setVerifierProgress(String verifierProgress) {
        this.verifierProgress = verifierProgress;
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

    public String getInspectedById() {
        return inspectedById;
    }

    public void setInspectedById(String inspectedById) {
        this.inspectedById = inspectedById;
    }

    public String getAppRole() {
        return appRole;
    }

    public void setAppRole(String appRole) {
        this.appRole = appRole;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public boolean isAgency() {
        return isAgency;
    }

    public void setAgency(boolean agency) {
        isAgency = agency;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public boolean isRetrigger() {
        return retrigger;
    }

    public void setRetrigger(boolean retrigger) {
        this.retrigger = retrigger;
    }

    public boolean isReVerification() {
        return reVerification;
    }

    public void setReVerification(boolean reVerification) {
        this.reVerification = reVerification;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
