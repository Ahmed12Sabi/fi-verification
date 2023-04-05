package ai.lentra.modal.applicant_details;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ApplicantsAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private long id;
    private String addressType;
    private long applicantId;
    private String applicationId;
    private String address;
}
