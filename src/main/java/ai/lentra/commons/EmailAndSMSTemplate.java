package ai.lentra.commons;

import ai.lentra.dto.notification.EMAIL.AttachmentFileDocuments;
import ai.lentra.dto.notification.EMAIL.EmailData;
import ai.lentra.dto.notification.EMAIL.EmailRequest;
import ai.lentra.dto.notification.SMS.Messages;
import ai.lentra.dto.notification.SMS.RequestData;
import ai.lentra.dto.notification.SMS.SmsRequest;

import java.util.Set;

public class EmailAndSMSTemplate {
    public static EmailRequest statusUpdateMail(String[] recipients, String[] recipientsBcc, String subject, String[] recipientsCC , Set<AttachmentFileDocuments> attachmentFile,String message){
        EmailRequest request = new EmailRequest();
        EmailData emailData = new EmailData();
        emailData.setaBCCReceiver(recipientsBcc);
        emailData.setsSubject(subject);
        emailData.setaCCReceiver(recipientsCC);
        emailData.setsMessage(message);
        emailData.setaReceiver(recipients);
        emailData.setaAttachmentFileDocuments(attachmentFile);
        request.setaVendors(new String[]{"lentra"});
        request.setsCallbackUrl("https://ssguat.serviceurl.in/smart-interface/client-callback");
        request.setoData(emailData);
        return request;
    }
    public static SmsRequest statusUpdateSms(Set<Messages> messages){
        SmsRequest smsRequest= new SmsRequest();
        RequestData sms = new RequestData();
        sms.setAmessages(messages);
        sms.setsRequestType("transaction");
        smsRequest.setaVendors(new String[]{"lentra"});
        smsRequest.setOdata(sms);
        smsRequest.setsCallbackUrl("https://webhook.site/441a549f-4c7b-4e55-8032-279e918a72");
        return null;
    }
    public static Messages getMessages(String language, String contentType, String[] numbers, String msgId,String templateId, String messageText){
        Messages ms = new Messages();
        ms.setsLanguage(language);

        ms.setsContentType(contentType);
        ms.setaMobileNUmbers(numbers);
        ms.setsMsgId(msgId);
        ms.setsTemplateId(templateId);
        ms.setsMessageText(messageText);
        return ms;
    }
}
