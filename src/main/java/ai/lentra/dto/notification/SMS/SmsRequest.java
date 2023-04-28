package ai.lentra.dto.notification.SMS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class SmsRequest {

    public String getsCallbackUrl() {
        return sCallbackUrl;
    }

    public void setsCallbackUrl(String sCallbackUrl) {
        this.sCallbackUrl = sCallbackUrl;
    }

    public String[] getaVendors() {
        return aVendors;
    }

    public void setaVendors(String[] aVendors) {
        this.aVendors = aVendors;
    }

    public RequestData getOdata() {
        return odata;
    }

    public void setOdata(RequestData odata) {
        this.odata = odata;
    }

    private String sCallbackUrl;
    private String[] aVendors;//vendor as "lentra"
    private RequestData odata;

}
