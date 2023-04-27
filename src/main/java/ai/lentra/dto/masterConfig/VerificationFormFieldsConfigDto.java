package ai.lentra.dto.masterConfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationFormFieldsConfigDto {
    @NotNull(message = "Field id should not be null")
    private long fieldId;
//    private MasterVerificationConfigurationDto masterVerificationConfiguration;
//    private VerificationFormConfigDto verificationFormConfig;
    @Size(min = 2, max = 50, message = " Field name should have 2 to 50 characters")
    @NotNull(message = "Field Name should not be null")
    private String fieldName;
    @Size(min = 2, max = 50, message = " Field type should have 2 to 50 characters")
    @NotNull(message = "Field type should not be null")
    private String fieldType;
    private boolean isLookUp;
    private String lookTable;
    private boolean isScoring;
    private String scoringName;
    @NotNull(message = "status should not be null")
    private boolean status;
    @NotNull(message = "hidden should not be null")

    private boolean hidden;
    private Integer minLength;
    private Integer maxLength;
    private Integer minRange;
    private Integer maxRange;
    
    private boolean required;
    private boolean dataAutoPopulation;
}
