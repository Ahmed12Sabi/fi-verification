package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VerificationFormFieldsConfigRepository extends JpaRepository<VerificationFormFieldsConfig, Long> {
    @Query(value = "SELECT v.field_name AS fieldName , v.field_id AS fieldId,  m.profile_name AS profileName , m.v_type AS vType, m.user_type AS userType, m.sub_profile_name AS subProfileName, c.form_name AS formName"
            + " FROM verification_form_fields_config v CROSS JOIN master_verification_configuration m CROSS JOIN verification_form_config c",
            nativeQuery = true)
    List<VerificationFormFieldsConfig> findCrossJoin();

}
