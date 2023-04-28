package ai.lentra.dto.responses;


public class AllocationResponse {
    private String FiId;
    private String allocatedTo;

    public String getFiId() {
        return FiId;
    }

    public void setFiId(String fiId) {
        FiId = fiId;
    }

    public String getAllocatedTo() {
        return allocatedTo;
    }

    public void setAllocatedTo(String allocatedTo) {
        this.allocatedTo = allocatedTo;
    }
}
