package ai.lentra.modal.vehicle_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class VehicleDetailsHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
}