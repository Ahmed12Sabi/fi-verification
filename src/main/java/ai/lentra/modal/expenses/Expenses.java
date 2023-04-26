package ai.lentra.modal.expenses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Expenses{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "applicant_id")

	private long applicantId;

	@Column(name = "other_exp")
	private BigDecimal otherExp;

	@Column(name = "college_fees_amt")
	private BigDecimal collegeFeesAmt;

	@Column(name = "school_fees_amt")
	private BigDecimal schoolFeesAmt;

	@Column(name = "electric_bill_amt")
	private BigDecimal electricBillAmt;

	@Column(name = "office_transportation_cost")
	private BigDecimal officeTransportationCost;

	@Column(name = "cable_net_bill_amt")
	private BigDecimal cableNetBillAmt;

	@Column(name = "broadband_bill_amt")
	private BigDecimal broadbandBillAmt;

	@Column(name = "avg_fuel_cost")
	private BigDecimal avgFuelCost;

	@Column(name = "water_bill_amt")
	private BigDecimal waterBillAmt;

	@Column(name = "exp_score")
	private BigDecimal expScore;

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
}