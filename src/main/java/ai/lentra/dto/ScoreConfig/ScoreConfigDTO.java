package ai.lentra.dto.ScoreConfig;


public class ScoreConfigDTO {

    private Long fieldId;

    private Long scId;
    private String fieldName;
    private String fieldType;
    private Boolean isScoring;
    private String scoreName;
    private Integer scoreValue;

    private Integer minRange;
    private Integer maxRange;
    private Boolean status;
    private Boolean required;
    private Boolean hidden;
    private Boolean rangeIndicator;

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Long getScId() {
        return scId;
    }

    public void setScId(Long scId) {
        this.scId = scId;
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

    public Boolean getScoring() {
        return isScoring;
    }

    public void setScoring(Boolean scoring) {
        isScoring = scoring;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public Integer getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(Integer scoreValue) {
        this.scoreValue = scoreValue;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getRangeIndicator() {
        return rangeIndicator;
    }

    public void setRangeIndicator(Boolean rangeIndicator) {
        this.rangeIndicator = rangeIndicator;
    }
}
