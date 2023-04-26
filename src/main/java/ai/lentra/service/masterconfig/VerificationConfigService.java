package ai.lentra.service.masterconfig;

import ai.lentra.dto.masterconfig.MasterConfigResponse;
import ai.lentra.dto.masterconfig.MasterVerificationConfigurationDto;
import ai.lentra.dto.masterconfig.VerificationFormFieldsConfigDto;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface VerificationConfigService {
    ResponseEntity<ResponseDTO> addFields(List<MasterVerificationConfiguration> verificationFormFieldsConfig) throws ConstraintViolationException;

    List<MasterVerificationConfiguration> getAll(Integer institutionId);

    ResponseEntity<ResponseDTO>  updateFields(VerificationFormFieldsConfigDto verificationFormFieldsConfigDto);

    List<MasterVerificationConfigurationDto>  getVerificationType(Integer institutionId, String productType, String profile);

    List<VerificationFormFieldsConfig> getAllConfig();
}
