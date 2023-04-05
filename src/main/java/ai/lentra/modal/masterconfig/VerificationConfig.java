package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class VerificationConfig
{
    @Id
    @NotNull(message = "v_id should not be null")

    @Column(name = "v_id")
    private long vId;
    @OneToOne(cascade = CascadeType.ALL)
    private MasterVerificationConfiguration masterVerificationConfiguration;

    @NotNull(message = "verification type should not be null")
    @Size(min = 2, max = 50, message = "verification type should have 2 to 50 characters")

    private String vType;
    @NotNull(message = "verification description should not be null")
    @Size(min = 2, max = 50, message = "verification description should have 2 to 50 characters")

    private String vDescription;
}
