package ai.lentra.dto;
import ai.lentra.modal.ApplicantDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationDetailsDTO {
    @NotNull(message = "Please enter a valid  id")
    private Long id;
    private String insId;
    private String productType;
    private String verificationStatus;
    private String verificationStage;
    private  String createdBy;
    private Timestamp createdOn;
    private String modifiedBy;
    private Timestamp modifiedOn;
    private List<ApplicantDetails> applicantDetails = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getVerificationStage() {
        return verificationStage;
    }

    public void setVerificationStage(String verificationStage) {
        this.verificationStage = verificationStage;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Timestamp modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public List<ApplicantDetails> getApplicantDetails() {
        return applicantDetails;
    }

    public void setApplicantDetails(List<ApplicantDetails> applicantDetails) {
        this.applicantDetails = applicantDetails;
    }
}