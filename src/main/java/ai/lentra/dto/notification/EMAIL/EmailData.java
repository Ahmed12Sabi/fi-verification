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
}
