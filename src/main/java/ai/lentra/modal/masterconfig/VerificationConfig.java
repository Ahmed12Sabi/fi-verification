package ai.lentra.modal.masterconfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class VerificationConfig
{
    @Id
    @NotNull(message = "v_id should not be null")
    @Column(name = "v_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vId;
//    @OneToOne(cascade = CascadeType.ALL)
@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "m_id", referencedColumnName = "id")
    private MasterVerificationConfiguration masterVerificationConfiguration;

    @NotNull(message = "verification type should not be null")
    @Size(min = 2, max = 50, message = "verification type should have 2 to 50 characters")

    private String vType;
    @NotNull(message = "verification description should not be null")
    @Size(min = 2, max = 50, message = "verification description should have 2 to 50 characters")

    private String vDescription;

    public MasterVerificationConfiguration getMasterVerificationConfiguration() {
        return masterVerificationConfiguration;
    }

    public void setMasterVerificationConfiguration(MasterVerificationConfiguration masterVerificationConfiguration) {
        this.masterVerificationConfiguration = masterVerificationConfiguration;
    }

    public String getInstitute_id() {
        return institute_id;
    }

    public void setInstitute_id(String institute_id) {
        this.institute_id = institute_id;
    }

    private String institute_id;
    @OneToMany
   // @JoinColumn(name = "form_id", referencedColumnName = "form_id")

    private List<VerificationFormConfig> verificationFormConfig;

    public long getvId() {
        return vId;
    }

    public void setvId(long vId) {
        this.vId = vId;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getvDescription() {
        return vDescription;
    }

    public void setvDescription(String vDescription) {
        this.vDescription = vDescription;
    }

    public List<VerificationFormConfig> getVerificationFormConfig() {
        return verificationFormConfig;
    }

    public void setVerificationFormConfig(List<VerificationFormConfig> verificationFormConfig) {
        this.verificationFormConfig = verificationFormConfig;
    }
}
