package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String formName;
//    @Type(JsonType.class)
//    @Type(type = "character varying[]")


    private String instituteId;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy="reportConfig")
    @OneToMany
    @JoinColumn(name = "f_id", referencedColumnName = "id")
    private List<ReportConfigFields> fields;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public List<ReportConfigFields> getFields() {
        return fields;
    }

    public void setFields(List<ReportConfigFields> fields) {
        this.fields = fields;
    }
}
