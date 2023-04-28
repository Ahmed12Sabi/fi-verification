package ai.lentra.dto.notification.EMAIL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class EmailRequest {
    public String[] getaVendors() {
        return aVendors;
    }

    public void setaVendors(String[] aVendors) {
        this.aVendors = aVendors;
    }

    public String getsCallbackUrl() {
        return sCallbackUrl;
    }

    public void setsCallbackUrl(String sCallbackUrl) {
        this.sCallbackUrl = sCallbackUrl;
    }

    public EmailData getoData() {
        return oData;
    }

    public void setoData(EmailData oData) {
        this.oData = oData;
    }

    private  String[] aVendors;//"lentra"

    private  String sCallbackUrl;//"demo callbackurl
    private EmailData oData;
}
