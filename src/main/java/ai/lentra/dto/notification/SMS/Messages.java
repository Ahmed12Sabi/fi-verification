package ai.lentra.dto.notification.SMS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Messages {
    private String[] aMobileNUmbers;//fetch mobile number from userRoleController
    private String sMessageText;// sms.properties file as per status
    private String sMsgId;
    private String sTemplateId;
    private  String sContentType;//
    private String sLanguage;

    public String[] getaMobileNUmbers() {
        return aMobileNUmbers;
    }

    public void setaMobileNUmbers(String[] aMobileNUmbers) {
        this.aMobileNUmbers = aMobileNUmbers;
    }

    public String getsMessageText() {
        return sMessageText;
    }

    public void setsMessageText(String sMessageText) {
        this.sMessageText = sMessageText;
    }

    public String getsMsgId() {
        return sMsgId;
    }

    public void setsMsgId(String sMsgId) {
        this.sMsgId = sMsgId;
    }

    public String getsTemplateId() {
        return sTemplateId;
    }

    public void setsTemplateId(String sTemplateId) {
        this.sTemplateId = sTemplateId;
    }

    public String getsContentType() {
        return sContentType;
    }

    public void setsContentType(String sContentType) {
        this.sContentType = sContentType;
    }

    public String getsLanguage() {
        return sLanguage;
    }

    public void setsLanguage(String sLanguage) {
        this.sLanguage = sLanguage;
    }
}
