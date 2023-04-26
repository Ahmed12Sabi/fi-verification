package ai.lentra.modal.commitment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class CommitmentDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "applicant_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long applicantId;
	private String bankNameLoc;
	private int termInsuranceAmt;
	private int lifeInsuranceDuration;
	private int termInsuranceDuration;
	private int locAmt;
	@Column(nullable = false)
	private int carInsuranceAmt;
	private int twoWheelerInsuranceDuration;
	private int npsDuration;
	private int homeInsuranceAmt;
	private String locExpiryDate;
	@Column(nullable = false)
	private int carInsuranceDuration;
	private String insuranceType;
	private int healthInsuranceDuration;
	private int homeInsuranceDuration;
	private String npsApplicantName;
	private int healthInsuranceAmt;
	private int npsAmt;
	private int lifeInsuranceAmt;
	private int twoWheelerInsuranceAmt;
	private int customerId;

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