package ai.lentra.modal.verification_type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Product {
    @Id
    private  long id;
    private long institutionId;
    private String profileName;
    private String productType;
}
