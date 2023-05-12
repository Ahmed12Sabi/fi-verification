package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VerificationFormFieldsConfigRepository extends JpaRepository<VerificationFormFieldsConfig, Long> {
    /*@Query(value = "SELECT v.field_name AS fieldName , v.field_id AS fieldId,  m.profile_name AS profileName , m.v_type AS vType, m.user_type AS userType, m.sub_profile_name AS subProfileName, c.form_name AS formName"
            + " FROM verification_form_fields_config v CROSS JOIN master_verification_configuration m CROSS JOIN verification_form_config c",
            nativeQuery = true)
    List<VerificationFormFieldsConfig> findCrossJoin();
    @Query(value = "SELECT v.field_name , v.field_id, v.required, v.field_type,v.is_look_up, v.look_table, v.is_scoring," +
            "v.scoring_name, v.status, v.hidden,v.data_auto_population, v.m_id, v.form_id, v.data_auto_population, v.min_length, v.max_length, v.min_range, v.max_range," +
            " m.profile_name , m.v_type, m.user_type, m.sub_profile_name, c.form_name AS formName"
            + " FROM verification_form_fields_config v CROSS JOIN master_verification_configuration m  " +
            " CROSS JOIN verification_form_config c WHERE m.institution_id=?1",
            nativeQuery = true)
    List<VerificationFormFieldsConfig> findByInstistuteId(Integer institutionId);
*/
//    @Query(value = "select v.field_id, v.field_name from schema_client1_vms.verification_form_fields_config v where v.form_id=?1", nativeQuery = true)
//    List<VerificationFormFieldsConfig> findByFormId(long formId);
    List<VerificationFormFieldsConfig> findByVerificationFormConfig_FormId(long formId);
//    List<VerificationFormFieldsConfig> findByVerificationFormConfig(long formId);


//    @Query(value = "SELECT v.* FROM schema_client1_vms.verification_form_fields_config v,verification_form_config cv where v.form_id  = cv.form_id  and v.form_id = :formId ", nativeQuery = true)
//    List<VerificationFormFieldsConfig> getByFormFields(@Param("formId") Long formId);

}
