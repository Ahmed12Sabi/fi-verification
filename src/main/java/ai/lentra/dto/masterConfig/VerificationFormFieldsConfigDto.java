package ai.lentra.dto.masterConfig;

import ai.lentra.modal.masterconfig.VerificationFormConfig;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationFormFieldsConfigDto {




    private long fieldId;


    private VerificationFormConfigDto verificationFormConfig;

    private String fieldName;

    public long getFieldId() {
        return fieldId;
    }

    public void setFieldId(long fieldId) {
        this.fieldId = fieldId;
    }

    public VerificationFormConfigDto getVerificationFormConfig() {
        return verificationFormConfig;
    }

    public void setVerificationFormConfig(VerificationFormConfigDto verificationFormConfig) {
        this.verificationFormConfig = verificationFormConfig;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }



}
