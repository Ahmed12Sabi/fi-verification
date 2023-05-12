package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class VerificationFormFieldsConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private long fieldId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "form_id", referencedColumnName = "form_id")
    private VerificationFormConfig verificationFormConfig;
    @Size(min = 2, max = 50, message = " Field name should have 2 to 50 characters")
    @NotNull(message = "Field Name should not be null")
    private String fieldName;

    public long getFieldId() {
        return fieldId;
    }

    public void setFieldId(long fieldId) {
        this.fieldId = fieldId;
    }

    public VerificationFormConfig getVerificationFormConfig() {
        return verificationFormConfig;
    }

    public void setVerificationFormConfig(VerificationFormConfig verificationFormConfig) {
        this.verificationFormConfig = verificationFormConfig;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
