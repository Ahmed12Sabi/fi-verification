package ai.lentra.modal.allocation;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Assignor {
    public long getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(long assignedId) {
        this.assignedId = assignedId;
    }

    public String getFiId() {
        return fiId;
    }

    public void setFiId(String fiId) {
        this.fiId = fiId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
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

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignedDateTime() {
        return assignedDateTime;
    }

    public void setAssignedDateTime(String assignedDateTime) {
        this.assignedDateTime = assignedDateTime;
    }

    public String getaStatus() {
        return aStatus;
    }

    public void setaStatus(String aStatus) {
        this.aStatus = aStatus;
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

    public String getRefFiId() {
        return refFiId;
    }

    public void setRefFiId(String refFiId) {
        this.refFiId = refFiId;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long assignedId;
    private String fiId;
    private String caseId;
    private String insId;
    private String applicationId;
    private String applicantId;
    private String applicantName;
    private String assignedBy;
    private String assignedBranchName;
    private String assignedAgencyName;
    private String assignedBranchCode;
    private String assignedAgencyCode;
    private String assignedTo;
    private String assignedDateTime;
    private String aStatus; // --> cancel / suspend /onGoing
    private String vStatus; // -->accept /reject / raiseQuery
    private String address; // -->
    private String addressType;
    private String refFiId;
    private Long loanAmount;


}
