package ai.lentra.dto.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationFormFieldMasterDto {
    private long fieldId;
    @Size(min = 2, max = 50, message = " Field name should have 2 to 50 characters")

    private String fieldName;
    @Size(min = 2, max = 50, message = " field Type should have 2 to 50 characters")

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
    private VerificationFormMasterDto verificationFormMaster;
}

