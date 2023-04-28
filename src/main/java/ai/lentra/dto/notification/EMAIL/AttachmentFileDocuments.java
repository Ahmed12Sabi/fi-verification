package ai.lentra.dto.notification.EMAIL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentFileDocuments {

    public String getsContent() {
        return sContent;
    }

    public void setsContent(String sContent) {
        this.sContent = sContent;
    }

    public String getsFileName() {
        return sFileName;
    }

    public void setsFileName(String sFileName) {
        this.sFileName = sFileName;
    }

    public String getsMediaType() {
        return sMediaType;
    }

    public void setsMediaType(String sMediaType) {
        this.sMediaType = sMediaType;
    }

    private String sContent;
    private String sFileName;
    private String sMediaType;
}
