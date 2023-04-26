package ai.lentra.dto.residence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Date;

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

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getResidenceCategory() {
		return residenceCategory;
	}

	public void setResidenceCategory(BigDecimal residenceCategory) {
		this.residenceCategory = residenceCategory;
	}

	public BigDecimal getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(BigDecimal ownershipType) {
		this.ownershipType = ownershipType;
	}

	public BigDecimal getPropertyAge() {
		return propertyAge;
	}

	public void setPropertyAge(BigDecimal propertyAge) {
		this.propertyAge = propertyAge;
	}

	public String getLivingWIth() {
		return livingWIth;
	}

	public void setLivingWIth(String livingWIth) {
		this.livingWIth = livingWIth;
	}

	public BigDecimal getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(BigDecimal residenceType) {
		this.residenceType = residenceType;
	}

	public BigDecimal getResNoOfStorey() {
		return ResNoOfStorey;
	}

	public void setResNoOfStorey(BigDecimal resNoOfStorey) {
		ResNoOfStorey = resNoOfStorey;
	}

	public BigDecimal getClassification() {
		return classification;
	}

	public void setClassification(BigDecimal classification) {
		this.classification = classification;
	}

	public BigDecimal getHouseCondition() {
		return houseCondition;
	}

	public void setHouseCondition(BigDecimal houseCondition) {
		this.houseCondition = houseCondition;
	}

	public BigDecimal getPropertyMAkeType() {
		return propertyMAkeType;
	}

	public void setPropertyMAkeType(BigDecimal propertyMAkeType) {
		this.propertyMAkeType = propertyMAkeType;
	}

	public BigDecimal getPropertyInterior() {
		return propertyInterior;
	}

	public void setPropertyInterior(BigDecimal propertyInterior) {
		this.propertyInterior = propertyInterior;
	}

	public boolean isNamePlateVisible() {
		return namePlateVisible;
	}

	public void setNamePlateVisible(boolean namePlateVisible) {
		this.namePlateVisible = namePlateVisible;
	}

	public BigDecimal getAppliances() {
		return appliances;
	}

	public void setAppliances(BigDecimal appliances) {
		this.appliances = appliances;
	}

	public BigDecimal getAppliancesTotalValue() {
		return appliancesTotalValue;
	}

	public void setAppliancesTotalValue(BigDecimal appliancesTotalValue) {
		this.appliancesTotalValue = appliancesTotalValue;
	}

	public BigDecimal getCommuteOptions() {
		return commuteOptions;
	}

	public void setCommuteOptions(BigDecimal commuteOptions) {
		this.commuteOptions = commuteOptions;
	}

	public BigDecimal getNeighbourhoodType() {
		return neighbourhoodType;
	}

	public void setNeighbourhoodType(BigDecimal neighbourhoodType) {
		this.neighbourhoodType = neighbourhoodType;
	}

	public boolean isCommunityDominated() {
		return communityDominated;
	}

	public void setCommunityDominated(boolean communityDominated) {
		this.communityDominated = communityDominated;
	}

	public BigDecimal getResidency() {
		return residency;
	}

	public void setResidency(BigDecimal residency) {
		this.residency = residency;
	}

	public BigDecimal getCountry() {
		return country;
	}

	public void setCountry(BigDecimal country) {
		this.country = country;
	}

	public BigDecimal getYearsOfStay() {
		return yearsOfStay;
	}

	public void setYearsOfStay(BigDecimal yearsOfStay) {
		this.yearsOfStay = yearsOfStay;
	}

	public BigDecimal getMonthsOfStay() {
		return monthsOfStay;
	}

	public void setMonthsOfStay(BigDecimal monthsOfStay) {
		this.monthsOfStay = monthsOfStay;
	}

	public BigDecimal getDistanceFromAddressToActualLoaction() {
		return distanceFromAddressToActualLoaction;
	}

	public void setDistanceFromAddressToActualLoaction(BigDecimal distanceFromAddressToActualLoaction) {
		this.distanceFromAddressToActualLoaction = distanceFromAddressToActualLoaction;
	}

	public boolean isNegativeLocation() {
		return negativeLocation;
	}

	public void setNegativeLocation(boolean negativeLocation) {
		this.negativeLocation = negativeLocation;
	}

	public BigDecimal getMonthlyAmortization() {
		return monthlyAmortization;
	}

	public void setMonthlyAmortization(BigDecimal monthlyAmortization) {
		this.monthlyAmortization = monthlyAmortization;
	}

	public BigDecimal getRentPerMonth() {
		return rentPerMonth;
	}

	public void setRentPerMonth(BigDecimal rentPerMonth) {
		this.rentPerMonth = rentPerMonth;
	}

	public BigDecimal getLandlineNum() {
		return landlineNum;
	}

	public void setLandlineNum(BigDecimal landlineNum) {
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

	public BigDecimal getCountry_code() {
		return country_code;
	}

	public void setCountry_code(BigDecimal country_code) {
		this.country_code = country_code;
	}

	public BigDecimal getLattitue() {
		return lattitue;
	}

	public void setLattitue(BigDecimal lattitue) {
		this.lattitue = lattitue;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public boolean isMailDeliveryStatus() {
		return mailDeliveryStatus;
	}

	public void setMailDeliveryStatus(boolean mailDeliveryStatus) {
		this.mailDeliveryStatus = mailDeliveryStatus;
	}

	public BigDecimal getAddressProofId() {
		return addressProofId;
	}

	public void setAddressProofId(BigDecimal addressProofId) {
		this.addressProofId = addressProofId;
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

	public Integer getApplicant_id() {
		return applicant_id;
	}

	public void setApplicant_id(Integer applicant_id) {
		this.applicant_id = applicant_id;
	}

	public String getPersMet() {
		return persMet;
	}

	public void setPersMet(String persMet) {
		this.persMet = persMet;
	}
}