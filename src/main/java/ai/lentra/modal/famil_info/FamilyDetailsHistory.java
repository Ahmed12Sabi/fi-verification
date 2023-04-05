package ai.lentra.modal.famil_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class FamilyDetailsHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "applicant_id")
	private long applicantId;
	private int numberOfDependents;
	private String motherMidName;
	private boolean entityConfirmationMother;
	private int motherAge;
	private String motherFirstName;
	private String motherLastName;
	private String motherReligion;
	private String fatherMidName;
	private String fatherFirstName;
	private int fatherAge;
	private String fatherReligion;
	private String fatherLastName;
	private boolean entityConfirmationFather;
	private int numberOfMinor;
	private String childEducationLevel;
	private boolean spouseWorking;
	private String spouseLastName;
	private String spouseOccupation;
	private int spouseAge;
	private boolean entityConfirmationSpouse;
	private String spouseReligion;
	private String spouseCitizenship;
	private String spouseMidName;
	private String spouseSuffix;
	private String spouseAlias;
	private String spouseBirthdate;
	private String spouseFirstName;
	private Timestamp modifiedAt=Timestamp.from(Instant.now());
	private String modifiedBy;
	private String branchName;
	private String roleType;
	private String insId;
	private String productType;
}