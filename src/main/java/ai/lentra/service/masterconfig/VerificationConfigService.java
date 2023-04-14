package ai.lentra.service.masterconfig;

import ai.lentra.dto.masterconfig.MasterVerificationConfigurationDto;
import ai.lentra.dto.masterconfig.VerificationFormFieldsConfigDto;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface VerificationConfigService {
    ResponseEntity<ResponseDTO> addFields(VerificationFormFieldsConfigDto verificationFormFieldsConfig) throws ConstraintViolationException;

    List<VerificationFormFieldsConfigDto> getAll();

    ResponseEntity<ResponseDTO>  updateFields(VerificationFormFieldsConfigDto verificationFormFieldsConfigDto);

    List<MasterVerificationConfigurationDto>  getVerificationType(Integer institutionId, String productType, String profile);

    List<VerificationFormFieldsConfig> getAllConfig();
}
