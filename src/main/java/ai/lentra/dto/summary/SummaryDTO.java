package ai.lentra.dto.summary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SummaryDTO {
	private long applicantId;
	private int refId;
	private String preparedBy;
	private int finalScore;
	private String agencyName;
	private String dateAndTimePerformed;
	private String remarkDateTime;
	private String reviewedBy;
	private int remark;
	private String otherFindings;
}