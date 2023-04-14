package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportConfig {
    @Id
    @GeneratedValue
    private long id;

    private String formName;
//    @Type(JsonType.class)
//    @Type(type = "character varying[]")


    private Integer instituteId;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy="reportConfig")
    @OneToMany
    @JoinColumn(name = "f_id", referencedColumnName = "id")

//    @JoinTable(name = "report_config_fields")
    private List<ReportConfigFields> fields;

}
