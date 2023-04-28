package ai.lentra.dto.allocation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignResponse {
    public String getFiId() {
        return fiId;
    }

    @Override
    public String toString() {
        return "AssignResponse{" +
                "fiId='" + fiId + '\'' +
                ", refFiId='" + refFiId + '\'' +
                ", assignedBy='" + assignedBy + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", assignedDate='" + assignedDate + '\'' +
                '}';
    }

    public void setFiId(String fiId) {
        this.fiId = fiId;
    }

    public String getRefFiId() {
        return refFiId;
    }

    public void setRefFiId(String refFiId) {
        this.refFiId = refFiId;
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

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    private String fiId;
    private String refFiId;
    private String assignedBy;
    private String assignedTo;
    private String assignedDate;
}
