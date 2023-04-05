package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class MasterVerificationConfiguration {
    @Id
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
}
