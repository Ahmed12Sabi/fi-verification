package ai.lentra.modal.residence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

@Data
@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ResidenceDetailsHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "applicant_id")
	private long applicantId;
	

	private Long residenceCategory;

	

	private Long ownershipType;

	

	private String livingWIth;

	
	private Long residenceType;

	
	private Long resNoOfStorey;

	
	private Long classification;

	
	private Long houseCondition;

	
	private Long propertyMAkeType;

	
	private Long propertyInterior;

	
	private boolean namePlateVisible;

	
	private Long appliances;

	
	private BigDecimal appliancesTotalValue;

	
	private Long commuteOptions;

	
	private Long neighbourhoodType;

	
	private boolean communityDominated;

	
	private Long residency;

	
	private Long country;

	
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

	
	private Long addressProofId;

	
	private Long propertyAge;

	
	private String ownedBy;

	
	private String mortagagorName;

	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	private Date rentedFrom;

	
	private String residenceLandmark;

	
	private String persMet;

	
	private BigDecimal ResScore;


	private Timestamp modifiedAt=Timestamp.from(Instant.now());
	private String modifiedBy;
	private String branchName;
	private String roleType;
	private String insId;
	private String productType;



}