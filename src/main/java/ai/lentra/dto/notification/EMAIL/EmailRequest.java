package ai.lentra.dto.notification.EMAIL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class EmailRequest {
    private  String[] aVendors;//"lentra"
    private  String sCallbackUrl;//"demo callbackurl
    private EmailData oData;
}
