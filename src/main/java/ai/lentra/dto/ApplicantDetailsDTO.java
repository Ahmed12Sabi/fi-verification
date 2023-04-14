package ai.lentra.dto;

import ai.lentra.dto.commitment.CommitmentDTO;
import ai.lentra.dto.contact_info.ContactDetailsDTO;
import ai.lentra.dto.employment_info.EmploymentDetailsDTO;
import ai.lentra.dto.expenses.ExpensesDTO;
import ai.lentra.dto.famil_info.FamilyDetailsDTO;
import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.dto.residence.ResidenceDetailsDTO;
import ai.lentra.dto.vehicle_info.VehicleDetailsDTO;
import ai.lentra.modal.summary.Summary;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicantDetailsDTO{
	private long applicantId;
	private Summary summary;
	private CommitmentDTO commitments;
	private FamilyDetailsDTO familyDetails;
	private EmploymentDetailsDTO officeSelfEmployment;
	private ContactDetailsDTO contactInformation;
	private PersonalDetailsDTO personalDetails;
	private ResidenceDetailsDTO residences;
	private ExpensesDTO expenses;
	private VehicleDetailsDTO vehicle;
	private String id;
	@NotBlank
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
	private String token;
	private String roleType;
	private String insId;
	private  boolean retrigger;
	private boolean reVerification;
}
