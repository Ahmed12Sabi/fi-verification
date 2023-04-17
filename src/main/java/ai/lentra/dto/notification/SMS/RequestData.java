package ai.lentra.dto.notification.SMS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class RequestData {
    private String sRequestType;//req type is "transmission"
    private Set<Messages> amessages = new HashSet<Messages>();
}
