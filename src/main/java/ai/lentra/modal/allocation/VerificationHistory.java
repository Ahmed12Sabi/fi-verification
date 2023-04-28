package ai.lentra.modal.allocation;


import javax.persistence.*;

@Entity
@Table(name = "h_verification")
public class VerificationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String vhId;

    public String getVhId() {
        return vhId;
    }

    public void setVhId(String vhId) {
        this.vhId = vhId;
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

    public long getInsId() {
        return insId;
    }

    public void setInsId(long insId) {
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

    public String getComKey() {
        return comKey;
    }

    public void setComKey(String comKey) {
        this.comKey = comKey;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
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

    public String getVerifierStatus() {
        return verifierStatus;
    }

    public void setVerifierStatus(String verifierStatus) {
        this.verifierStatus = verifierStatus;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
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

    public String getvReplyMessage() {
        return vReplyMessage;
    }

    public void setvReplyMessage(String vReplyMessage) {
        this.vReplyMessage = vReplyMessage;
    }

    public String getvReplyMessageDate() {
        return vReplyMessageDate;
    }

    public void setvReplyMessageDate(String vReplyMessageDate) {
        this.vReplyMessageDate = vReplyMessageDate;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    private String fiId;
    private String caseId;
    private long insId;
    private String applicationId;
    private String applicantId;
    private String comKey;
    private String refId;
    private String applicantName;
    private String applicantType;
    private String assignedBy;
    private String assignedTo;
    private String assignedDateTime;
    private String acceptedDateTime;
    private String rejectedDateTime;
    private String rejectedReason;
    private String verifierStatus;
    private String verificationStage;
    private String verificationStatus;
    private String aStatus;
    private long loanAmount;
    private String applicantAddress;
    private String addressType;
    private String pincode;
    private String mobileNumber;
    private String vMode;
    private String finalFeedback ;
    private String vQueries;
    private String vQueryDate;
    private String vReplyMessage;
    private String vReplyMessageDate;
    private String updateDateTime;

    /* todo:
        cron job for queries and replies
        */

}
