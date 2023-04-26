package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.VerificationFormFieldMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerificationFormFieldMasterRepository extends JpaRepository<VerificationFormFieldMaster, Long> {
  @Query(value = "SELECT * FROM public.verification_form_field_master", nativeQuery = true)
    List<VerificationFormFieldMaster> findAllMasters();
}
