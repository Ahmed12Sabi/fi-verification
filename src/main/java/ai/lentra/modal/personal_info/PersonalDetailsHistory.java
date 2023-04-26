package ai.lentra.modal.personal_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
//@Entity
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class PersonalDetailsHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "applicant_id")
	private long applicantId;
	private int persRefId;
	private boolean loanTakenEarlier;
	private String citizenship;
	private String birthDate;
	private String religion;
	private String martialStatus;
	private boolean politicallyExposed;
	private String educationLevel;
	private int age;
	private String lastName;
	private String alias;
	private String middleName;
	private String suffix;
	private String firstName;
	private BigDecimal income;
	private String civilStatus;
	private String incomeSource;
	private BigDecimal incomePeriod;
	private String dateTimeEndorsed;
	private String dateInspected;

	private Timestamp modifiedAt=Timestamp.from(Instant.now());
	private String modifiedBy;
	private String branchName;
	private String roleType;
	private String insId;
	private String productType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
}