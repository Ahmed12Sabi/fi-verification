package ai.lentra.dto.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationFormMasterDto {

    private long formId;
    @Size(min = 2, max = 50, message = " Form name should have 2 to 50 characters")

    private String formName;
    @Size(min = 2, max = 50, message = " Form description should have 2 to 50 characters")

    private String formDescription;
}
