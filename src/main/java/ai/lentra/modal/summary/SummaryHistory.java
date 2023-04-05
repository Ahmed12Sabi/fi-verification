package ai.lentra.modal.summary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

@Data
@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class SummaryHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "applicant_id")
	private long applicantId;
	

	private Integer sumRefId;

	
	private Integer otherFindings;
	
	private Integer finalScore;
	
	private String remark;
	
	private Date remarkDateTime;
	
	private String preparedBy;
	
	private Date dateAndTimePerformed;
	
	private String reviewedBy;
	
	private String agencyName;
	
	private Integer sumScore;


	private Timestamp modifiedAt=Timestamp.from(Instant.now());
	private String modifiedBy;
	private String branchName;
	private String roleType;
	private String insId;
	private String productType;
}