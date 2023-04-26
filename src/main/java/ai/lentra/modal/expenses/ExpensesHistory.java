package ai.lentra.modal.expenses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ExpensesHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "applicant_id")
	private long applicantId;

	
	private BigDecimal otherExp;

	
	private BigDecimal collegeFeesAmt;

	
	private BigDecimal schoolFeesAmt;

	
	private BigDecimal electricBillAmt;

	
	private BigDecimal officeTransportationCost;

	
	private BigDecimal cableNetBillAmt;

	
	private BigDecimal broadbandBillAmt;

	
	private BigDecimal avgFuelCost;

	
	private BigDecimal waterBillAmt;

	
	private BigDecimal expScore;


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

	public BigDecimal getOtherExp() {
		return otherExp;
	}

	public void setOtherExp(BigDecimal otherExp) {
		this.otherExp = otherExp;
	}

	public BigDecimal getCollegeFeesAmt() {
		return collegeFeesAmt;
	}

	public void setCollegeFeesAmt(BigDecimal collegeFeesAmt) {
		this.collegeFeesAmt = collegeFeesAmt;
	}

	public BigDecimal getSchoolFeesAmt() {
		return schoolFeesAmt;
	}

	public void setSchoolFeesAmt(BigDecimal schoolFeesAmt) {
		this.schoolFeesAmt = schoolFeesAmt;
	}

	public BigDecimal getElectricBillAmt() {
		return electricBillAmt;
	}

	public void setElectricBillAmt(BigDecimal electricBillAmt) {
		this.electricBillAmt = electricBillAmt;
	}

	public BigDecimal getOfficeTransportationCost() {
		return officeTransportationCost;
	}

	public void setOfficeTransportationCost(BigDecimal officeTransportationCost) {
		this.officeTransportationCost = officeTransportationCost;
	}

	public BigDecimal getCableNetBillAmt() {
		return cableNetBillAmt;
	}

	public void setCableNetBillAmt(BigDecimal cableNetBillAmt) {
		this.cableNetBillAmt = cableNetBillAmt;
	}

	public BigDecimal getBroadbandBillAmt() {
		return broadbandBillAmt;
	}

	public void setBroadbandBillAmt(BigDecimal broadbandBillAmt) {
		this.broadbandBillAmt = broadbandBillAmt;
	}

	public BigDecimal getAvgFuelCost() {
		return avgFuelCost;
	}

	public void setAvgFuelCost(BigDecimal avgFuelCost) {
		this.avgFuelCost = avgFuelCost;
	}

	public BigDecimal getWaterBillAmt() {
		return waterBillAmt;
	}

	public void setWaterBillAmt(BigDecimal waterBillAmt) {
		this.waterBillAmt = waterBillAmt;
	}

	public BigDecimal getExpScore() {
		return expScore;
	}

	public void setExpScore(BigDecimal expScore) {
		this.expScore = expScore;
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