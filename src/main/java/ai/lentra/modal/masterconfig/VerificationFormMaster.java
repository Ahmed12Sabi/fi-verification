package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Table(name = "verification_form_master")
public class VerificationFormMaster {

    @Id
    @Column(name = "form_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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

