package ai.lentra.dto.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationFormFieldMasterDto {
    private long fieldId;
    @Size(min = 2, max = 50, message = " Field name should have 2 to 50 characters")

    private String fieldName;
    @Size(min = 2, max = 50, message = " field Type should have 2 to 50 characters")

    private String fieldType;
    private boolean isLookUp;
    private String lookTable;
    private boolean isScoring;
    @Size(min = 2, max = 50, message = " scoring name should have 2 to 50 characters")

    private String scoringName;
    private boolean status;
    private boolean hidden;
    private Integer minLength;
    private Integer maxLength;
    private Integer minRange;
    private Integer maxRange;
    private boolean required;
    private boolean dataAutoPopulation;
    private VerificationFormMasterDto verificationFormMaster;

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

    public VerificationFormMasterDto getVerificationFormMaster() {
        return verificationFormMaster;
    }

    public void setVerificationFormMaster(VerificationFormMasterDto verificationFormMaster) {
        this.verificationFormMaster = verificationFormMaster;
    }
}

