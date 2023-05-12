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
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "m_id", referencedColumnName = "id")
    private MasterVerificationConfiguration masterVerificationConfiguration;

    @NotNull(message = "verification type should not be null")
    @Size(min = 2, max = 50, message = "verification type should have 2 to 50 characters")

    private String vType;
    @NotNull(message = "user type should not be null")
    @Size(min = 2, max = 50, message = "user type should have 2 to 50 characters")

    private String userType;
    private String subProfileName;

    private boolean esign;
    private boolean retrigerVerification;
    private String multiVerificationAllowed;

    @OneToMany(cascade=CascadeType.ALL)
    // @JoinColumn(name = "form_id", referencedColumnName = "form_id")

    private List<VerificationFormConfig> verificationFormConfig;

    public boolean isEsign() {
        return esign;
    }

    public void setEsign(boolean esign) {
        this.esign = esign;
    }

    public boolean isRetrigerVerification() {
        return retrigerVerification;
    }

    public void setRetrigerVerification(boolean retrigerVerification) {
        this.retrigerVerification = retrigerVerification;
    }

    public String getMultiVerificationAllowed() {
        return multiVerificationAllowed;
    }

    public void setMultiVerificationAllowed(String multiVerificationAllowed) {
        this.multiVerificationAllowed = multiVerificationAllowed;
    }

    public long getvId() {
        return vId;
    }

    public String getSubProfileName() {
        return subProfileName;
    }

    public void setSubProfileName(String subProfileName) {
        this.subProfileName = subProfileName;
    }

    public void setvId(long vId) {
        this.vId = vId;
    }

    public MasterVerificationConfiguration getMasterVerificationConfiguration() {
        return masterVerificationConfiguration;
    }

    public void setMasterVerificationConfiguration(MasterVerificationConfiguration masterVerificationConfiguration) {
        this.masterVerificationConfiguration = masterVerificationConfiguration;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<VerificationFormConfig> getVerificationFormConfig() {
        return verificationFormConfig;
    }

    public void setVerificationFormConfig(List<VerificationFormConfig> verificationFormConfig) {
        this.verificationFormConfig = verificationFormConfig;
    }
}
