package ai.lentra.modal.allocation;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Verification {
    @Id
    private String fiId;
    private String caseId;
    private String insId;
    private String applicationId;

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

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public String getComKey() {
        return comKey;
    }

    public void setComKey(String comKey) {
        this.comKey = comKey;
    }

    public String getRefFiId() {
        return refFiId;
    }

    public void setRefFiId(String refFiId) {
        this.refFiId = refFiId;
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

    public String getAssignedDateTime() {
        return assignedDateTime;
    }

    public void setAssignedDateTime(String assignedDateTime) {
        this.assignedDateTime = assignedDateTime;
    }

    public String getAcceptedDateTime() {
        return acceptedDateTime;
    }

    public void setAcceptedDateTime(String acceptedDateTime) {
        this.acceptedDateTime = acceptedDateTime;
    }

    public String getRejectedDateTime() {
        return rejectedDateTime;
    }

    public void setRejectedDateTime(String rejectedDateTime) {
        this.rejectedDateTime = rejectedDateTime;
    }

    public String getRejectedReason() {
        return rejectedReason;
    }

    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason;
    }

    public String getvStatus() {
        return vStatus;
    }

    public void setvStatus(String vStatus) {
        this.vStatus = vStatus;
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

    public String getaStatus() {
        return aStatus;
    }

    public void setaStatus(String aStatus) {
        this.aStatus = aStatus;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getApplicantPincode() {
        return applicantPincode;
    }

    public void setApplicantPincode(String applicantPincode) {
        this.applicantPincode = applicantPincode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getvMode() {
        return vMode;
    }

    public void setvMode(String vMode) {
        this.vMode = vMode;
    }

    public String getFinalFeedback() {
        return finalFeedback;
    }

    public void setFinalFeedback(String finalFeedback) {
        this.finalFeedback = finalFeedback;
    }

    public String getvQueries() {
        return vQueries;
    }

    public void setvQueries(String vQueries) {
        this.vQueries = vQueries;
    }

    public String getvQueryDate() {
        return vQueryDate;
    }

    public void setvQueryDate(String vQueryDate) {
        this.vQueryDate = vQueryDate;
    }

    public String getaReplyMessage() {
        return aReplyMessage;
    }

    public void setaReplyMessage(String aReplyMessage) {
        this.aReplyMessage = aReplyMessage;
    }

    public String getaReplyMessageDate() {
        return aReplyMessageDate;
    }

    public void setaReplyMessageDate(String aReplyMessageDate) {
        this.aReplyMessageDate = aReplyMessageDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getDeclinedReason() {
        return declinedReason;
    }

    public void setDeclinedReason(String declinedReason) {
        this.declinedReason = declinedReason;
    }

    public String getDeclinedDate() {
        return declinedDate;
    }

    public void setDeclinedDate(String declinedDate) {
        this.declinedDate = declinedDate;
    }

    private Long applicantId;
    private String comKey;
    private String refFiId;
    private String applicantName;
    private String applicantType;
    private String assignedBy;
    private String assignedTo;
    private String assignedDateTime;
    private String acceptedDateTime;
    private String rejectedDateTime;
    private String rejectedReason;
    private String vStatus;
    private String verificationStage;
    private String verificationStatus;
    private String aStatus;
    private String agencyName;
    private String agencyCode;
    private long loanAmount;
    private String applicantAddress;
    private String addressType;
    private String applicantPincode;
    private String mobileNumber;
    private String vMode;
    private String finalFeedback ;
    private String vQueries;
    private String vQueryDate;
    private String aReplyMessage;
    private String aReplyMessageDate;
    private String remarks;
    private String approvedDate;
    private String declinedReason;
    private String declinedDate;
    /* todo:
        cron job for queries and replies */

}
