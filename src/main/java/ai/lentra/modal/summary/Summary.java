package ai.lentra.modal.summary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;


@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Summary{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private  long id;
	
	@Column(name = "applicant_id")
	private long applicantId;
	@Column(name = "ref_id")

	private Integer sumRefId;

	@Column(name = "other_findings")

	private Integer otherFindings;

	@Column(name = "final_score")

	private Integer finalScore;

	@Column(name = "remark")

	private String remark;

	@Column(name = "remark_date_time")

	private Date remarkDateTime;

	@Column(name = "prepared_by")

	private String preparedBy;

	@Column(name = "date_and_time_performed")

	private Date dateAndTimePerformed;

	@Column(name = "reviewed_by")

	private String reviewedBy;

	@Column(name = "agency_name")

	private String agencyName;

	@Column(name = "sum_score")

	private Integer sumScore;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
}