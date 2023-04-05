package ai.lentra.modal.scoreconfig;

import javax.persistence.Column;
import java.io.Serializable;

public class ScoreMasterComposityId implements Serializable {
    @Column(name = "s_id")
    private Long id;
    @Column(name ="sc_name")
    private String scoreName;
}
