package ai.lentra.modal.applicant_details;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Embeddable
@Table(name = "applicants_details")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicantsDetails {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicantId;
    private String id;
    private long caseId;
    @NotBlank
    private String applicantType;
    private String applicantName;
    private String applicantCategory;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private List<ApplicantsAddress> addresses= new ArrayList<>();
    private Long mobileNumber;
    private String assignedBy;
    private String assignedTo;
    private int loanAmount;
    private String status;
    private String userStatus;
    private String verifierProgress;
    private String inspectedBy;
    private Date inspectedDate;
    private String inspectedById;
    private String appRole;
    private String branchName;
    private boolean isAgency;
    private String token;
    private String roleType;
    private String insId;
    private String productType;
    private  boolean retrigger;
    private boolean reVerification;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;
}
