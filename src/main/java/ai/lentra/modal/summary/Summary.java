package ai.lentra.modal.summary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.Date;


@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Summary{
	@Id
	@Column(name = "applicant_id")
	private long applicantId;
	private Integer sumRefId;

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public Integer getSumRefId() {
		return sumRefId;
	}

	public void setSumRefId(Integer sumRefId) {
		this.sumRefId = sumRefId;
	}

	public Integer getOtherFindings() {
		return otherFindings;
	}

	public void setOtherFindings(Integer otherFindings) {
		this.otherFindings = otherFindings;
	}

	public Integer getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(Integer finalScore) {
		this.finalScore = finalScore;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getRemarkDateTime() {
		return remarkDateTime;
	}

	public void setRemarkDateTime(Date remarkDateTime) {
		this.remarkDateTime = remarkDateTime;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public Date getDateAndTimePerformed() {
		return dateAndTimePerformed;
	}

	public void setDateAndTimePerformed(Date dateAndTimePerformed) {
		this.dateAndTimePerformed = dateAndTimePerformed;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Integer getSumScore() {
		return sumScore;
	}

	public void setSumScore(Integer sumScore) {
		this.sumScore = sumScore;
	}

	public String getFinalReviewStatus() {
		return finalReviewStatus;
	}

	public void setFinalReviewStatus(String finalReviewStatus) {
		this.finalReviewStatus = finalReviewStatus;
	}

	private Integer otherFindings;
	private Integer finalScore;
	private String remark;
	private Date remarkDateTime;
	private String preparedBy;
	private Date dateAndTimePerformed;
	private String reviewedBy;
	private String agencyName;
	private Integer sumScore;
	private String finalReviewStatus;
}