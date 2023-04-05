package ai.lentra.modal;


import ai.lentra.modal.commitment.CommitmentDetailsHistory;
import ai.lentra.modal.contact_info.ContactDetailsHistory;
import ai.lentra.modal.employment_info.OfficeSelfEmploymentHistory;
import ai.lentra.modal.expenses.ExpensesHistory;
import ai.lentra.modal.famil_info.FamilyDetailsHistory;
import ai.lentra.modal.personal_info.PersonalDetailsHistory;
import ai.lentra.modal.residence.ResidenceDetailsHistory;
import ai.lentra.modal.summary.SummaryHistory;
import ai.lentra.modal.vehicle_info.VehicleDetailsHistory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicantDetailsHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long historyId;
    private long applicantId;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "summary_details_history", referencedColumnName = "id")
    private SummaryHistory summary;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "commitments_history", referencedColumnName = "id")
    private CommitmentDetailsHistory commitments;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "family_details_history", referencedColumnName = "id")
    private FamilyDetailsHistory familyDetails;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_details_history", referencedColumnName = "id")
    private OfficeSelfEmploymentHistory officeSelfEmployment;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_details_history", referencedColumnName = "id")
    private ContactDetailsHistory contactInformation;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_details_history", referencedColumnName = "id")
    private PersonalDetailsHistory personalDetails;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "residence_details_history", referencedColumnName = "id")
    private ResidenceDetailsHistory residences;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "expenses_history", referencedColumnName = "id")
    private ExpensesHistory expenses;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_details_history", referencedColumnName = "id")
    private VehicleDetailsHistory vehicleDetailsHistory;
    private String id;
    @NotBlank(message = "applicant type is required")
    private String applicantType;
    private String applicantName;
    private String applicantCategory;
    private String agencyName;
    private String address;
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
    private  boolean retrigger;
    private boolean reVerification;

}
