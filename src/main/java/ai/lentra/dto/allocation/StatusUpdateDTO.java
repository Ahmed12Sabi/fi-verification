package ai.lentra.dto.allocation;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusUpdateDTO {
    private String fiId;
    private String applicantId;
    private String vQuery;

    public String getFiId() {
        return fiId;
    }

    public void setFiId(String fiId) {
        this.fiId = fiId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getvQuery() {
        return vQuery;
    }

    public void setvQuery(String vQuery) {
        this.vQuery = vQuery;
    }

    public String getvReply() {
        return vReply;
    }

    public void setvReply(String vReply) {
        this.vReply = vReply;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getRejectedReason() {
        return rejectedReason;
    }

    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason;
    }

    public String getDeclinedReason() {
        return declinedReason;
    }

    public void setDeclinedReason(String declinedReason) {
        this.declinedReason = declinedReason;
    }

    public String getvMode() {
        return vMode;
    }

    public void setvMode(String vMode) {
        this.vMode = vMode;
    }

    private String vReply;
    private String remarks;
    private String applicantName;
    private String rejectedReason;
    private String declinedReason;
    private String vMode;
}

