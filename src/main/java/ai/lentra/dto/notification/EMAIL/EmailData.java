package ai.lentra.dto.notification.EMAIL;

import java.util.HashSet;
import java.util.Set;

public class EmailData {
    private String[] aBCCReceiver;//
    private String[] aCCReceiver;//
    private String[] aReceiver;//Fetch from UserROleController
    private String sMessage;// fetch from email.Propertis
    private String sSubject;// fetch from email.properties

    private Set<AttachmentFileDocuments> aAttachmentFileDocuments = new HashSet<AttachmentFileDocuments>();

    public String[] getaBCCReceiver() {
        return aBCCReceiver;
    }

    public void setaBCCReceiver(String[] aBCCReceiver) {
        this.aBCCReceiver = aBCCReceiver;
    }

    public String[] getaCCReceiver() {
        return aCCReceiver;
    }

    public void setaCCReceiver(String[] aCCReceiver) {
        this.aCCReceiver = aCCReceiver;
    }

    public String[] getaReceiver() {
        return aReceiver;
    }

    public void setaReceiver(String[] aReceiver) {
        this.aReceiver = aReceiver;
    }

    public String getsMessage() {
        return sMessage;
    }

    public void setsMessage(String sMessage) {
        this.sMessage = sMessage;
    }

    public String getsSubject() {
        return sSubject;
    }

    public void setsSubject(String sSubject) {
        this.sSubject = sSubject;
    }

    public Set<AttachmentFileDocuments> getaAttachmentFileDocuments() {
        return aAttachmentFileDocuments;
    }

    public void setaAttachmentFileDocuments(Set<AttachmentFileDocuments> aAttachmentFileDocuments) {
        this.aAttachmentFileDocuments = aAttachmentFileDocuments;
    }
}
