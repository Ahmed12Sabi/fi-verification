package ai.lentra.modal.vehicle_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Table(name = "vehicleDetails")
public class VehicleDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "applicant_id")
	private Long applicantId;
	@Column(nullable = true)
	private int numberOfVehiclesOwned;
	@Column(nullable = true)
	private int bikeRegistrationNumber;
	@Column(nullable = true)
	private int manufactureYearCar;
	@Column(nullable = true)

	private String bikeManufactureName;
	@Column(nullable = true)

	private String carHypothecatedTo;
	@Column(nullable = true)

	private int carRegistrationNumber;
	@Column(nullable = true)

	private boolean withParkingSpace;
	@Column(nullable = true)

	private String carOwnershipType;
	@Column(nullable = true)

	private int manufactureYearTwoWheeler;
	@Column(nullable = true)

	private String twoWheelerModel;
	@Column(nullable = true)

	private String carIssuingAuthority;
	@Column(nullable = true)

	private String carManufactureName;
	@Column(nullable = true)

	private String bikeOwnershipType;
	@Column(nullable = true)

	private String financedFromDateCar;
	@Column(nullable = true)

	private String carFuelType;
	@Column(nullable = true)

	private String bikeHypothecatedTo;
	@Column(nullable = true)

	private int carSeatingCapacity;
	@Column(nullable = true)

	private String bikeIssuingAuthority;
	@Column(nullable = true)
	private String vehicleType;
	@Column(nullable = true)

	private String carModel;
	@Column(nullable = true)

	private String financedFromDateBike;

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
}