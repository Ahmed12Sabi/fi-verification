package ai.lentra.dto.masterConfig;

import ai.lentra.modal.masterconfig.VerificationConfig;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)

public class VerificationFormConfigDto {



    private long formId;

    private VerificationConfigDto verificationConfig;



    private String formName;


    private List<VerificationFormFieldsConfigDto> verificationFormFieldsConfig;

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
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

    public List<VerificationFormFieldsConfigDto> getVerificationFormFieldsConfig() {
        return verificationFormFieldsConfig;
    }

    public void setVerificationFormFieldsConfig(List<VerificationFormFieldsConfigDto> verificationFormFieldsConfig) {
        this.verificationFormFieldsConfig = verificationFormFieldsConfig;
    }
}

