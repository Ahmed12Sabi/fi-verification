package ai.lentra.modal;


import ai.lentra.modal.commitment.CommitmentDetails;
import ai.lentra.modal.contact_info.ContactDetails;
import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import ai.lentra.modal.expenses.Expenses;
import ai.lentra.modal.famil_info.FamilyDetails;
import ai.lentra.modal.personal_info.PersonalDetails;
import ai.lentra.modal.residence.ResidenceDetails;
import ai.lentra.modal.summary.Summary;
import ai.lentra.modal.vehicle_info.VehicleDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Table(name = "applicant_details")
public class ApplicantDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicantId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "summary", referencedColumnName = "applicant_id",nullable = true)
	private Summary summary;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "commitments", referencedColumnName = "id",nullable = true)
	private CommitmentDetails commitments;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "family_details", referencedColumnName = "applicant_id",nullable = false)
	private FamilyDetails familyDetails;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employment_details", referencedColumnName = "applicant_id",nullable = true)
	private OfficeSelfEmployment officeSelfEmployment;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_details", referencedColumnName = "applicant_id",nullable = true)
	private ContactDetails contactInformation;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personal_details", referencedColumnName = "applicant_id",nullable = true)
	private PersonalDetails personalDetails;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "residence_details", referencedColumnName = "applicant_id",nullable = true)
	private ResidenceDetails residences;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "expenses", referencedColumnName = "applicant_id",nullable = true)
	private Expenses expenses;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_details", referencedColumnName = "applicant_id",nullable = true)
	private VehicleDetails vehicleDetails;
	private String id;
	private String applicantType;
	private String applicantName;
	private String applicantCategory;
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
	private String agencyName;
	private String token;
	private String roleType;
	private String insId;
	private  boolean retrigger;
	private boolean reVerification;

}
