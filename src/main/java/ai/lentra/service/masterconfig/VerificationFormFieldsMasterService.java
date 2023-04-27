package ai.lentra.service.masterconfig;

import ai.lentra.dto.masterConfig.VerificationFormFieldResponse;
import ai.lentra.modal.masterconfig.VerificationFormFieldMaster;

import java.util.List;

public interface VerificationFormFieldsMasterService {
    List<VerificationFormFieldResponse> getAllMasters();

    VerificationFormFieldMaster save( VerificationFormFieldMaster verificationFormFieldMaster);
}
