package ai.lentra.dto;

import ai.lentra.dto.commitment.CommitmentDTO;
import ai.lentra.dto.contact_info.ContactDetailsDTO;
import ai.lentra.dto.employment_info.EmploymentDetailsDTO;
import ai.lentra.dto.expenses.ExpensesDTO;
import ai.lentra.dto.famil_info.FamilyDetailsDTO;
import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.dto.residence.ResidenceDetailsDTO;
import ai.lentra.dto.summary.SummaryDTO;
import ai.lentra.modal.vehicle_info.VehicleDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicantDetailsHistoryDTO {
    private long applicantId;
    private SummaryDTO summary;
    private CommitmentDTO commitments;
    private FamilyDetailsDTO familyDetails;
    private EmploymentDetailsDTO employmentDetails;
    private ContactDetailsDTO contactInformation;
    private PersonalDetailsDTO personalDetails;
    private ResidenceDetailsDTO residences;
    private ExpensesDTO expenses;
    private VehicleDetails vehicleDetails;

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public SummaryDTO getSummary() {
        return summary;
    }

    public void setSummary(SummaryDTO summary) {
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

    public EmploymentDetailsDTO getEmploymentDetails() {
        return employmentDetails;
    }

    public void setEmploymentDetails(EmploymentDetailsDTO employmentDetails) {
        this.employmentDetails = employmentDetails;
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

    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
}
