package ai.lentra.modal.vehicle_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class VehicleDetailsHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "applicant_id", nullable = false)
	private Long applicantId;
	private int numberOfVehiclesOwned;
	private int bikeRegistrationNumber;
	private int manufactureYearCar;
	private String bikeManufactureName;
	private String carHypothecatedTo;
	private int carRegistrationNumber;
	private boolean withParkingSpace;
	private String carOwnershipType;
	private int manufactureYearTwoWheeler;
	private String twoWheelerModel;
	private String carIssuingAuthority;
	private String carManufactureName;
	private String bikeOwnershipType;
	private String financedFromDateCar;
	private String carFuelType;
	private String bikeHypothecatedTo;
	private int carSeatingCapacity;
	private String bikeIssuingAuthority;
	private String vehicleType;
	private String carModel;
	private String financedFromDateBike;

	private Timestamp modifiedAt=Timestamp.from(Instant.now());
	private String modifiedBy;
	private String branchName;
	private String roleType;
	private String insId;
	private String productType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
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

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getInsId() {
		return insId;
	}

	public void setInsId(String insId) {
		this.insId = insId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
}