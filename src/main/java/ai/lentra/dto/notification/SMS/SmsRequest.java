package ai.lentra.dto.notification.SMS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class SmsRequest {

    private String sCallbackUrl;
    private String[] aVendors;//vendor as "lentra"
    private RequestData odata;

}
