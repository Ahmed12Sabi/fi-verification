package ai.lentra.modal.masterconfig;

import ai.lentra.dto.masterconfig.VerificationFormMasterDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Table(name = "verification_form_field_master")
public class VerificationFormFieldMaster {
    @Id
    @Column(name = "field_id", nullable = false)
private long fieldId;
    @Size(min = 2, max = 50, message = " Field name should have 2 to 50 characters")

    private String fieldName;
    @Size(min = 2, max = 50, message = " field TYpe should have 2 to 50 characters")

    private String fieldType;
private boolean isLookUp;
private String lookTable;
private boolean isScoring;
    @Size(min = 2, max = 50, message = " scoring name should have 2 to 50 characters")

private String scoringName;
private boolean status;
private boolean hidden;
private Integer minLength;
private Integer maxLength;
private Integer minRange;
private Integer maxRange;
private boolean required;
private boolean dataAutoPopulation;
    @OneToOne(cascade = CascadeType.ALL)
    private VerificationFormMaster verificationFormMaster;


}
