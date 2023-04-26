package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeSelfEmploymentDto {
        private Long applicantId;

        private boolean outOfGeoLimit;

        private boolean metroLocation;


        private boolean offcNegativeLocation;

        private Integer office_construction;
        private Integer officeArea;
                private Integer officeExterior;
                private Integer officeInterior;
                private Integer offcNoOfStorey;
                private Integer easeOfOfficeLocation;

                private Integer itemsSightedInOffice;
                private Integer noOfEmplyees;

                private Integer employmentType;
                private Integer designation;

                private Integer company_type;

                private Integer jobDomain;

                private Integer last_monthSalary;

                private Integer natureOfBusiness;

                private Integer avgMonthlyTurnOver;

                private boolean businessBoardSighted;

                private boolean officeEmailVerified;

                private boolean entryAllowedInOffice;

                private boolean domainCheck;

                private String officeName;

                private Integer officeTelephoneNo;
                private Integer extensionNo;

                private String officeEmail;
                private String officeAddressLine1;

                private String officeAddressLine2;

                private String officeAddressLine3;

                private String officeAddressLine4;

                private String officeAddressPincode;

                private String officeAddressCity;

                private String office_address_state;

                private Integer officeAddressCountry;

                private String officeCityCode;

                private String employeeCode;

                private String businessActivitySighted;
                private Integer officeLocality;

        public Long getApplicantId() {
                return applicantId;
        }

        public void setApplicantId(Long applicantId) {
                this.applicantId = applicantId;
        }

        public boolean isOutOfGeoLimit() {
                return outOfGeoLimit;
        }

        public void setOutOfGeoLimit(boolean outOfGeoLimit) {
                this.outOfGeoLimit = outOfGeoLimit;
        }

        public boolean isMetroLocation() {
                return metroLocation;
        }

        public void setMetroLocation(boolean metroLocation) {
                this.metroLocation = metroLocation;
        }

        public boolean isOffcNegativeLocation() {
                return offcNegativeLocation;
        }

        public void setOffcNegativeLocation(boolean offcNegativeLocation) {
                this.offcNegativeLocation = offcNegativeLocation;
        }

        public Integer getOffice_construction() {
                return office_construction;
        }

        public void setOffice_construction(Integer office_construction) {
                this.office_construction = office_construction;
        }

        public Integer getOfficeArea() {
                return officeArea;
        }

        public void setOfficeArea(Integer officeArea) {
                this.officeArea = officeArea;
        }

        public Integer getOfficeExterior() {
                return officeExterior;
        }

        public void setOfficeExterior(Integer officeExterior) {
                this.officeExterior = officeExterior;
        }

        public Integer getOfficeInterior() {
                return officeInterior;
        }

        public void setOfficeInterior(Integer officeInterior) {
                this.officeInterior = officeInterior;
        }

        public Integer getOffcNoOfStorey() {
                return offcNoOfStorey;
        }

        public void setOffcNoOfStorey(Integer offcNoOfStorey) {
                this.offcNoOfStorey = offcNoOfStorey;
        }

        public Integer getEaseOfOfficeLocation() {
                return easeOfOfficeLocation;
        }

        public void setEaseOfOfficeLocation(Integer easeOfOfficeLocation) {
                this.easeOfOfficeLocation = easeOfOfficeLocation;
        }

        public Integer getItemsSightedInOffice() {
                return itemsSightedInOffice;
        }

        public void setItemsSightedInOffice(Integer itemsSightedInOffice) {
                this.itemsSightedInOffice = itemsSightedInOffice;
        }

        public Integer getNoOfEmplyees() {
                return noOfEmplyees;
        }

        public void setNoOfEmplyees(Integer noOfEmplyees) {
                this.noOfEmplyees = noOfEmplyees;
        }

        public Integer getEmploymentType() {
                return employmentType;
        }

        public void setEmploymentType(Integer employmentType) {
                this.employmentType = employmentType;
        }

        public Integer getDesignation() {
                return designation;
        }

        public void setDesignation(Integer designation) {
                this.designation = designation;
        }

        public Integer getCompany_type() {
                return company_type;
        }

        public void setCompany_type(Integer company_type) {
                this.company_type = company_type;
        }

        public Integer getJobDomain() {
                return jobDomain;
        }

        public void setJobDomain(Integer jobDomain) {
                this.jobDomain = jobDomain;
        }

        public Integer getLast_monthSalary() {
                return last_monthSalary;
        }

        public void setLast_monthSalary(Integer last_monthSalary) {
                this.last_monthSalary = last_monthSalary;
        }

        public Integer getNatureOfBusiness() {
                return natureOfBusiness;
        }

        public void setNatureOfBusiness(Integer natureOfBusiness) {
                this.natureOfBusiness = natureOfBusiness;
        }

        public Integer getAvgMonthlyTurnOver() {
                return avgMonthlyTurnOver;
        }

        public void setAvgMonthlyTurnOver(Integer avgMonthlyTurnOver) {
                this.avgMonthlyTurnOver = avgMonthlyTurnOver;
        }

        public boolean isBusinessBoardSighted() {
                return businessBoardSighted;
        }

        public void setBusinessBoardSighted(boolean businessBoardSighted) {
                this.businessBoardSighted = businessBoardSighted;
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

        public boolean isDomainCheck() {
                return domainCheck;
        }

        public void setDomainCheck(boolean domainCheck) {
                this.domainCheck = domainCheck;
        }

        public String getOfficeName() {
                return officeName;
        }

        public void setOfficeName(String officeName) {
                this.officeName = officeName;
        }

        public Integer getOfficeTelephoneNo() {
                return officeTelephoneNo;
        }

        public void setOfficeTelephoneNo(Integer officeTelephoneNo) {
                this.officeTelephoneNo = officeTelephoneNo;
        }

        public Integer getExtensionNo() {
                return extensionNo;
        }

        public void setExtensionNo(Integer extensionNo) {
                this.extensionNo = extensionNo;
        }

        public String getOfficeEmail() {
                return officeEmail;
        }

        public void setOfficeEmail(String officeEmail) {
                this.officeEmail = officeEmail;
        }

        public String getOfficeAddressLine1() {
                return officeAddressLine1;
        }

        public void setOfficeAddressLine1(String officeAddressLine1) {
                this.officeAddressLine1 = officeAddressLine1;
        }

        public String getOfficeAddressLine2() {
                return officeAddressLine2;
        }

        public void setOfficeAddressLine2(String officeAddressLine2) {
                this.officeAddressLine2 = officeAddressLine2;
        }

        public String getOfficeAddressLine3() {
                return officeAddressLine3;
        }

        public void setOfficeAddressLine3(String officeAddressLine3) {
                this.officeAddressLine3 = officeAddressLine3;
        }

        public String getOfficeAddressLine4() {
                return officeAddressLine4;
        }

        public void setOfficeAddressLine4(String officeAddressLine4) {
                this.officeAddressLine4 = officeAddressLine4;
        }

        public String getOfficeAddressPincode() {
                return officeAddressPincode;
        }

        public void setOfficeAddressPincode(String officeAddressPincode) {
                this.officeAddressPincode = officeAddressPincode;
        }

        public String getOfficeAddressCity() {
                return officeAddressCity;
        }

        public void setOfficeAddressCity(String officeAddressCity) {
                this.officeAddressCity = officeAddressCity;
        }

        public String getOffice_address_state() {
                return office_address_state;
        }

        public void setOffice_address_state(String office_address_state) {
                this.office_address_state = office_address_state;
        }

        public Integer getOfficeAddressCountry() {
                return officeAddressCountry;
        }

        public void setOfficeAddressCountry(Integer officeAddressCountry) {
                this.officeAddressCountry = officeAddressCountry;
        }

        public String getOfficeCityCode() {
                return officeCityCode;
        }

        public void setOfficeCityCode(String officeCityCode) {
                this.officeCityCode = officeCityCode;
        }

        public String getEmployeeCode() {
                return employeeCode;
        }

        public void setEmployeeCode(String employeeCode) {
                this.employeeCode = employeeCode;
        }

        public String getBusinessActivitySighted() {
                return businessActivitySighted;
        }

        public void setBusinessActivitySighted(String businessActivitySighted) {
                this.businessActivitySighted = businessActivitySighted;
        }

        public Integer getOfficeLocality() {
                return officeLocality;
        }

        public void setOfficeLocality(Integer officeLocality) {
                this.officeLocality = officeLocality;
        }
}
