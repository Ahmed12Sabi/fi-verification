package ai.lentra.dto.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationConfigDto
{
    @NotNull(message = "v_id should not be null")
    private long vId;

    private MasterVerificationConfigurationDto masterVerificationConfiguration;
    @NotNull(message = "verification type should not be null")
    @Size(min = 2, max = 50, message = "verification type should have 2 to 50 characters")

    private String vType;
    @NotNull(message = "verification description should not be null")
    @Size(min = 2, max = 50, message = "verification description should have 2 to 50 characters")

    private String vDescription;
}
