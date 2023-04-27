package ai.lentra.dto.masterConfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



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

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public MasterVerificationConfigurationDto getMasterVerificationConfiguration() {
        return masterVerificationConfiguration;
    }

    public void setMasterVerificationConfiguration(MasterVerificationConfigurationDto masterVerificationConfiguration) {
        this.masterVerificationConfiguration = masterVerificationConfiguration;
    }

    public VerificationConfigDto getVerificationConfig() {
        return verificationConfig;
    }

    public void setVerificationConfig(VerificationConfigDto verificationConfig) {
        this.verificationConfig = verificationConfig;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormDescription() {
        return formDescription;
    }

    public void setFormDescription(String formDescription) {
        this.formDescription = formDescription;
    }
}

