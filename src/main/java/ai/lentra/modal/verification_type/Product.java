package ai.lentra.modal.verification_type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Product {
    @Id
    private  long id;
    private long institutionId;
    private String profileName;
    private String productType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(long institutionId) {
        this.institutionId = institutionId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
