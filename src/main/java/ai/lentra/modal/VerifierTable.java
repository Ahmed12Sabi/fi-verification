package ai.lentra.modal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class VerifierTable {
    @Id
    private String fiId;
    private String comKey;
    private String refId;
    //applicant information
    private String caseId;
    private long insId;
    private String applicantId;
    private String applicationId;
    private String applicantType;
    private String addressType;
    private String vStatus;
    private String vMode;
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
}