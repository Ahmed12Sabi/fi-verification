package ai.lentra.dto.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;




@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterVerificationConfigurationDto {
@NotNull(message = "m_id should not be null")
    private long id;
    private String profileName;
    private String vType;
    @NotNull(message = "User type should not be null")
    @Size(min = 2, max = 50, message = " User type should have 2 to 50 characters")
    private String userType;
    @NotNull(message = "Multiverification should not be null")
    @Size(min = 2, max = 50, message = "Multiverification should have 2 to 50 characters")
    private String multiVerificationAllowed;
    @NotNull(message = "Retriger Verification should not be null")

    private boolean retrigerVerification;
    private String productLevelLogic;
    private long profileId;
    private String subProfileName;
    private long institutionId;
    private boolean eSign;
    private List<VerificationConfigDto> verificationConfigDto;

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

    public String getMultiVerificationAllowed() {
        return multiVerificationAllowed;
    }

    public void setMultiVerificationAllowed(String multiVerificationAllowed) {
        this.multiVerificationAllowed = multiVerificationAllowed;
    }

    public boolean isRetrigerVerification() {
        return retrigerVerification;
    }

    public void setRetrigerVerification(boolean retrigerVerification) {
        this.retrigerVerification = retrigerVerification;
    }

    public String getProductLevelLogic() {
        return productLevelLogic;
    }

    public void setProductLevelLogic(String productLevelLogic) {
        this.productLevelLogic = productLevelLogic;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getSubProfileName() {
        return subProfileName;
    }

    public void setSubProfileName(String subProfileName) {
        this.subProfileName = subProfileName;
    }

    public long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(long institutionId) {
        this.institutionId = institutionId;
    }

    public boolean iseSign() {
        return eSign;
    }

    public void seteSign(boolean eSign) {
        this.eSign = eSign;
    }

    public List<VerificationConfigDto> getVerificationConfigDto() {
        return verificationConfigDto;
    }

    public void setVerificationConfigDto(List<VerificationConfigDto> verificationConfigDto) {
        this.verificationConfigDto = verificationConfigDto;
    }
}
