package ai.lentra.dto.allocation;

import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BranchAgencyAllocationDTO {
    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public List<Object> getBranches() {
        return branches;
    }

    public void setBranches(List<Object> branches) {
        this.branches = branches;
    }

    public List<Object> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Object> agencies) {
        this.agencies = agencies;
    }

    private long applicationId;
    private long applicantId;
    private String addressType;
    private String address;
    private String productType;
    private List<Object> branches= new ArrayList<>();
    private List<Object> agencies= new ArrayList<>();
}
