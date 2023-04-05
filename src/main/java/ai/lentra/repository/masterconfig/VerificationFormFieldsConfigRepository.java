package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface VerificationFormFieldsConfigRepository extends JpaRepository<VerificationFormFieldsConfig, Long> {


}
