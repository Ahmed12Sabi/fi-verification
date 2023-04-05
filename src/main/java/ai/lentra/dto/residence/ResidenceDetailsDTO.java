package ai.lentra.dto.residence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResidenceDetailsDTO {
	private long applicantId;
		private Long id;
		private BigDecimal residenceCategory;
		private BigDecimal ownershipType;

		private BigDecimal propertyAge;

		private String livingWIth;

		private BigDecimal residenceType;

		private BigDecimal ResNoOfStorey;

		private BigDecimal classification;

		private BigDecimal houseCondition;

		private BigDecimal propertyMAkeType;

		private BigDecimal propertyInterior;

		private boolean namePlateVisible;

		private BigDecimal appliances;

		private BigDecimal appliancesTotalValue;

		private BigDecimal commuteOptions;

		private BigDecimal neighbourhoodType;

		private boolean communityDominated;

		private BigDecimal residency;

		private BigDecimal country;

		private BigDecimal yearsOfStay;

		private BigDecimal monthsOfStay;

		private BigDecimal distanceFromAddressToActualLoaction;

		private boolean negativeLocation;
		private BigDecimal monthlyAmortization;

		private BigDecimal rentPerMonth;

		private BigDecimal landlineNum;

		private String addressLine1;

		private String addressLine2;
		private String addressLine3;
		private String addressLine4;

		private String city;

		private String state;

		private String pincode;

		private BigDecimal country_code;

		private BigDecimal lattitue;

		private BigDecimal longitude;

		private boolean mailDeliveryStatus;

		private BigDecimal addressProofId;

		private String ownedBy;

		private String mortagagorName;

		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	private Date rentedFrom;


		private String residenceLandmark;

		private Integer applicant_id;

		private String persMet;


}