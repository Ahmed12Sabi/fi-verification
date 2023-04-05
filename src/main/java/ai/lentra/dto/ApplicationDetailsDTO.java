package ai.lentra.dto;
import ai.lentra.modal.ApplicantDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
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
}