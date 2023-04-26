package ai.lentra.modal.residence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ResidenceDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "applicant_id")
	private long applicantId;
	@Column(name = "residence_category")

	private Long residenceCategory;

	@Column(name = "ownership_type")

	private Long ownershipType;

	@Column(name = "living_with")

	private String livingWIth;

	@Column(name = "residence_type")
	private Long residenceType;

	@Column(name = "res_no_of_storey")
	private Long resNoOfStorey;

	@Column(name = "classification")
	private Long classification;

	@Column(name = "house_condition")
	private Long houseCondition;

	@Column(name = "property_make_type")
	private Long propertyMAkeType;

	@Column(name = "property_interior")
	private Long propertyInterior;

	@Column(name = "name_plate_visible")
	private boolean namePlateVisible;

	@Column(name = "appliances")
	private Long appliances;

	@Column(name = "appliances_total_value")
	private BigDecimal appliancesTotalValue;

	@Column(name = "commute_options")
	private Long commuteOptions;

	@Column(name = "neighbourhood_type")
	private Long neighbourhoodType;

	@Column(name = "community_dominated")
	private boolean communityDominated;

	@Column(name = "residency")
	private Long residency;

	@Column(name = "country")
	private Long country;

	@Column(name = "years_of_stay")
	private Long yearsOfStay;

	@Column(name = "months_of_stay")
	private Long monthsOfStay;

	@Column(name = "distance_from_address_to_actual_loaction")
	private Long distanceFromAddressToActualLoaction;

	@Column(name = "res_negative_location")
	private boolean ResNegativeLocation;
	@Column(name = "monthly_amortization")
	private BigDecimal monthlyAmortization;

	@Column(name = "rent_per_month")
	private Long rentPerMonth;

	@Column(name = "landline_num")
	private Long landlineNum;

	@Column(name = "address_line_1")
	private String addressLine1;

	@Column(name = "address_line_2")
	private String addressLine2;
	@Column(name = "address_line_3")
	private String addressLine3;
	@Column(name = "address_line_4")
	private String addressLine4;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "country_code")
	private Long country_code;

	@Column(name = "lattitue")
	private Long lattitue;

	@Column(name = "longitude")
	private Long longitude;

	@Column(name = "mail_delivery_status")
	private boolean mailDeliveryStatus;

	@Column(name = "address_proof_id")
	private Long addressProofId;

	@Column(name = "property_age")
	private Long propertyAge;

	@Column(name = "owned_by")
	private String ownedBy;

	@Column(name = "mortagagor_name")
	private String mortagagorName;

	@Column(name = "rented_from")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	private Date rentedFrom;

	@Column(name = "residence_landmark")
	private String residenceLandmark;

	@Column(name = "pers_met")
	private String persMet;

	@Column(name = "res_score")
	private BigDecimal ResScore;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public Long getResidenceCategory() {
		return residenceCategory;
	}

	public void setResidenceCategory(Long residenceCategory) {
		this.residenceCategory = residenceCategory;
	}

	public Long getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(Long ownershipType) {
		this.ownershipType = ownershipType;
	}

	public String getLivingWIth() {
		return livingWIth;
	}

	public void setLivingWIth(String livingWIth) {
		this.livingWIth = livingWIth;
	}

	public Long getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(Long residenceType) {
		this.residenceType = residenceType;
	}

	public Long getResNoOfStorey() {
		return resNoOfStorey;
	}

	public void setResNoOfStorey(Long resNoOfStorey) {
		this.resNoOfStorey = resNoOfStorey;
	}

	public Long getClassification() {
		return classification;
	}

	public void setClassification(Long classification) {
		this.classification = classification;
	}

	public Long getHouseCondition() {
		return houseCondition;
	}

	public void setHouseCondition(Long houseCondition) {
		this.houseCondition = houseCondition;
	}

	public Long getPropertyMAkeType() {
		return propertyMAkeType;
	}

	public void setPropertyMAkeType(Long propertyMAkeType) {
		this.propertyMAkeType = propertyMAkeType;
	}

	public Long getPropertyInterior() {
		return propertyInterior;
	}

	public void setPropertyInterior(Long propertyInterior) {
		this.propertyInterior = propertyInterior;
	}

	public boolean isNamePlateVisible() {
		return namePlateVisible;
	}

	public void setNamePlateVisible(boolean namePlateVisible) {
		this.namePlateVisible = namePlateVisible;
	}

	public Long getAppliances() {
		return appliances;
	}

	public void setAppliances(Long appliances) {
		this.appliances = appliances;
	}

	public BigDecimal getAppliancesTotalValue() {
		return appliancesTotalValue;
	}

	public void setAppliancesTotalValue(BigDecimal appliancesTotalValue) {
		this.appliancesTotalValue = appliancesTotalValue;
	}

	public Long getCommuteOptions() {
		return commuteOptions;
	}

	public void setCommuteOptions(Long commuteOptions) {
		this.commuteOptions = commuteOptions;
	}

	public Long getNeighbourhoodType() {
		return neighbourhoodType;
	}

	public void setNeighbourhoodType(Long neighbourhoodType) {
		this.neighbourhoodType = neighbourhoodType;
	}

	public boolean isCommunityDominated() {
		return communityDominated;
	}

	public void setCommunityDominated(boolean communityDominated) {
		this.communityDominated = communityDominated;
	}

	public Long getResidency() {
		return residency;
	}

	public void setResidency(Long residency) {
		this.residency = residency;
	}

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
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

	public Long getAddressProofId() {
		return addressProofId;
	}

	public void setAddressProofId(Long addressProofId) {
		this.addressProofId = addressProofId;
	}

	public Long getPropertyAge() {
		return propertyAge;
	}

	public void setPropertyAge(Long propertyAge) {
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
}