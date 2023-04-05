package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "product_config")
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ProductConfigEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue
    private long productId;

    private String productType;

    private String profileName;
}
