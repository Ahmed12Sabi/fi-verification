package ai.lentra.service.masterconfig;

import ai.lentra.dto.masterconfig.VerificationFormFieldResponse;
import ai.lentra.modal.masterconfig.VerificationFormFieldMaster;

import java.util.List;

public interface VerificationFormFieldsMasterService {
    List<VerificationFormFieldResponse> getAllMasters();

    VerificationFormFieldMaster save( VerificationFormFieldMaster verificationFormFieldMaster);
}
