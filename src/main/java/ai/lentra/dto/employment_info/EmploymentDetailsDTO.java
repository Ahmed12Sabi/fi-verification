package ai.lentra.dto.employment_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmploymentDetailsDTO {
	private long applicantId;
	private String companyType;
	private String employmentType;
	private String empCode;
	private boolean domainCheck;
	private String noOfEmployees;
	private String designation;
	private String jobDomain;
	private int lastMonthSalary;
	private boolean businessBoardSighted;
	private String natureOfBusiness;
	private String businessActivitySighted;
	private int avgMonthlyTurnover;
	private String officeAddressCountry;
	private int officeArea;
	private String officeLocality;
	private boolean outOfGeoLimit;
	private String officeAddressLine2;
	private String officeAddressLine1;
	private String officeAddressLine4;
	private String officeAddressLine3;
	private String officeStateCode;
	private boolean EmpNegativeLocation;
	private int officePincode;
	private String officeAddressState;
	private boolean metroLocation;
	private String officeCity;
	private int officeTelephoneNumber;
	private String EmpNoOfStorey;
	private String easeOfOfficeLocation;
	private String officeInterior;
	private String officeConstruction;
	private String officeName;
	private boolean officeEmailVerified;
	private boolean entryAllowedInOffice;
	private int extensionNumber;
	private String officeEmail;
	private String itemsSightedInOffice;
	private String officeExterior;

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public boolean isDomainCheck() {
		return domainCheck;
	}

	public void setDomainCheck(boolean domainCheck) {
		this.domainCheck = domainCheck;
	}

	public String getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(String noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJobDomain() {
		return jobDomain;
	}

	public void setJobDomain(String jobDomain) {
		this.jobDomain = jobDomain;
	}

	public int getLastMonthSalary() {
		return lastMonthSalary;
	}

	public void setLastMonthSalary(int lastMonthSalary) {
		this.lastMonthSalary = lastMonthSalary;
	}

	public boolean isBusinessBoardSighted() {
		return businessBoardSighted;
	}

	public void setBusinessBoardSighted(boolean businessBoardSighted) {
		this.businessBoardSighted = businessBoardSighted;
	}

	public String getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public void setNatureOfBusiness(String natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}

	public String getBusinessActivitySighted() {
		return businessActivitySighted;
	}

	public void setBusinessActivitySighted(String businessActivitySighted) {
		this.businessActivitySighted = businessActivitySighted;
	}

	public int getAvgMonthlyTurnover() {
		return avgMonthlyTurnover;
	}

	public void setAvgMonthlyTurnover(int avgMonthlyTurnover) {
		this.avgMonthlyTurnover = avgMonthlyTurnover;
	}

	public String getOfficeAddressCountry() {
		return officeAddressCountry;
	}

	public void setOfficeAddressCountry(String officeAddressCountry) {
		this.officeAddressCountry = officeAddressCountry;
	}

	public int getOfficeArea() {
		return officeArea;
	}

	public void setOfficeArea(int officeArea) {
		this.officeArea = officeArea;
	}

	public String getOfficeLocality() {
		return officeLocality;
	}

	public void setOfficeLocality(String officeLocality) {
		this.officeLocality = officeLocality;
	}

	public boolean isOutOfGeoLimit() {
		return outOfGeoLimit;
	}

	public void setOutOfGeoLimit(boolean outOfGeoLimit) {
		this.outOfGeoLimit = outOfGeoLimit;
	}

	public String getOfficeAddressLine2() {
		return officeAddressLine2;
	}

	public void setOfficeAddressLine2(String officeAddressLine2) {
		this.officeAddressLine2 = officeAddressLine2;
	}

	public String getOfficeAddressLine1() {
		return officeAddressLine1;
	}

	public void setOfficeAddressLine1(String officeAddressLine1) {
		this.officeAddressLine1 = officeAddressLine1;
	}

	public String getOfficeAddressLine4() {
		return officeAddressLine4;
	}

	public void setOfficeAddressLine4(String officeAddressLine4) {
		this.officeAddressLine4 = officeAddressLine4;
	}

	public String getOfficeAddressLine3() {
		return officeAddressLine3;
	}

	public void setOfficeAddressLine3(String officeAddressLine3) {
		this.officeAddressLine3 = officeAddressLine3;
	}

	public String getOfficeStateCode() {
		return officeStateCode;
	}

	public void setOfficeStateCode(String officeStateCode) {
		this.officeStateCode = officeStateCode;
	}

	public boolean isEmpNegativeLocation() {
		return EmpNegativeLocation;
	}

	public void setEmpNegativeLocation(boolean empNegativeLocation) {
		EmpNegativeLocation = empNegativeLocation;
	}

	public int getOfficePincode() {
		return officePincode;
	}

	public void setOfficePincode(int officePincode) {
		this.officePincode = officePincode;
	}

	public String getOfficeAddressState() {
		return officeAddressState;
	}

	public void setOfficeAddressState(String officeAddressState) {
		this.officeAddressState = officeAddressState;
	}

	public boolean isMetroLocation() {
		return metroLocation;
	}

	public void setMetroLocation(boolean metroLocation) {
		this.metroLocation = metroLocation;
	}

	public String getOfficeCity() {
		return officeCity;
	}

	public void setOfficeCity(String officeCity) {
		this.officeCity = officeCity;
	}

	public int getOfficeTelephoneNumber() {
		return officeTelephoneNumber;
	}

	public void setOfficeTelephoneNumber(int officeTelephoneNumber) {
		this.officeTelephoneNumber = officeTelephoneNumber;
	}

	public String getEmpNoOfStorey() {
		return EmpNoOfStorey;
	}

	public void setEmpNoOfStorey(String empNoOfStorey) {
		EmpNoOfStorey = empNoOfStorey;
	}

	public String getEaseOfOfficeLocation() {
		return easeOfOfficeLocation;
	}

	public void setEaseOfOfficeLocation(String easeOfOfficeLocation) {
		this.easeOfOfficeLocation = easeOfOfficeLocation;
	}

	public String getOfficeInterior() {
		return officeInterior;
	}

	public void setOfficeInterior(String officeInterior) {
		this.officeInterior = officeInterior;
	}

	public String getOfficeConstruction() {
		return officeConstruction;
	}

	public void setOfficeConstruction(String officeConstruction) {
		this.officeConstruction = officeConstruction;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public boolean isOfficeEmailVerified() {
		return officeEmailVerified;
	}

	public void setOfficeEmailVerified(boolean officeEmailVerified) {
		this.officeEmailVerified = officeEmailVerified;
	}

	public boolean isEntryAllowedInOffice() {
		return entryAllowedInOffice;
	}

	public void setEntryAllowedInOffice(boolean entryAllowedInOffice) {
		this.entryAllowedInOffice = entryAllowedInOffice;
	}

	public int getExtensionNumber() {
		return extensionNumber;
	}

	public void setExtensionNumber(int extensionNumber) {
		this.extensionNumber = extensionNumber;
	}

	public String getOfficeEmail() {
		return officeEmail;
	}

	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}

	public String getItemsSightedInOffice() {
		return itemsSightedInOffice;
	}

	public void setItemsSightedInOffice(String itemsSightedInOffice) {
		this.itemsSightedInOffice = itemsSightedInOffice;
	}

	public String getOfficeExterior() {
		return officeExterior;
	}

	public void setOfficeExterior(String officeExterior) {
		this.officeExterior = officeExterior;
	}
}