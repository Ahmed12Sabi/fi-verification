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

import javax.persistence.*;
import java.util.Date;

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

	public CommitmentDetails getCommitments() {
		return commitments;
	}

	public void setCommitments(CommitmentDetails commitments) {
		this.commitments = commitments;
	}

	public FamilyDetails getFamilyDetails() {
		return familyDetails;
	}

	public void setFamilyDetails(FamilyDetails familyDetails) {
		this.familyDetails = familyDetails;
	}

	public OfficeSelfEmployment getOfficeSelfEmployment() {
		return officeSelfEmployment;
	}

	public void setOfficeSelfEmployment(OfficeSelfEmployment officeSelfEmployment) {
		this.officeSelfEmployment = officeSelfEmployment;
	}

	public ContactDetails getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(ContactDetails contactInformation) {
		this.contactInformation = contactInformation;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public ResidenceDetails getResidences() {
		return residences;
	}

	public void setResidences(ResidenceDetails residences) {
		this.residences = residences;
	}

	public Expenses getExpenses() {
		return expenses;
	}

	public void setExpenses(Expenses expenses) {
		this.expenses = expenses;
	}

	public VehicleDetails getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(VehicleDetails vehicleDetails) {
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

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
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
