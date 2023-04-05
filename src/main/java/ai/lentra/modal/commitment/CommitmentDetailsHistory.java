package ai.lentra.modal.commitment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class CommitmentDetailsHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Column(name = "applicant_id")
	private long applicantId;
	private String bankNameLoc;
	private int termInsuranceAmt;
	private int lifeInsuranceDuration;
	private int termInsuranceDuration;
	private int locAmt;
	private int carInsuranceAmt;
	private int twoWheelerInsuranceDuration;
	private int npsDuration;
	private int homeInsuranceAmt;
	private String locExpiryDate;
	private int carInsuranceDuration;
	private String insuranceType;
	private int healthInsuranceDuration;
	private int homeInsuranceDuration;
	private String npsApplicantName;
	private int healthInsuranceAmt;
	private int npsAmt;
	private int lifeInsuranceAmt;
	private int twoWheelerInsuranceAmt;
	private int customerId;
	private Timestamp modifiedAt=Timestamp.from(Instant.now());
	private String modifiedBy;
	private String branchName;
	private String roleType;
	private String insId;
	private String productType;
}