package ai.lentra.dto.lookups;

import com.fasterxml.jackson.annotation.JsonInclude;


import javax.persistence.*;
import javax.validation.constraints.Pattern;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimCardType {

    private long id ;

    @Pattern(regexp = "^[a-zA-Z]$")
    private String type;
    private boolean isActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
