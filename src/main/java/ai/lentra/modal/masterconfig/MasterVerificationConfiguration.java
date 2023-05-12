package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class MasterVerificationConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String profileName;
    private String instituteId;
    private ZonedDateTime created_on;
    private String created_by;
    private ZonedDateTime modified_on;
    private String modified_by;
    private String productType;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @OneToMany(cascade=CascadeType.ALL)
    private List<VerificationConfig> verificationConfig ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public ZonedDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(ZonedDateTime created_on) {
        this.created_on = created_on;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public ZonedDateTime getModified_on() {
        return modified_on;
    }

    public void setModified_on(ZonedDateTime modified_on) {
        this.modified_on = modified_on;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public List<VerificationConfig> getVerificationConfig() {
        return verificationConfig;
    }

    public void setVerificationConfig(List<VerificationConfig> verificationConfig) {
        this.verificationConfig = verificationConfig;
    }
}
