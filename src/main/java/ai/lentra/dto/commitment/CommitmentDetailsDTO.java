package ai.lentra.dto.commitment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CommitmentDetailsDTO {
	private long applicantId;
	@Size(min=4, max=50, message=" bank_name_loc should have 4-50characters and not allow numbers")
	@Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
	private String bankNameLoc;
	@Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
	private int termInsuranceAmt;
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
	private int lifeInsuranceDuration;
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
	private int termInsuranceDuration;
	@Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
	private int locAmt;
	@Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
	private int carInsuranceAmt;
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
	private int twoWheelerInsuranceDuration;
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
	private int npsDuration;
	@Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
	private int homeInsuranceAmt;
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",message = "date must be in the format of 'DD/MM/YYYY'")
	private String locExpiryDate;
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
	private int carInsuranceDuration;
	private String insuranceType;
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
	private int healthInsuranceDuration;
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
	private int homeInsuranceDuration;
	@Size(min=6, max=50, message=" nps_applicant_name should have 6-50characters and not allow numbers ")
	@Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
	private String npsApplicantName;
	@Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
	private int healthInsuranceAmt;
	@Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits only not accepted characters")
	private int npsAmt;
	@Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
	private int lifeInsuranceAmt;
	@Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
	private int twoWheelerInsuranceAmt;
	private int customerId;

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public String getBankNameLoc() {
		return bankNameLoc;
	}

	public void setBankNameLoc(String bankNameLoc) {
		this.bankNameLoc = bankNameLoc;
	}

	public int getTermInsuranceAmt() {
		return termInsuranceAmt;
	}

	public void setTermInsuranceAmt(int termInsuranceAmt) {
		this.termInsuranceAmt = termInsuranceAmt;
	}

	public int getLifeInsuranceDuration() {
		return lifeInsuranceDuration;
	}

	public void setLifeInsuranceDuration(int lifeInsuranceDuration) {
		this.lifeInsuranceDuration = lifeInsuranceDuration;
	}

	public int getTermInsuranceDuration() {
		return termInsuranceDuration;
	}

	public void setTermInsuranceDuration(int termInsuranceDuration) {
		this.termInsuranceDuration = termInsuranceDuration;
	}

	public int getLocAmt() {
		return locAmt;
	}

	public void setLocAmt(int locAmt) {
		this.locAmt = locAmt;
	}

	public int getCarInsuranceAmt() {
		return carInsuranceAmt;
	}

	public void setCarInsuranceAmt(int carInsuranceAmt) {
		this.carInsuranceAmt = carInsuranceAmt;
	}

	public int getTwoWheelerInsuranceDuration() {
		return twoWheelerInsuranceDuration;
	}

	public void setTwoWheelerInsuranceDuration(int twoWheelerInsuranceDuration) {
		this.twoWheelerInsuranceDuration = twoWheelerInsuranceDuration;
	}

	public int getNpsDuration() {
		return npsDuration;
	}

	public void setNpsDuration(int npsDuration) {
		this.npsDuration = npsDuration;
	}

	public int getHomeInsuranceAmt() {
		return homeInsuranceAmt;
	}

	public void setHomeInsuranceAmt(int homeInsuranceAmt) {
		this.homeInsuranceAmt = homeInsuranceAmt;
	}

	public String getLocExpiryDate() {
		return locExpiryDate;
	}

	public void setLocExpiryDate(String locExpiryDate) {
		this.locExpiryDate = locExpiryDate;
	}

	public int getCarInsuranceDuration() {
		return carInsuranceDuration;
	}

	public void setCarInsuranceDuration(int carInsuranceDuration) {
		this.carInsuranceDuration = carInsuranceDuration;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public int getHealthInsuranceDuration() {
		return healthInsuranceDuration;
	}

	public void setHealthInsuranceDuration(int healthInsuranceDuration) {
		this.healthInsuranceDuration = healthInsuranceDuration;
	}

	public int getHomeInsuranceDuration() {
		return homeInsuranceDuration;
	}

	public void setHomeInsuranceDuration(int homeInsuranceDuration) {
		this.homeInsuranceDuration = homeInsuranceDuration;
	}

	public String getNpsApplicantName() {
		return npsApplicantName;
	}

	public void setNpsApplicantName(String npsApplicantName) {
		this.npsApplicantName = npsApplicantName;
	}

	public int getHealthInsuranceAmt() {
		return healthInsuranceAmt;
	}

	public void setHealthInsuranceAmt(int healthInsuranceAmt) {
		this.healthInsuranceAmt = healthInsuranceAmt;
	}

	public int getNpsAmt() {
		return npsAmt;
	}

	public void setNpsAmt(int npsAmt) {
		this.npsAmt = npsAmt;
	}

	public int getLifeInsuranceAmt() {
		return lifeInsuranceAmt;
	}

	public void setLifeInsuranceAmt(int lifeInsuranceAmt) {
		this.lifeInsuranceAmt = lifeInsuranceAmt;
	}

	public int getTwoWheelerInsuranceAmt() {
		return twoWheelerInsuranceAmt;
	}

	public void setTwoWheelerInsuranceAmt(int twoWheelerInsuranceAmt) {
		this.twoWheelerInsuranceAmt = twoWheelerInsuranceAmt;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}