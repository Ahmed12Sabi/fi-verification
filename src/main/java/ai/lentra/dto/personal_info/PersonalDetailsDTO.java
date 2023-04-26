package ai.lentra.dto.personal_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalDetailsDTO {

	private long applicantId;
	private int persRefId;
	private boolean loanTakenEarlier;
	@Pattern(regexp = "^[a-zA-Z]{3,20}")
	private String citizenship;
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",message = "date must be in the format of 'DD/MM/YYYY'")
	private String birthDate;
	@Pattern(regexp = "^[a-zA-Z]{2,10}",message = "religion must contain only letters and should be in  2 to 10 characters ")
	private String religion;
	@Pattern(regexp = "^[a-zA-Z]+$",message = "martial status must contain only letters")
	private String martialStatus;
	private boolean politicallyExposed;
	@Pattern(regexp = "^[a-zA-Z]+( [a-zA-Z]+)?$",message = "education level must contain only letters")
	private String educationLevel;
	private int age;
	@Pattern(regexp = "^[a-zA-Z]{3,50}$",message = "last name must contain only letters and should be in  3 to 50 characters")
	private String lastName;

	@Pattern(regexp = "^[a-zA-Z]{2,50}$",message = "last name must contain only letters and should be in  2 to 50 characters")
	private String alias;
	@Pattern(regexp = "^[a-zA-Z]{1,50}$",message = "middle name must contain only letters and should be in  1 to 50 characters")

	private String middleName;
	@Pattern(regexp = "^[a-zA-Z]{2,10}$",message = "suffix  must contain only letters and should be in  2 to 10 characters")
	private String suffix;
	@Pattern(regexp = "^[a-zA-Z]{2,50}$",message = "first name must contain only letters and should be in 2 to 50 characters")

	private String firstName;
	@DecimalMin(value = "99", message = "Income must be at least 3 digits long")
	@DecimalMax(value = "9999999999999", message = "Income cannot be more than 13 digits long")
	private BigDecimal income;
	private String civilStatus;
	@Pattern(regexp = "^[a-zA-Z]{3,20}$",message = "Income source should be in 3 to 20 characters and it should have only letters")
	private String incomeSource;
	@DecimalMin(value = "10",message = "Income Period should not be less than 2 digits")
	@DecimalMax(value = "9999999999",message = "Income Period should not be greater than 10 digits")
	private BigDecimal incomePeriod;
	private String dateTimeEndorsed;
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Invalid date format. Please use the format DD/MM/YYYY")
	private String dateInspected;

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public int getPersRefId() {
		return persRefId;
	}

	public void setPersRefId(int persRefId) {
		this.persRefId = persRefId;
	}

	public boolean isLoanTakenEarlier() {
		return loanTakenEarlier;
	}

	public void setLoanTakenEarlier(boolean loanTakenEarlier) {
		this.loanTakenEarlier = loanTakenEarlier;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public boolean isPoliticallyExposed() {
		return politicallyExposed;
	}

	public void setPoliticallyExposed(boolean politicallyExposed) {
		this.politicallyExposed = politicallyExposed;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getIncomeSource() {
		return incomeSource;
	}

	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}

	public BigDecimal getIncomePeriod() {
		return incomePeriod;
	}

	public void setIncomePeriod(BigDecimal incomePeriod) {
		this.incomePeriod = incomePeriod;
	}

	public String getDateTimeEndorsed() {
		return dateTimeEndorsed;
	}

	public void setDateTimeEndorsed(String dateTimeEndorsed) {
		this.dateTimeEndorsed = dateTimeEndorsed;
	}

	public String getDateInspected() {
		return dateInspected;
	}

	public void setDateInspected(String dateInspected) {
		this.dateInspected = dateInspected;
	}
}