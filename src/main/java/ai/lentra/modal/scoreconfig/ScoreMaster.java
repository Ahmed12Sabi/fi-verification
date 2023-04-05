package ai.lentra.modal.scoreconfig;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score_master")
@Data
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

}
