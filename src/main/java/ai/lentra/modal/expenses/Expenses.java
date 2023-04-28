package ai.lentra.modal.expenses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Expenses{
	@Id
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "applicant_id")
	private long applicantId;
	private BigDecimal officeTransportationCost;
	private BigDecimal electricBillAmt;
	private BigDecimal cableNetBillAmt;
	private BigDecimal waterBillAmt;
	private BigDecimal broadbandBillAmt;

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public BigDecimal getOfficeTransportationCost() {
		return officeTransportationCost;
	}

	public void setOfficeTransportationCost(BigDecimal officeTransportationCost) {
		this.officeTransportationCost = officeTransportationCost;
	}

	public BigDecimal getElectricBillAmt() {
		return electricBillAmt;
	}

	public void setElectricBillAmt(BigDecimal electricBillAmt) {
		this.electricBillAmt = electricBillAmt;
	}

	public BigDecimal getCableNetBillAmt() {
		return cableNetBillAmt;
	}

	public void setCableNetBillAmt(BigDecimal cableNetBillAmt) {
		this.cableNetBillAmt = cableNetBillAmt;
	}

	public BigDecimal getWaterBillAmt() {
		return waterBillAmt;
	}

	public void setWaterBillAmt(BigDecimal waterBillAmt) {
		this.waterBillAmt = waterBillAmt;
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

	public String getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(String otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	public BigDecimal getSchoolFeesAmt() {
		return schoolFeesAmt;
	}

	public void setSchoolFeesAmt(BigDecimal schoolFeesAmt) {
		this.schoolFeesAmt = schoolFeesAmt;
	}

	public BigDecimal getCollegeFeesAmt() {
		return collegeFeesAmt;
	}

	public void setCollegeFeesAmt(BigDecimal collegeFeesAmt) {
		this.collegeFeesAmt = collegeFeesAmt;
	}

	private BigDecimal avgFuelCost;
	private String otherExpenses;
	private BigDecimal schoolFeesAmt;
	private BigDecimal collegeFeesAmt;

}