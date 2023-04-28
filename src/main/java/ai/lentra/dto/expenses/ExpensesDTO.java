package ai.lentra.dto.expenses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpensesDTO {
	private long applicantId;
	private BigDecimal officeTransportationCost;
	private BigDecimal electricBillAmt;
	private BigDecimal cableNetBillAmt;
	private BigDecimal waterBillAmt;
	private BigDecimal broadbandBillAmt;
	private BigDecimal avgFuelCost;
	private String otherExpenses;
	private BigDecimal schoolFeesAmt;
	private BigDecimal collegeFeesAmt;

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
}