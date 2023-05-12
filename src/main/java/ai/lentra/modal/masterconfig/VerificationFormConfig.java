package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @OneToMany(cascade=CascadeType.ALL)

    private List<VerificationFormFieldsConfig> verificationFormFieldsConfig;

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public VerificationConfig getVerificationConfig() {
        return verificationConfig;
    }

    public void setVerificationConfig(VerificationConfig verificationConfig) {
        this.verificationConfig = verificationConfig;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public List<VerificationFormFieldsConfig> getVerificationFormFieldsConfig() {
        return verificationFormFieldsConfig;
    }

    public void setVerificationFormFieldsConfig(List<VerificationFormFieldsConfig> verificationFormFieldsConfig) {
        this.verificationFormFieldsConfig = verificationFormFieldsConfig;
    }
}

