package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
@JsonIgnoreProperties(ignoreUnknown = true)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResidenceDto {

    @JsonProperty("applicant_id")
    private Long applicantId;

    @JsonProperty("residence_category")
    private BigDecimal residenceCategory;


    @JsonProperty("ownership_type")
    private BigDecimal ownershipType;

    @JsonProperty("property_age")
    private BigDecimal propertyAge;

    @JsonProperty("living_with")
    private String livingWIth;

    @JsonProperty("residence_type")
    private BigDecimal residenceType;

    @JsonProperty("res_no_of_storey")
    private BigDecimal resNoOfStorey;

    @JsonProperty("classification")
    private BigDecimal classification;

    @JsonProperty("house_condition")
    private BigDecimal houseCondition;

    @JsonProperty("property_make_type")
    private BigDecimal propertyMAkeType;

    @JsonProperty("property_interior")
    private BigDecimal propertyInterior;

    @JsonProperty("name_plate_visible")
    private boolean namePlateVisible;

    @JsonProperty("appliances")
    private BigDecimal appliances;

    @JsonProperty("appliances_total_value")
    private BigDecimal appliancesTotalValue;

    @JsonProperty("commute_options")
    private BigDecimal commuteOptions;

    @JsonProperty("neighbourhood_type")
    private BigDecimal neighbourhoodType;

    @JsonProperty("community_dominated")
    private boolean communityDominated;

    @JsonProperty("residency")
    private BigDecimal residency;

    @JsonProperty("country")
    private BigDecimal country;

    @JsonProperty("years_of_stay")
    private BigDecimal yearsOfStay;

    @JsonProperty("months_of_stay")
    private BigDecimal monthsOfStay;

    @JsonProperty("distance_from_address_to_actual_loaction")
    private BigDecimal distanceFromAddressToActualLoaction;

    @JsonProperty("res_negative_location")
    private boolean ResNegativeLocation;
    @JsonProperty("monthly_amortization")
    private BigDecimal monthlyAmortization;

    @JsonProperty("rent_per_month")
    private BigDecimal rentPerMonth;

    @JsonProperty("landline_num")
    private BigDecimal landlineNum;

    @JsonProperty("address_line_1")
    private String addressLine1;

    @JsonProperty("address_line_2")
    private String addressLine2;
    @JsonProperty("address_line_3")
    private String addressLine3;
    @JsonProperty("address_line_4")
    private String addressLine4;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("pincode")
    private String pincode;

    @JsonProperty("country_code")
    private BigDecimal country_code;

    @JsonProperty("lattitue")
    private BigDecimal lattitue;

    @JsonProperty("longitude")
    private BigDecimal longitude;

    @JsonProperty("mail_delivery_status")
    private boolean mailDeliveryStatus;

    @JsonProperty("address_proof_id")
    private BigDecimal addressProofId;

    @JsonProperty("owned_by")
    private String ownedBy;

    @JsonProperty("mortagagor_name")
    private String mortagagorName;

    @JsonProperty("rented_from")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

    private Date rentedFrom;


    @JsonProperty("residence_landmark")
    private String residenceLandmark;


    @JsonProperty("pers_met")
    private String persMet;

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
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
        return resNoOfStorey;
    }

    public void setResNoOfStorey(BigDecimal resNoOfStorey) {
        this.resNoOfStorey = resNoOfStorey;
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

    public String getPersMet() {
        return persMet;
    }

    public void setPersMet(String persMet) {
        this.persMet = persMet;
    }
}
