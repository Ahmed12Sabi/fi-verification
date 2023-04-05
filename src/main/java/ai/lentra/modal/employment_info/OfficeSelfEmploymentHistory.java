package ai.lentra.modal.employment_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class OfficeSelfEmploymentHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "applicant_id")
	private long applicantId;

	
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

	
	private boolean offDomainCheck;

	
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

	private Timestamp modifiedAt=Timestamp.from(Instant.now());
	private String modifiedBy;
	private String branchName;
	private String roleType;
	private String insId;
	private String productType;



}