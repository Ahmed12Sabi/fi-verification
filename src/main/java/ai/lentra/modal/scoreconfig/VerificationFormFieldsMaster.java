package ai.lentra.modal.scoreconfig;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "verification_form_fields_master")
@IdClass(VerificationMasterFormFieldId.class)
public class VerificationFormFieldsMaster implements Serializable {

    @Id
    @Column(name = "field_id")
    private Long fieldId;
    @Column(name = "field_name")
    private String fieldName;
    @Column(name = "field_type")
    private String fieldType;
    @Column(name = "is_scoring")
    private Boolean isScoring;
    @Id
    @Column(name = "s_id")
    private Long scId;
    @Id
    @Column(name = "sc_name")
    private String scoreName;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "required")
    private Boolean required;
    @Column(name = "hidden")
    private Boolean hidden;

    @Column(name ="min_range")
    private Integer minRange;
    @Column(name ="max_range")
    private Integer maxRange;

    @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "s_id",insertable = false ,updatable = false)
   @JoinColumn(name = "sc_name",insertable = false ,updatable = false)
    private ScoreMaster scoreMaster;

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
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

    public Boolean getScoring() {
        return isScoring;
    }

    public void setScoring(Boolean scoring) {
        isScoring = scoring;
    }

    public Long getScId() {
        return scId;
    }

    public void setScId(Long scId) {
        this.scId = scId;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
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

    public ScoreMaster getScoreMaster() {
        return scoreMaster;
    }

    public void setScoreMaster(ScoreMaster scoreMaster) {
        this.scoreMaster = scoreMaster;
    }
}
