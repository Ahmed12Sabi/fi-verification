package ai.lentra.dto.notification.SMS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)

public class RequestData {
    private String sRequestType;//req type is "transmission"
    private Set<Messages> amessages = new HashSet<Messages>();

    public String getsRequestType() {
        return sRequestType;
    }

    public void setsRequestType(String sRequestType) {
        this.sRequestType = sRequestType;
    }

    public Set<Messages> getAmessages() {
        return amessages;
    }

    public void setAmessages(Set<Messages> amessages) {
        this.amessages = amessages;
    }
}
