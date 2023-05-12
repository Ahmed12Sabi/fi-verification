package ai.lentra.dto.vehicleinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;



@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDetailsDTO {
    private long applicantId;

    @Min(value = 0, message = "Number of vehicle owned should  not be possitive")
    @Max(value = 999, message = "Number of vehicle owned should not be contain more than 3")
    private int numberOfVehiclesOwned;

    @Min(value = 10, message = "Bike Registration Number should be less than 20 characters and more than 2 characters")
    @Max(value = 999999999, message = "Bike Registration Number should be less than 20 characters and more than 2 characters")
    private int bikeRegistrationNumber;

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public int getNumberOfVehiclesOwned() {
        return numberOfVehiclesOwned;
    }

    public void setNumberOfVehiclesOwned(int numberOfVehiclesOwned) {
        this.numberOfVehiclesOwned = numberOfVehiclesOwned;
    }

    public int getBikeRegistrationNumber() {
        return bikeRegistrationNumber;
    }

    public void setBikeRegistrationNumber(int bikeRegistrationNumber) {
        this.bikeRegistrationNumber = bikeRegistrationNumber;
    }

    public int getManufactureYearCar() {
        return manufactureYearCar;
    }

    public void setManufactureYearCar(int manufactureYearCar) {
        this.manufactureYearCar = manufactureYearCar;
    }

    public String getBikeManufactureName() {
        return bikeManufactureName;
    }

    public void setBikeManufactureName(String bikeManufactureName) {
        this.bikeManufactureName = bikeManufactureName;
    }

    public String getCarHypothecatedTo() {
        return carHypothecatedTo;
    }

    public void setCarHypothecatedTo(String carHypothecatedTo) {
        this.carHypothecatedTo = carHypothecatedTo;
    }

    public int getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(int carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public boolean isWithParkingSpace() {
        return withParkingSpace;
    }

    public void setWithParkingSpace(boolean withParkingSpace) {
        this.withParkingSpace = withParkingSpace;
    }

    public String getCarOwnershipType() {
        return carOwnershipType;
    }

    public void setCarOwnershipType(String carOwnershipType) {
        this.carOwnershipType = carOwnershipType;
    }

    public int getManufactureYearTwoWheeler() {
        return manufactureYearTwoWheeler;
    }

    public void setManufactureYearTwoWheeler(int manufactureYearTwoWheeler) {
        this.manufactureYearTwoWheeler = manufactureYearTwoWheeler;
    }

    public String getTwoWheelerModel() {
        return twoWheelerModel;
    }

    public void setTwoWheelerModel(String twoWheelerModel) {
        this.twoWheelerModel = twoWheelerModel;
    }

    public String getCarIssuingAuthority() {
        return carIssuingAuthority;
    }

    public void setCarIssuingAuthority(String carIssuingAuthority) {
        this.carIssuingAuthority = carIssuingAuthority;
    }

    public String getCarManufactureName() {
        return carManufactureName;
    }

    public void setCarManufactureName(String carManufactureName) {
        this.carManufactureName = carManufactureName;
    }

    public String getBikeOwnershipType() {
        return bikeOwnershipType;
    }

    public void setBikeOwnershipType(String bikeOwnershipType) {
        this.bikeOwnershipType = bikeOwnershipType;
    }

    public String getFinancedFromDateCar() {
        return financedFromDateCar;
    }

    public void setFinancedFromDateCar(String financedFromDateCar) {
        this.financedFromDateCar = financedFromDateCar;
    }

    public String getCarFuelType() {
        return carFuelType;
    }

    public void setCarFuelType(String carFuelType) {
        this.carFuelType = carFuelType;
    }

    public String getBikeHypothecatedTo() {
        return bikeHypothecatedTo;
    }

    public void setBikeHypothecatedTo(String bikeHypothecatedTo) {
        this.bikeHypothecatedTo = bikeHypothecatedTo;
    }

    public int getCarSeatingCapacity() {
        return carSeatingCapacity;
    }

    public void setCarSeatingCapacity(int carSeatingCapacity) {
        this.carSeatingCapacity = carSeatingCapacity;
    }

    public String getBikeIssuingAuthority() {
        return bikeIssuingAuthority;
    }

    public void setBikeIssuingAuthority(String bikeIssuingAuthority) {
        this.bikeIssuingAuthority = bikeIssuingAuthority;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getFinancedFromDateBike() {
        return financedFromDateBike;
    }

    public void setFinancedFromDateBike(String financedFromDateBike) {
        this.financedFromDateBike = financedFromDateBike;
    }

    @Min(value = 1000, message = "Car Manufacturer Year should be less than 20 characters and more than 2 characters")
    @Max(value = 999999999, message = "Car Manufacturer Year should be less than 20 characters and more than 2 characters")
    private int manufactureYearCar;
    @Pattern(regexp = "^[a-zA-Z]{4,10}$", message = "Bike Manufacturer Year should be less than 10 characters and more than 4 characters")
    private String bikeManufactureName;
    @Pattern(regexp = "^[a-zA-Z]{3,50}$", message = "Car Hypothecated Name should be less than 50 characters and more than 3 characters")

    private String carHypothecatedTo;
    //	@Size(min=2,max=20,message = "Car Registration Number  should be less than 20 characters and more than 2 characters")
    @Min(value = 2, message = "Car Registration Number  should be less than 20 characters and more than 2 characters")
    @Max(value = 999999999, message = "Car Registration Number should be less than 20 characters and more than 2 characters")
    private int carRegistrationNumber;
    private boolean withParkingSpace;
    @Pattern(regexp = "^[a-zA-Z]{4,20}$", message = "Car Ownership type should be less than 20 characters and more than 4 characters")

    private String carOwnershipType;
    @Min(value = 1000, message = "Manufacturer Year  should be less than 20 characters and more than 4 characters")
    @Max(value = 999999999, message = "Manufacturer Year should be less than 20 characters and more than 4 characters")
    private int manufactureYearTwoWheeler;
    @Pattern(regexp = "^[a-zA-Z0-9]{0,255}$", message = "Two Wheeler Model should be less than 255 characters and more than 0 characters")

    private String twoWheelerModel;
    @Pattern(regexp = "^[a-zA-Z0-9]{2,50}$", message = "Car Issuing Authority should be less than 50 characters and more than 2 characters")
    private String carIssuingAuthority;
    @Pattern(regexp = "^[a-zA-Z]{3,50}$", message = "Car Manufacturer Name should be less than 50 characters and more than 3 characters")

    private String carManufactureName;
    @Pattern(regexp = "^[a-zA-Z]{4,20}$", message = "Bike Ownership type should be less than 20 characters and more than 4 characters")

    private String bikeOwnershipType;
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Invalid date format. Please use the format DD/MM/YYYY")

    private String financedFromDateCar;
    @Pattern(regexp = "^[a-zA-Z]{0,6}$", message = "Car Fuel type should be less than 20 characters and more than 10 characters")

    private String carFuelType;
    @Pattern(regexp = "^[a-zA-Z]{3,50}$", message = "Bike Hypothecated Name should be less than 50 characters and more than 3 characters")
    private String bikeHypothecatedTo;

    @Min(value = 1, message = "Car Seating Capacity should be 1 characters")
    @Max(value = 9, message = "Car Seating Capacity should be 1 characters")
    private int carSeatingCapacity;
    @Pattern(regexp = "^[a-zA-Z0-9]{2,50}$", message = "Bike Issuing Authority should be less than 50 characters and more than 2 characters")

    private String bikeIssuingAuthority;
    @Pattern(regexp = "^[a-zA-Z]{10,20}$", message = "Vehicle type should be less than 20 characters and more than 10 characters")

    private String vehicleType;
    @Pattern(regexp = "^[a-zA-Z0-9]{0,255}$", message = "Car Model type should be less than 255 characters and more than 0 characters")

    private String carModel;
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Invalid date format. Please use the format DD/MM/YYYY")

    private String financedFromDateBike;
}