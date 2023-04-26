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
import javax.validation.constraints.NotBlank;
import java.util.Date;


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

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public CommitmentDTO getCommitments() {
		return commitments;
	}

	public void setCommitments(CommitmentDTO commitments) {
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

	public VehicleDetailsDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDetailsDTO vehicle) {
		this.vehicle = vehicle;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
}
