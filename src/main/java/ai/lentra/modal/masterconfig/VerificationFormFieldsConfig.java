package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class VerificationFormFieldsConfig {
    @Id
    private long fieldId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "m_id", referencedColumnName = "id")
    private MasterVerificationConfiguration masterVerificationConfiguration;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "form_id", referencedColumnName = "form_id")
    private VerificationFormConfig verificationFormConfig;
    @Size(min = 2, max = 50, message = " Field name should have 2 to 50 characters")
    @NotNull(message = "Field Name should not be null")
    private String fieldName;
    @Size(min = 2, max = 50, message = " Field type should have 2 to 50 characters")
    @NotNull(message = "Field type should not be null")
    private String fieldType;
    private boolean isLookUp;
    private String lookTable;
    private boolean isScoring;
    private String scoringName;
    @NotNull(message = "Status should not be null")
    private boolean status;
    @NotNull(message = "Hidden should not be null")

    private boolean hidden;
    private Integer minLength;
    private Integer maxLength;
    private Integer minRange;
    private Integer maxRange;

    @NotNull(message = "Status should not be null")

    private boolean required;
    private boolean dataAutoPopulation;
}
