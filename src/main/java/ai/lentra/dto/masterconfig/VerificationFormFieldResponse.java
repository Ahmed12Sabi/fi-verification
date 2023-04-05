package ai.lentra.dto.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Size;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationFormFieldResponse {

    private long fieldId;
    private String fieldName;
    private String vType;
    private long formId;
private String formName;
private boolean  status;
private boolean  hidden;
private boolean required;
}
