package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.dto.masterConfig.VerificationFormFieldResponse;
import ai.lentra.modal.masterconfig.OfflinePdfDataMapping;
import ai.lentra.modal.masterconfig.VerificationFormFieldMaster;
import ai.lentra.repository.masterconfig.OfflinePdfDataRepository;
import ai.lentra.repository.masterconfig.VerificationFormFieldMasterRepository;
import ai.lentra.service.masterconfig.VerificationFormFieldsMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class VerificationFormFieldsMasterServiceImpl implements VerificationFormFieldsMasterService {
   @Autowired
   VerificationFormFieldMasterRepository repository;

    @Autowired
    OfflinePdfDataRepository offlinePdfDataRepository;
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
    public  VerificationFormFieldMaster save(VerificationFormFieldMaster verificationFormFieldMaster) {
        OfflinePdfDataMapping offlinePdfDataMapping=new OfflinePdfDataMapping();
        offlinePdfDataMapping.setField_id(verificationFormFieldMaster.getFieldId());
        offlinePdfDataMapping.setField_name(verificationFormFieldMaster.getFieldName());
        offlinePdfDataMapping.setField_table(verificationFormFieldMaster.getVerificationFormMaster().getFormName());
        //offlinePdfDataMapping.setInstitute_name(verificationFormFieldMaster.i);
        offlinePdfDataRepository.save(offlinePdfDataMapping);
        return repository.save(verificationFormFieldMaster);
    }
}
