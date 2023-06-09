package ai.lentra.dto.applicant;

import ai.lentra.dto.commitment.CommitmentDTO;
import ai.lentra.dto.contactinfo.ContactDetailsDTO;
import ai.lentra.dto.employmentinfo.EmploymentDetailsDTO;
import ai.lentra.dto.expenses.ExpensesDTO;
import ai.lentra.dto.familyinfo.FamilyDetailsDTO;
import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.dto.residence.ResidenceDetailsDTO;
import ai.lentra.dto.vehicleinfo.VehicleDetailsDTO;
import ai.lentra.modal.applicant_details.ApplicantsAddress;
import ai.lentra.modal.commitment.CommitmentDetails;
import ai.lentra.modal.summary.Summary;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicantDetailsDTO{
	private long applicantId;
	private long caseId;
	private Summary summary;
	private CommitmentDetails commitments;
	private CommitmentDTO commitmentDTO;
	private FamilyDetailsDTO familyDetails;
	private EmploymentDetailsDTO officeSelfEmployment;
	private ContactDetailsDTO contactInformation;
	private PersonalDetailsDTO personalDetails;
	private ResidenceDetailsDTO residences;
	private ExpensesDTO expenses;
	private VehicleDetailsDTO vehicleDetails;
	private String id;
	@NotBlank(message = "Application Type Should not be empty")
	private String applicantType;
	private String applicantName;
	private String applicantCategory;
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
	private  boolean retrigger;
	private boolean reVerification;

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public long getCaseId() {
		return caseId;
	}

	public void setCaseId(long caseId) {
		this.caseId = caseId;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public CommitmentDetails getCommitments() {
		return commitments;
	}

	public void setCommitments(CommitmentDetails commitments) {
		this.commitments = commitments;
	}

	public FamilyDetailsDTO getFamilyDetails() {
		return familyDetails;
	}

	public void setFamilyDetails(FamilyDetailsDTO familyDetails) {
		this.familyDetails = familyDetails;
	}

	public EmploymentDetailsDTO getOfficeSelfEmployment() {
		return officeSelfEmployment;
	}

	public void setOfficeSelfEmployment(EmploymentDetailsDTO officeSelfEmployment) {
		this.officeSelfEmployment = officeSelfEmployment;
	}

	public ContactDetailsDTO getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(ContactDetailsDTO contactInformation) {
		this.contactInformation = contactInformation;
	}

	public PersonalDetailsDTO getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetailsDTO personalDetails) {
		this.personalDetails = personalDetails;
	}

	public ResidenceDetailsDTO getResidences() {
		return residences;
	}

	public void setResidences(ResidenceDetailsDTO residences) {
		this.residences = residences;
	}

	public ExpensesDTO getExpenses() {
		return expenses;
	}

	public void setExpenses(ExpensesDTO expenses) {
		this.expenses = expenses;
	}

	public VehicleDetailsDTO getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(VehicleDetailsDTO vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplicantType() {
		return applicantType;
	}

	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantCategory() {
		return applicantCategory;
	}

	public void setApplicantCategory(String applicantCategory) {
		this.applicantCategory = applicantCategory;
	}

	public List<ApplicantsAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<ApplicantsAddress> addresses) {
		this.addresses = addresses;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getVerifierProgress() {
		return verifierProgress;
	}

	public void setVerifierProgress(String verifierProgress) {
		this.verifierProgress = verifierProgress;
	}

	public String getInspectedBy() {
		return inspectedBy;
	}

	public void setInspectedBy(String inspectedBy) {
		this.inspectedBy = inspectedBy;
	}

	public Date getInspectedDate() {
		return inspectedDate;
	}

	public void setInspectedDate(Date inspectedDate) {
		this.inspectedDate = inspectedDate;
	}

	public String getInspectedById() {
		return inspectedById;
	}

	public void setInspectedById(String inspectedById) {
		this.inspectedById = inspectedById;
	}

	public String getAppRole() {
		return appRole;
	}

	public void setAppRole(String appRole) {
		this.appRole = appRole;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public boolean isAgency() {
		return isAgency;
	}

	public void setAgency(boolean agency) {
		isAgency = agency;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getInsId() {
		return insId;
	}

	public void setInsId(String insId) {
		this.insId = insId;
	}

	public boolean isRetrigger() {
		return retrigger;
	}

	public void setRetrigger(boolean retrigger) {
		this.retrigger = retrigger;
	}

	public boolean isReVerification() {
		return reVerification;
	}

	public void setReVerification(boolean reVerification) {
		this.reVerification = reVerification;
	}

	public CommitmentDTO getCommitmentDTO() {
		return commitmentDTO;
	}

	public void setCommitmentDTO(CommitmentDTO commitmentDTO) {
		this.commitmentDTO = commitmentDTO;
	}

}
