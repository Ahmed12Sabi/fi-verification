package ai.lentra.dto.expenses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpensesDTO {

	private long applicantId;
	private int officeTransportationCost;
	private int electricBillAmt;
	private int cableNetBillAmt;
	private int waterBillAmt;
	private int broadbandBillAmt;
	private int avgFuelCost;
	private String otherExpenses;
	private int schoolFeesAmt;
	private int collegeFeesAmt;

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public int getOfficeTransportationCost() {
		return officeTransportationCost;
	}

	public void setOfficeTransportationCost(int officeTransportationCost) {
		this.officeTransportationCost = officeTransportationCost;
	}

	public int getElectricBillAmt() {
		return electricBillAmt;
	}

	public void setElectricBillAmt(int electricBillAmt) {
		this.electricBillAmt = electricBillAmt;
	}

	public int getCableNetBillAmt() {
		return cableNetBillAmt;
	}

	public void setCableNetBillAmt(int cableNetBillAmt) {
		this.cableNetBillAmt = cableNetBillAmt;
	}

	public int getWaterBillAmt() {
		return waterBillAmt;
	}

	public void setWaterBillAmt(int waterBillAmt) {
		this.waterBillAmt = waterBillAmt;
	}

	public int getBroadbandBillAmt() {
		return broadbandBillAmt;
	}

	public void setBroadbandBillAmt(int broadbandBillAmt) {
		this.broadbandBillAmt = broadbandBillAmt;
	}

	public int getAvgFuelCost() {
		return avgFuelCost;
	}

	public void setAvgFuelCost(int avgFuelCost) {
		this.avgFuelCost = avgFuelCost;
	}

	public String getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(String otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	public int getSchoolFeesAmt() {
		return schoolFeesAmt;
	}

	public void setSchoolFeesAmt(int schoolFeesAmt) {
		this.schoolFeesAmt = schoolFeesAmt;
	}

	public int getCollegeFeesAmt() {
		return collegeFeesAmt;
	}

	public void setCollegeFeesAmt(int collegeFeesAmt) {
		this.collegeFeesAmt = collegeFeesAmt;
	}
}