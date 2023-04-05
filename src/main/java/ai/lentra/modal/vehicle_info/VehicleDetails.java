package ai.lentra.modal.vehicle_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Table(name = "vehicleDetails")
public class VehicleDetails{
	@Id
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
}