package ai.lentra.modal.file_upload;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.Instant;

@Entity
public class FileUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long applicantId;
    private String filename;
    private String contentType;
//to accept geolocation

    private String latitude;

    private String longitude;
//to accept timestamp
    @CreatedDate
    private Instant timestamp;
    private byte[] data;
    public FileUpload() {}

    public FileUpload(Long id, long applicantId, String filename, String contentType, byte[] data) {
        this.id = id;
        this.applicantId = applicantId;
        this.filename = filename;
        this.contentType = contentType;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}