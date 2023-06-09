package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "product_config")
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ProductConfigEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String productType;

    private String profileName;

    private String instituteId;
    @Column(columnDefinition = "boolean default false")
    private Boolean mandatory;
    @Column(columnDefinition = "boolean default false")
    private Boolean dataPopulated;
    @Column(columnDefinition = "boolean default false")
    private Boolean waiverAllowed;
    private ZonedDateTime created_on;
    private String created_by;
    private ZonedDateTime modified_on;
    private String modified_by;

    public ZonedDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(ZonedDateTime created_on) {
        this.created_on = created_on;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public ZonedDateTime getModified_on() {
        return modified_on;
    }

    public void setModified_on(ZonedDateTime modified_on) {
        this.modified_on = modified_on;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Boolean getDataPopulated() {
        return dataPopulated;
    }

    public void setDataPopulated(Boolean dataPopulated) {
        this.dataPopulated = dataPopulated;
    }

    public Boolean getWaiverAllowed() {
        return waiverAllowed;
    }

    public void setWaiverAllowed(Boolean waiverAllowed) {
        this.waiverAllowed = waiverAllowed;
    }
}
