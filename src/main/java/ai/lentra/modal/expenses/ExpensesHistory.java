package ai.lentra.modal.expenses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ExpensesHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "applicant_id")
	private long applicantId;

	
	private BigDecimal otherExp;

	
	private BigDecimal collegeFeesAmt;

	
	private BigDecimal schoolFeesAmt;

	
	private BigDecimal electricBillAmt;

	
	private BigDecimal officeTransportationCost;

	
	private BigDecimal cableNetBillAmt;

	
	private BigDecimal broadbandBillAmt;

	
	private BigDecimal avgFuelCost;

	
	private BigDecimal waterBillAmt;

	
	private BigDecimal expScore;


	private Timestamp modifiedAt=Timestamp.from(Instant.now());
	private String modifiedBy;
	private String branchName;
	private String roleType;
	private String insId;
	private String productType;


}