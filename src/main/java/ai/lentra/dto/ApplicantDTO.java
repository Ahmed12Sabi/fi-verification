package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicantDTO {
    @NotBlank(message = "Please enter a valid application id")
    @NotNull(message = "Please enter a valid application id")
    private long applicationId;
    @NotBlank(message = "Please enter a valid application type")
    @NotNull(message = "Please enter a valid application type")
    private String applicationType;
    private String applicationName;
    private String address;
    private Long mobileNumber;
    private String assignedBy;
    private String assignedTo;
    private int loanAmount;
    private String status;
    private String userStatus;
    private String verifierProgress;
    private String inspectedById;
    private String inspectedBy;
    private Date inspectedDate;
    private String appRole;
    private String branchName;
    private boolean isAgency;
    private String agencyName;
    private String token;
    private String username;
    private String roleType;
    private String insId;
    private String productType;
    private  boolean retrigger;
    private boolean reVerification;


}
