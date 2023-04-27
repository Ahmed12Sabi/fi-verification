package ai.lentra.dto.masterConfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Size;


@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationFormMasterDto {

    private long formId;
    @Size(min = 2, max = 50, message = " Form name should have 2 to 50 characters")

    private String formName;
    @Size(min = 2, max = 50, message = " Form description should have 2 to 50 characters")

    private String formDescription;

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
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
