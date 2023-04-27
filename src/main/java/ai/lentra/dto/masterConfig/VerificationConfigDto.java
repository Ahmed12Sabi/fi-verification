package ai.lentra.dto.masterConfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationConfigDto
{
    @NotNull(message = "v_id should not be null")
    private long vId;

//    private MasterVerificationConfigurationDto masterVerificationConfiguration;
    @NotNull(message = "verification type should not be null")
    @Size(min = 2, max = 50, message = "verification type should have 2 to 50 characters")

    private String vType;
    @NotNull(message = "verification description should not be null")
    @Size(min = 2, max = 50, message = "verification description should have 2 to 50 characters")

    private String vDescription;
    private List<VerificationFormFieldsConfigDto> verificationFormFieldsConfigDto;

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

    public List<VerificationFormFieldsConfigDto> getVerificationFormFieldsConfigDto() {
        return verificationFormFieldsConfigDto;
    }

    public void setVerificationFormFieldsConfigDto(List<VerificationFormFieldsConfigDto> verificationFormFieldsConfigDto) {
        this.verificationFormFieldsConfigDto = verificationFormFieldsConfigDto;
    }
}
