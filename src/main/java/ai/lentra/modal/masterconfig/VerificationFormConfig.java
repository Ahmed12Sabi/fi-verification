package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class VerificationFormConfig {

    @Id
    @Column(name = "form_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long formId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "v_id", referencedColumnName = "v_id")
    private VerificationConfig verificationConfig;

    @NotBlank(message = "Form name should not be null")
    @Size(min = 2, max = 50, message = "Form name should have 2 to 50 characters")

    private String formName;
    @NotNull(message = "Form Description should not be null")
    @Size(min = 2, max = 50, message = "Form Description should have 2 to 50 characters")

    private String formDescription;
    private String subProfileName;
    private boolean hidden;

    private String institute_id;

    public String getInstitute_id() {
        return institute_id;
    }

    public void setInstitute_id(String institute_id) {
        this.institute_id = institute_id;
    }

    @OneToMany

    private List<VerificationFormFieldsConfig> verificationFormFieldsConfig;

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

    public VerificationConfig getVerificationConfig() {
        return verificationConfig;
    }

    public void setVerificationConfig(VerificationConfig verificationConfig) {
        this.verificationConfig = verificationConfig;
    }

    public List<VerificationFormFieldsConfig> getVerificationFormFieldsConfig() {
        return verificationFormFieldsConfig;
    }

    public void setVerificationFormFieldsConfig(List<VerificationFormFieldsConfig> verificationFormFieldsConfig) {
        this.verificationFormFieldsConfig = verificationFormFieldsConfig;
    }

    public String getSubProfileName() {
        return subProfileName;
    }

    public void setSubProfileName(String subProfileName) {
        this.subProfileName = subProfileName;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}

