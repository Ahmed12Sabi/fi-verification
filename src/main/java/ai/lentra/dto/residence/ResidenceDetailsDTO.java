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


	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
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



}