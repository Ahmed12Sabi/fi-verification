package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicantDTO {
    @NotBlank(message = "Please enter a valid application id")
    @NotNull(message = "Please enter a valid application id")
    private long applicationId;
    @NotBlank(message = "Please enter a valid application type")
    @NotNull(message = "Please enter a valid application type")
    private String applicationType;
    private String applicationName;
    private String address;
    private Long mobileNumber;
    private String assignedBy;
    private String assignedTo;
    private int loanAmount;
    private String status;
    private String userStatus;
    private String verifierProgress;
    private String inspectedById;
    private String inspectedBy;
    private Date inspectedDate;
    private String appRole;
    private String branchName;
    private boolean isAgency;
    private String agencyName;
    private String token;
    private String username;
    private String roleType;
    private String insId;
    private String productType;
    private  boolean retrigger;
    private boolean reVerification;

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getInspectedById() {
        return inspectedById;
    }

    public void setInspectedById(String inspectedById) {
        this.inspectedById = inspectedById;
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

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
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
}
