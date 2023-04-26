package ai.lentra.dto.famil_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FamilyDetailsDTO {

	private long applicantId;
	private int numberOfDependents;
	private String motherMidName;
	private boolean entityConfirmationMother;
	private int motherAge;
	private String motherFirstName;
	private String motherLastName;
	private String motherReligion;
	private String fatherMidName;
	private String fatherFirstName;
	private int fatherAge;
	private String fatherReligion;
	private String fatherLastName;
	private boolean entityConfirmationFather;
	private int numberOfMinor;
	private String childEducationLevel;
	private boolean spouseWorking;
	private String spouseLastName;
	private String spouseOccupation;
	private int spouseAge;
	private boolean entityConfirmationSpouse;
	private String spouseReligion;
	private String spouseCitizenship;
	private String spouseMidName;
	private String spouseSuffix;
	private String spouseAlias;
	private String spouseBirthdate;
	private String spouseFirstName;

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public int getNumberOfDependents() {
		return numberOfDependents;
	}

	public void setNumberOfDependents(int numberOfDependents) {
		this.numberOfDependents = numberOfDependents;
	}

	public String getMotherMidName() {
		return motherMidName;
	}

	public void setMotherMidName(String motherMidName) {
		this.motherMidName = motherMidName;
	}

	public boolean isEntityConfirmationMother() {
		return entityConfirmationMother;
	}

	public void setEntityConfirmationMother(boolean entityConfirmationMother) {
		this.entityConfirmationMother = entityConfirmationMother;
	}

	public int getMotherAge() {
		return motherAge;
	}

	public void setMotherAge(int motherAge) {
		this.motherAge = motherAge;
	}

	public String getMotherFirstName() {
		return motherFirstName;
	}

	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	public String getMotherReligion() {
		return motherReligion;
	}

	public void setMotherReligion(String motherReligion) {
		this.motherReligion = motherReligion;
	}

	public String getFatherMidName() {
		return fatherMidName;
	}

	public void setFatherMidName(String fatherMidName) {
		this.fatherMidName = fatherMidName;
	}

	public String getFatherFirstName() {
		return fatherFirstName;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}

	public int getFatherAge() {
		return fatherAge;
	}

	public void setFatherAge(int fatherAge) {
		this.fatherAge = fatherAge;
	}

	public String getFatherReligion() {
		return fatherReligion;
	}

	public void setFatherReligion(String fatherReligion) {
		this.fatherReligion = fatherReligion;
	}

	public String getFatherLastName() {
		return fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public boolean isEntityConfirmationFather() {
		return entityConfirmationFather;
	}

	public void setEntityConfirmationFather(boolean entityConfirmationFather) {
		this.entityConfirmationFather = entityConfirmationFather;
	}

	public int getNumberOfMinor() {
		return numberOfMinor;
	}

	public void setNumberOfMinor(int numberOfMinor) {
		this.numberOfMinor = numberOfMinor;
	}

	public String getChildEducationLevel() {
		return childEducationLevel;
	}

	public void setChildEducationLevel(String childEducationLevel) {
		this.childEducationLevel = childEducationLevel;
	}

	public boolean isSpouseWorking() {
		return spouseWorking;
	}

	public void setSpouseWorking(boolean spouseWorking) {
		this.spouseWorking = spouseWorking;
	}

	public String getSpouseLastName() {
		return spouseLastName;
	}

	public void setSpouseLastName(String spouseLastName) {
		this.spouseLastName = spouseLastName;
	}

	public String getSpouseOccupation() {
		return spouseOccupation;
	}

	public void setSpouseOccupation(String spouseOccupation) {
		this.spouseOccupation = spouseOccupation;
	}

	public int getSpouseAge() {
		return spouseAge;
	}

	public void setSpouseAge(int spouseAge) {
		this.spouseAge = spouseAge;
	}

	public boolean isEntityConfirmationSpouse() {
		return entityConfirmationSpouse;
	}

	public void setEntityConfirmationSpouse(boolean entityConfirmationSpouse) {
		this.entityConfirmationSpouse = entityConfirmationSpouse;
	}

	public String getSpouseReligion() {
		return spouseReligion;
	}

	public void setSpouseReligion(String spouseReligion) {
		this.spouseReligion = spouseReligion;
	}

	public String getSpouseCitizenship() {
		return spouseCitizenship;
	}

	public void setSpouseCitizenship(String spouseCitizenship) {
		this.spouseCitizenship = spouseCitizenship;
	}

	public String getSpouseMidName() {
		return spouseMidName;
	}

	public void setSpouseMidName(String spouseMidName) {
		this.spouseMidName = spouseMidName;
	}

	public String getSpouseSuffix() {
		return spouseSuffix;
	}

	public void setSpouseSuffix(String spouseSuffix) {
		this.spouseSuffix = spouseSuffix;
	}

	public String getSpouseAlias() {
		return spouseAlias;
	}

	public void setSpouseAlias(String spouseAlias) {
		this.spouseAlias = spouseAlias;
	}

	public String getSpouseBirthdate() {
		return spouseBirthdate;
	}

	public void setSpouseBirthdate(String spouseBirthdate) {
		this.spouseBirthdate = spouseBirthdate;
	}

	public String getSpouseFirstName() {
		return spouseFirstName;
	}

	public void setSpouseFirstName(String spouseFirstName) {
		this.spouseFirstName = spouseFirstName;
	}
}