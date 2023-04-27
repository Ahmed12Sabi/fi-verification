package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.dto.masterConfig.VerificationFormFieldResponse;
import ai.lentra.modal.masterconfig.VerificationFormFieldMaster;
import ai.lentra.repository.masterconfig.VerificationFormFieldMasterRepository;
import ai.lentra.service.masterconfig.VerificationFormFieldsMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VerificationFormFieldsMasterServiceImpl implements VerificationFormFieldsMasterService {
   @Autowired
   VerificationFormFieldMasterRepository repository;
    @Override
    public List<VerificationFormFieldResponse> getAllMasters() {
        List<VerificationFormFieldMaster> master = repository.findAllMasters();
        List<VerificationFormFieldResponse> responseList = new ArrayList<>();
        master.stream().forEach((k) -> {
            VerificationFormFieldResponse response = new VerificationFormFieldResponse();
            response.setFieldId(k.getFieldId());
            response.setFieldName(k.getFieldName());
            response.setHidden(k.isHidden());
            response.setRequired(k.isRequired());
            response.setStatus(k.isStatus());
            response.setvType(k.getFieldType());
            response.setFormId(k.getVerificationFormMaster().getFormId());
            response.setFormName(k.getVerificationFormMaster().getFormName());
            responseList.add(response);
        });
return responseList;

    }

    @Override
    public VerificationFormFieldMaster save(VerificationFormFieldMaster verificationFormFieldMaster) {
        return repository.save(verificationFormFieldMaster);
    }
}
