package ai.lentra.modal.masterconfig;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Embeddable
public class ReportConfigFields {
    @Id
    @GeneratedValue
    private long id;
    private String fields;



}
