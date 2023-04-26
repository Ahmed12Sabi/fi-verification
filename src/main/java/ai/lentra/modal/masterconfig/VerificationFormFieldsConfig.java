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
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "m_id", referencedColumnName = "id")
//    private MasterVerificationConfiguration masterVerificationConfiguration;
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

    public long getFieldId() {
        return fieldId;
    }

    public void setFieldId(long fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isLookUp() {
        return isLookUp;
    }

    public void setLookUp(boolean lookUp) {
        isLookUp = lookUp;
    }

    public String getLookTable() {
        return lookTable;
    }

    public void setLookTable(String lookTable) {
        this.lookTable = lookTable;
    }

    public boolean isScoring() {
        return isScoring;
    }

    public void setScoring(boolean scoring) {
        isScoring = scoring;
    }

    public String getScoringName() {
        return scoringName;
    }

    public void setScoringName(String scoringName) {
        this.scoringName = scoringName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Integer getMinRange() {
        return minRange;
    }

    public void setMinRange(Integer minRange) {
        this.minRange = minRange;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isDataAutoPopulation() {
        return dataAutoPopulation;
    }

    public void setDataAutoPopulation(boolean dataAutoPopulation) {
        this.dataAutoPopulation = dataAutoPopulation;
    }
}
