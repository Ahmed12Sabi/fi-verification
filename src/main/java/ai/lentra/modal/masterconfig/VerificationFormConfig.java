package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class VerificationFormConfig {

    @Id
    @Column(name = "form_id")
    private long formId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "m_id", referencedColumnName = "id")
    private MasterVerificationConfiguration masterVerificationConfiguration;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "v_id", referencedColumnName = "v_id")
    private VerificationConfig verificationConfig;
    @NotBlank(message = "Form name should not be null")
    @Size(min = 2, max = 50, message = "Form name should have 2 to 50 characters")

    private String formName;
    @NotNull(message = "Form Description should not be null")
    @Size(min = 2, max = 50, message = "Form Description should have 2 to 50 characters")

    private String formDescription;

}

