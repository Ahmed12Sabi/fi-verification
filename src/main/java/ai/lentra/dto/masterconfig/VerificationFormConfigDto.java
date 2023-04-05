package ai.lentra.dto.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data

@JsonIgnoreProperties(ignoreUnknown = true)

public class VerificationFormConfigDto {

    @NotNull(message = "Form id should not be null")

    private long formId;
    private MasterVerificationConfigurationDto masterVerificationConfiguration;
    @JsonProperty("verificationConfig")

    private VerificationConfigDto verificationConfig;
    @NotNull(message = "Form name should not be null")
    @Size(min = 2, max = 50, message = "Form name should have 2 to 50 characters")

    private String formName;
    @NotNull(message = "Form Description should not be null")
    @Size(min = 2, max = 50, message = "Form Description should have 2 to 50 characters")

    private String formDescription;

}

