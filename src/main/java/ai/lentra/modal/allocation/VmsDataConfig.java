package ai.lentra.modal.allocation;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class VmsDataConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vmsConfigDataId;
    //Branch and institution details
    @Column(length =150)
    private String BranchName;
    private String BranchCode;
    private String insId;
    //Application and applicant Details
    private String caseId;
    private String verificationStage;
    private String applicantId;
    private String applicationId;
    private String applicantType;
    // Commitment Details
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
    //Contact Details
    private String mobileNumber;
    private String personalEmail;
    private String simType;
    private boolean mobileNumberVerified;
    private String phoneNumber;
    private boolean phoneNumberVerified;
    private boolean personalEmailVerified;
    private boolean contDomainCheck;
    private boolean registeredWithBank;
    //Office information
    private boolean outOfGeoLimit;
    private boolean metroLocation;
    private boolean offcNegativeLocation;
    private String officeConstruction;
    private Integer officeArea;
    private String officeExterior;
    private String officeInterior;
    private String offcNoOfStorey;
    private String easeOfOfficeLocation;
    private String itemsSightedInOffice;
    private Integer noOfEmplyees;
    private String employmentType;
    private String designation;
    private String company_type;
    private String jobDomain;
    private Integer last_monthSalary;
    private String natureOfBusiness;
    private Integer avgMonthlyTurnOver;
    private boolean businessBoardSighted;
    private boolean officeEmailVerified;
    private boolean entryAllowedInOffice;
    private boolean offDomainCheck;
    private String officeName;
    private Long officeTelephoneNo;
    private Integer extensionNo;
    private String officeEmail;
    private String officeAddressLine1;
    private String officeAddressLine2;
    private String officeAddressLine3;
    private String officeAddressLine4;
    private String officeAddressPincode;
    private String officeAddressCity;
    private String office_address_state;
    private String officeAddressCountry;
    private String officeCityCode;
    private String employeeCode;
    private String businessActivitySighted;
    private String officeLocality;

    //Expenses information

    private BigDecimal officeTransportationCost;
    private BigDecimal electricBillAmt;
    private BigDecimal cableNetBillAmt;
    private BigDecimal waterBillAmt;
    private BigDecimal broadbandBillAmt;
    private BigDecimal avgFuelCost;
    private String otherExpenses;
    private BigDecimal schoolFeesAmt;
    private BigDecimal collegeFeesAmt;

    // Family details
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

    //Personal Details
    private int persRefId;
    private boolean loanTakenEarlier;
    private String citizenship;
    private String birthDate;
    private String religion;
    private String martialStatus;
    private boolean politicallyExposed;
    private String educationLevel;
    private int age;
    private String prefix;
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
    // Residence information
    private String residenceCategory;
    private String ownershipType;
    private String livingWIth;
    private String residenceType;
    private String resNoOfStorey;
    private String classification;
    private String houseCondition;
    private String propertyMakeType;
    private String propertyInterior;
    private boolean namePlateVisible;
    private String appliances;
    private BigDecimal appliancesTotalValue;
    private String commuteOptions;
    private String neighbourhoodType;
    private boolean communityDominated;
    private String residency;
    private String country;
    private Long yearsOfStay;
    private Long monthsOfStay;
    private Long distanceFromAddressToActualLoaction;
    private boolean ResNegativeLocation;
    private BigDecimal monthlyAmortization;
    private Long rentPerMonth;
    private Long landlineNum;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String city;
    private String state;
    private String pincode;
    private Long country_code;
    private Long lattitue;
    private Long longitude;
    private boolean mailDeliveryStatus;
    private String addressProofId;
    private String propertyAge;
    private String ownedBy;
    private String mortagagorName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date rentedFrom;
    private String residenceLandmark;
    private String persMet;
    private BigDecimal ResScore;
    //Summary Information
    private Integer sumRefId;
    private Integer otherFindings;
    private Integer finalScore;
    private String remark;
    private Date remarkDateTime;
    private String preparedBy;
    private Date dateAndTimePerformed;
    private String reviewedBy;
    private String agencyName;
    private Integer sumScore;
    private String finalReviewStatus;

    public long getVmsConfigDataId() {
        return vmsConfigDataId;
    }

    public void setVmsConfigDataId(long vmsConfigDataId) {
        this.vmsConfigDataId = vmsConfigDataId;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String branchCode) {
        BranchCode = branchCode;
    }

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getVerificationStage() {
        return verificationStage;
    }

    public void setVerificationStage(String verificationStage) {
        this.verificationStage = verificationStage;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public boolean isMobileNumberVerified() {
        return mobileNumberVerified;
    }

    public void setMobileNumberVerified(boolean mobileNumberVerified) {
        this.mobileNumberVerified = mobileNumberVerified;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPhoneNumberVerified() {
        return phoneNumberVerified;
    }

    public void setPhoneNumberVerified(boolean phoneNumberVerified) {
        this.phoneNumberVerified = phoneNumberVerified;
    }

    public boolean isPersonalEmailVerified() {
        return personalEmailVerified;
    }

    public void setPersonalEmailVerified(boolean personalEmailVerified) {
        this.personalEmailVerified = personalEmailVerified;
    }

    public boolean isContDomainCheck() {
        return contDomainCheck;
    }

    public void setContDomainCheck(boolean contDomainCheck) {
        this.contDomainCheck = contDomainCheck;
    }

    public boolean isRegisteredWithBank() {
        return registeredWithBank;
    }

    public void setRegisteredWithBank(boolean registeredWithBank) {
        this.registeredWithBank = registeredWithBank;
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

    public String getOfficeConstruction() {
        return officeConstruction;
    }

    public void setOfficeConstruction(String officeConstruction) {
        this.officeConstruction = officeConstruction;
    }

    public Integer getOfficeArea() {
        return officeArea;
    }

    public void setOfficeArea(Integer officeArea) {
        this.officeArea = officeArea;
    }

    public String getOfficeExterior() {
        return officeExterior;
    }

    public void setOfficeExterior(String officeExterior) {
        this.officeExterior = officeExterior;
    }

    public String getOfficeInterior() {
        return officeInterior;
    }

    public void setOfficeInterior(String officeInterior) {
        this.officeInterior = officeInterior;
    }

    public String getOffcNoOfStorey() {
        return offcNoOfStorey;
    }

    public void setOffcNoOfStorey(String offcNoOfStorey) {
        this.offcNoOfStorey = offcNoOfStorey;
    }

    public String getEaseOfOfficeLocation() {
        return easeOfOfficeLocation;
    }

    public void setEaseOfOfficeLocation(String easeOfOfficeLocation) {
        this.easeOfOfficeLocation = easeOfOfficeLocation;
    }

    public String getItemsSightedInOffice() {
        return itemsSightedInOffice;
    }

    public void setItemsSightedInOffice(String itemsSightedInOffice) {
        this.itemsSightedInOffice = itemsSightedInOffice;
    }

    public Integer getNoOfEmplyees() {
        return noOfEmplyees;
    }

    public void setNoOfEmplyees(Integer noOfEmplyees) {
        this.noOfEmplyees = noOfEmplyees;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getJobDomain() {
        return jobDomain;
    }

    public void setJobDomain(String jobDomain) {
        this.jobDomain = jobDomain;
    }

    public Integer getLast_monthSalary() {
        return last_monthSalary;
    }

    public void setLast_monthSalary(Integer last_monthSalary) {
        this.last_monthSalary = last_monthSalary;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
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

    public boolean isOffDomainCheck() {
        return offDomainCheck;
    }

    public void setOffDomainCheck(boolean offDomainCheck) {
        this.offDomainCheck = offDomainCheck;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Long getOfficeTelephoneNo() {
        return officeTelephoneNo;
    }

    public void setOfficeTelephoneNo(Long officeTelephoneNo) {
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

    public String getOfficeAddressCountry() {
        return officeAddressCountry;
    }

    public void setOfficeAddressCountry(String officeAddressCountry) {
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

    public String getOfficeLocality() {
        return officeLocality;
    }

    public void setOfficeLocality(String officeLocality) {
        this.officeLocality = officeLocality;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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

    public String getResidenceCategory() {
        return residenceCategory;
    }

    public void setResidenceCategory(String residenceCategory) {
        this.residenceCategory = residenceCategory;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getLivingWIth() {
        return livingWIth;
    }

    public void setLivingWIth(String livingWIth) {
        this.livingWIth = livingWIth;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public String getResNoOfStorey() {
        return resNoOfStorey;
    }

    public void setResNoOfStorey(String resNoOfStorey) {
        this.resNoOfStorey = resNoOfStorey;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getHouseCondition() {
        return houseCondition;
    }

    public void setHouseCondition(String houseCondition) {
        this.houseCondition = houseCondition;
    }

    public String getPropertyMakeType() {
        return propertyMakeType;
    }

    public void setPropertyMakeType(String propertyMakeType) {
        this.propertyMakeType = propertyMakeType;
    }

    public String getPropertyInterior() {
        return propertyInterior;
    }

    public void setPropertyInterior(String propertyInterior) {
        this.propertyInterior = propertyInterior;
    }

    public boolean isNamePlateVisible() {
        return namePlateVisible;
    }

    public void setNamePlateVisible(boolean namePlateVisible) {
        this.namePlateVisible = namePlateVisible;
    }

    public String getAppliances() {
        return appliances;
    }

    public void setAppliances(String appliances) {
        this.appliances = appliances;
    }

    public BigDecimal getAppliancesTotalValue() {
        return appliancesTotalValue;
    }

    public void setAppliancesTotalValue(BigDecimal appliancesTotalValue) {
        this.appliancesTotalValue = appliancesTotalValue;
    }

    public String getCommuteOptions() {
        return commuteOptions;
    }

    public void setCommuteOptions(String commuteOptions) {
        this.commuteOptions = commuteOptions;
    }

    public String getNeighbourhoodType() {
        return neighbourhoodType;
    }

    public void setNeighbourhoodType(String neighbourhoodType) {
        this.neighbourhoodType = neighbourhoodType;
    }

    public boolean isCommunityDominated() {
        return communityDominated;
    }

    public void setCommunityDominated(boolean communityDominated) {
        this.communityDominated = communityDominated;
    }

    public String getResidency() {
        return residency;
    }

    public void setResidency(String residency) {
        this.residency = residency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getYearsOfStay() {
        return yearsOfStay;
    }

    public void setYearsOfStay(Long yearsOfStay) {
        this.yearsOfStay = yearsOfStay;
    }

    public Long getMonthsOfStay() {
        return monthsOfStay;
    }

    public void setMonthsOfStay(Long monthsOfStay) {
        this.monthsOfStay = monthsOfStay;
    }

    public Long getDistanceFromAddressToActualLoaction() {
        return distanceFromAddressToActualLoaction;
    }

    public void setDistanceFromAddressToActualLoaction(Long distanceFromAddressToActualLoaction) {
        this.distanceFromAddressToActualLoaction = distanceFromAddressToActualLoaction;
    }

    public boolean isResNegativeLocation() {
        return ResNegativeLocation;
    }

    public void setResNegativeLocation(boolean resNegativeLocation) {
        ResNegativeLocation = resNegativeLocation;
    }

    public BigDecimal getMonthlyAmortization() {
        return monthlyAmortization;
    }

    public void setMonthlyAmortization(BigDecimal monthlyAmortization) {
        this.monthlyAmortization = monthlyAmortization;
    }

    public Long getRentPerMonth() {
        return rentPerMonth;
    }

    public void setRentPerMonth(Long rentPerMonth) {
        this.rentPerMonth = rentPerMonth;
    }

    public Long getLandlineNum() {
        return landlineNum;
    }

    public void setLandlineNum(Long landlineNum) {
        this.landlineNum = landlineNum;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Long getCountry_code() {
        return country_code;
    }

    public void setCountry_code(Long country_code) {
        this.country_code = country_code;
    }

    public Long getLattitue() {
        return lattitue;
    }

    public void setLattitue(Long lattitue) {
        this.lattitue = lattitue;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public boolean isMailDeliveryStatus() {
        return mailDeliveryStatus;
    }

    public void setMailDeliveryStatus(boolean mailDeliveryStatus) {
        this.mailDeliveryStatus = mailDeliveryStatus;
    }

    public String getAddressProofId() {
        return addressProofId;
    }

    public void setAddressProofId(String addressProofId) {
        this.addressProofId = addressProofId;
    }

    public String getPropertyAge() {
        return propertyAge;
    }

    public void setPropertyAge(String propertyAge) {
        this.propertyAge = propertyAge;
    }

    public String getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }

    public String getMortagagorName() {
        return mortagagorName;
    }

    public void setMortagagorName(String mortagagorName) {
        this.mortagagorName = mortagagorName;
    }

    public Date getRentedFrom() {
        return rentedFrom;
    }

    public void setRentedFrom(Date rentedFrom) {
        this.rentedFrom = rentedFrom;
    }

    public String getResidenceLandmark() {
        return residenceLandmark;
    }

    public void setResidenceLandmark(String residenceLandmark) {
        this.residenceLandmark = residenceLandmark;
    }

    public String getPersMet() {
        return persMet;
    }

    public void setPersMet(String persMet) {
        this.persMet = persMet;
    }

    public BigDecimal getResScore() {
        return ResScore;
    }

    public void setResScore(BigDecimal resScore) {
        ResScore = resScore;
    }

    public Integer getSumRefId() {
        return sumRefId;
    }

    public void setSumRefId(Integer sumRefId) {
        this.sumRefId = sumRefId;
    }

    public Integer getOtherFindings() {
        return otherFindings;
    }

    public void setOtherFindings(Integer otherFindings) {
        this.otherFindings = otherFindings;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getRemarkDateTime() {
        return remarkDateTime;
    }

    public void setRemarkDateTime(Date remarkDateTime) {
        this.remarkDateTime = remarkDateTime;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public Date getDateAndTimePerformed() {
        return dateAndTimePerformed;
    }

    public void setDateAndTimePerformed(Date dateAndTimePerformed) {
        this.dateAndTimePerformed = dateAndTimePerformed;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public Integer getSumScore() {
        return sumScore;
    }

    public void setSumScore(Integer sumScore) {
        this.sumScore = sumScore;
    }

    public String getFinalReviewStatus() {
        return finalReviewStatus;
    }

    public void setFinalReviewStatus(String finalReviewStatus) {
        this.finalReviewStatus = finalReviewStatus;
    }
}
