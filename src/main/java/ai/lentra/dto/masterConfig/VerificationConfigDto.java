package ai.lentra.dto.masterConfig;

import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import ai.lentra.modal.masterconfig.VerificationFormConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationConfigDto
{

    private long vId;
    //    @OneToOne(cascade = CascadeType.ALL)

    private MasterVerificationConfigurationDto masterVerificationConfiguration;
    private boolean esign;
    private boolean retrigerVerification;
    private String multiVerificationAllowed;

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

    private String vType;

    private String userType;

    // @JoinColumn(name = "form_id", referencedColumnName = "form_id")

    private List<VerificationFormConfigDto> verificationFormConfig;

    public long getvId() {
        return vId;
    }

    public void setvId(long vId) {
        this.vId = vId;
    }

    public MasterVerificationConfigurationDto getMasterVerificationConfiguration() {
        return masterVerificationConfiguration;
    }

    public void setMasterVerificationConfiguration(MasterVerificationConfigurationDto masterVerificationConfiguration) {
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

    public List<VerificationFormConfigDto> getVerificationFormConfig() {
        return verificationFormConfig;
    }

    public void setVerificationFormConfig(List<VerificationFormConfigDto> verificationFormConfig) {
        this.verificationFormConfig = verificationFormConfig;
    }
}
