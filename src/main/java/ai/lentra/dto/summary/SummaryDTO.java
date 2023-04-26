package ai.lentra.dto.summary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getDateAndTimePerformed() {
		return dateAndTimePerformed;
	}

	public void setDateAndTimePerformed(String dateAndTimePerformed) {
		this.dateAndTimePerformed = dateAndTimePerformed;
	}

	public String getRemarkDateTime() {
		return remarkDateTime;
	}

	public void setRemarkDateTime(String remarkDateTime) {
		this.remarkDateTime = remarkDateTime;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public int getRemark() {
		return remark;
	}

	public void setRemark(int remark) {
		this.remark = remark;
	}

	public String getOtherFindings() {
		return otherFindings;
	}

	public void setOtherFindings(String otherFindings) {
		this.otherFindings = otherFindings;
	}
}