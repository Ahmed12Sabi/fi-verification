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
import javax.persistence.*;
import java.util.Date;

@Entity
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
    //    @NotBlank(message = "applicant type is required")
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

    public long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(long historyId) {
        this.historyId = historyId;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public SummaryHistory getSummary() {
        return summary;
    }

    public void setSummary(SummaryHistory summary) {
        this.summary = summary;
    }

    public CommitmentDetailsHistory getCommitments() {
        return commitments;
    }

    public void setCommitments(CommitmentDetailsHistory commitments) {
        this.commitments = commitments;
    }

    public FamilyDetailsHistory getFamilyDetails() {
        return familyDetails;
    }

    public void setFamilyDetails(FamilyDetailsHistory familyDetails) {
        this.familyDetails = familyDetails;
    }

    public OfficeSelfEmploymentHistory getOfficeSelfEmployment() {
        return officeSelfEmployment;
    }

    public void setOfficeSelfEmployment(OfficeSelfEmploymentHistory officeSelfEmployment) {
        this.officeSelfEmployment = officeSelfEmployment;
    }

    public ContactDetailsHistory getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactDetailsHistory contactInformation) {
        this.contactInformation = contactInformation;
    }

    public PersonalDetailsHistory getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetailsHistory personalDetails) {
        this.personalDetails = personalDetails;
    }

    public ResidenceDetailsHistory getResidences() {
        return residences;
    }

    public void setResidences(ResidenceDetailsHistory residences) {
        this.residences = residences;
    }

    public ExpensesHistory getExpenses() {
        return expenses;
    }

    public void setExpenses(ExpensesHistory expenses) {
        this.expenses = expenses;
    }

    public VehicleDetailsHistory getVehicleDetailsHistory() {
        return vehicleDetailsHistory;
    }

    public void setVehicleDetailsHistory(VehicleDetailsHistory vehicleDetailsHistory) {
        this.vehicleDetailsHistory = vehicleDetailsHistory;
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

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
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
