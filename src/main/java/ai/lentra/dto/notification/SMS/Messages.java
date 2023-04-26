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
}
