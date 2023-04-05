package ai.lentra.dto.lookups;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimCardType {

    private long id ;

    @Pattern(regexp = "^[a-zA-Z]$")
    private String type;
    private boolean isActive;



}
