package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Table(name = "verification_form_master")
public class VerificationFormMaster {

@Id
@Column(name = "form_id", nullable = false)
        private long formId;
    @Size(min = 2, max = 50, message = " Form name should have 2 to 50 characters")

    private String formName;
    @Size(min = 2, max = 50, message = " Form description should have 2 to 50 characters")

    private String formDescription;
    }

