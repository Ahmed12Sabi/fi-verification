package ai.lentra.modal.personal_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Data
//@Entity
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class PersonalDetailsHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "applicant_id")
	private long applicantId;
	private int persRefId;
	private boolean loanTakenEarlier;
	private String citizenship;
	private String birthDate;
	private String religion;
	private String martialStatus;
	private boolean politicallyExposed;
	private String educationLevel;
	private int age;
	private String lastName;
	private String alias;
	private String middleName;
	private String suffix;
	private String firstName;
	private BigDecimal income;
	private String civilStatus;
	private String incomeSource;
	private BigDecimal incomePeriod;
	private String dateTimeEndorsed;
	private String dateInspected;

	private Timestamp modifiedAt=Timestamp.from(Instant.now());
	private String modifiedBy;
	private String branchName;
	private String roleType;
	private String insId;
	private String productType;
}