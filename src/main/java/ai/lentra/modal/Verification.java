package ai.lentra.modal;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Embeddable
@Entity
public class Verification {

    private long assignedId;
    @Id
    private String fiId;
    private String caseId;
    private long insId;
    private String applicationId;
    private String applicantId;
    private String comKey;
    private String applicantName;
    private String assignedBy;
    private String assignedBranchName;
    private String assignedAgencyName;
    private String assignedTo;
    private String assignedDateTime;
    private String status; // --> cancel / suspend /onGoing
    private String vStatus; // -->accept /reject / raiseQuery
    private String address; // -->
    private String addressType;
    private String refId;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
