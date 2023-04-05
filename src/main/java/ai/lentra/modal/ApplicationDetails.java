package ai.lentra.modal;

import ai.lentra.modal.applicant_details.ApplicantsDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationDetails {
    @Id
    private Long id;
    private String insId;
    private String productType;
    private String verificationStatus;
    private String verificationStage;
    private  String createdBy;
    private Timestamp createdOn;
    private String modifiedBy;
    private Timestamp modifiedOn;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "application_details")
    private List<ApplicantDetails> applicantDetails = new ArrayList<>();
}
