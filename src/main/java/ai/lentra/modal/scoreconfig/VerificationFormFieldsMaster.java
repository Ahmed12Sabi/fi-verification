package ai.lentra.modal.scoreconfig;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "verification_form_fields_master")
@Data
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

}
