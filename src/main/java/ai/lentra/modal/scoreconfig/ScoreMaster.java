package ai.lentra.modal.scoreconfig;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score_master")
@IdClass(ScoreMasterComposityId.class)
public class ScoreMaster implements Serializable {

    @Id
    @Column(name = "s_id")
    private Long id;
    @Id
    @Column(name ="sc_name")
    private String scoreName;
    @Column(name ="sc_value")
    private Integer scoreValue;
    @Column(name ="min_range")
    private Integer minRange;
    @Column(name ="max_range")
    private Integer maxRange;
    @Column(name ="range_indicator")
    private Boolean rangeIndicator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getRangeIndicator() {
        return rangeIndicator;
    }

    public void setRangeIndicator(Boolean rangeIndicator) {
        this.rangeIndicator = rangeIndicator;
    }
}
