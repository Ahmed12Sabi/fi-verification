package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.masterconfig.MasterVerificationConfigurationDto;
import ai.lentra.dto.masterconfig.VerificationFormFieldsConfigDto;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import ai.lentra.modal.masterconfig.VerificationConfig;
import ai.lentra.modal.masterconfig.VerificationFormConfig;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import ai.lentra.repository.masterconfig.MasterVerificationConfigurationRepository;
import ai.lentra.repository.masterconfig.VerificationFormFieldsConfigRepository;
import ai.lentra.service.masterconfig.VerificationConfigService;
import ai.lentra.service.verification_type.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ai.lentra.commons.ResponeGen.getResponse;
import static ai.lentra.commons.ResponeGen.getSuccessResponse;

@Service
@Transactional
public class VerificationConfigServiceImpl implements VerificationConfigService {
    @Autowired
    private JsonUtils1 jsonUtils;
    @Autowired
    VerificationFormFieldsConfigRepository repository;
    @Autowired
    MasterVerificationConfigurationRepository masterRepository;

//    @Autowired
//    ConfigurationRepository configurationRepository;
    @Autowired
    ProductService productService;

    @Override
    public ResponseEntity<ResponseDTO>  addFields(VerificationFormFieldsConfigDto verificationFormFieldsConfigDto) throws ConstraintViolationException {
        VerificationFormFieldsConfig verificationFormFieldsConfig = createConfigObject(verificationFormFieldsConfigDto);
    try{
            repository.save(verificationFormFieldsConfig);

            return ResponseEntity.status(HttpStatus.CREATED).body(getSuccessResponse(201,"Verification Config form fields has been added successfully ","CREATED",verificationFormFieldsConfig ));
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(500,"error while adding config form fields","ERROR"));
        }
    }

    private VerificationFormFieldsConfig createConfigObject(VerificationFormFieldsConfigDto verificationFormFieldsConfigDto) {
        VerificationFormFieldsConfig verificationFormFieldsConfig = jsonUtils.mapper().convertValue(verificationFormFieldsConfigDto, VerificationFormFieldsConfig.class);
        MasterVerificationConfiguration master = new MasterVerificationConfiguration();
        VerificationFormConfig verificationFormConfig = new VerificationFormConfig();
        VerificationConfig verificationConfig = new VerificationConfig();
        //Set Matser Data
        master.setId(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getId());
        if(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().isRetrigerVerification()) {
            master.setRetrigerVerification(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().isRetrigerVerification());
        }
        master.setMultiVerificationAllowed(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getMultiVerificationAllowed());
        master.setProfileName(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getProfileName());
        master.setUserType(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getUserType());
        master.setProfileId(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getProfileId());
        master.setVType(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getVType());
        master.setProductLevelLogic(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getProductLevelLogic());

        //Set Verification Config Data
        verificationConfig.setVId(verificationFormFieldsConfigDto.getVerificationFormConfig().getVerificationConfig().getVId());
        verificationConfig.setVDescription(verificationFormFieldsConfigDto.getVerificationFormConfig().getVerificationConfig().getVDescription());
        verificationConfig.setVType(verificationFormFieldsConfigDto.getVerificationFormConfig().getVerificationConfig().getVType());
        verificationConfig.setMasterVerificationConfiguration(master);

        //Set Verification Form Config Data
       // verificationFormConfig.setFormDescription(verificationFormFieldsConfigDto.getVerificationFormConfig().getFormDescription());
       // verificationFormConfig.setFormName(verificationFormFieldsConfigDto.getVerificationFormConfig().getFormName());
        verificationFormConfig.setFormId(verificationFormFieldsConfigDto.getVerificationFormConfig().getFormId());
      //  verificationFormConfig.setMasterVerificationConfiguration(master);
        verificationFormConfig.setVerificationConfig(verificationConfig);
        verificationFormConfig.setFormName(verificationFormFieldsConfigDto.getVerificationFormConfig().getFormName());
        verificationFormConfig.setFormDescription(verificationFormFieldsConfigDto.getVerificationFormConfig().getFormDescription());

        verificationFormFieldsConfig.setVerificationFormConfig(verificationFormConfig);
        verificationFormFieldsConfig.setMasterVerificationConfiguration(master);

//        verificationFormFieldsConfig.getVerificationFormConfig().setVerificationConfig(verificationConfig);
        return verificationFormFieldsConfig;
    }

    @Override
    public List<VerificationFormFieldsConfigDto> getAll() {
        List<VerificationFormFieldsConfig> formList = repository.findAll();


        List<VerificationFormFieldsConfigDto> verificationList =

                formList.stream()
                        .map(add -> jsonUtils.mapper().convertValue(add, VerificationFormFieldsConfigDto.class)).collect(Collectors.toList());

        return verificationList;
    }

    @Override
    public ResponseEntity<ResponseDTO>  updateFields(VerificationFormFieldsConfigDto verificationFormFieldsConfigDto) {
        VerificationFormFieldsConfig verificationFormFieldsConfigNew = jsonUtils.mapper().convertValue(verificationFormFieldsConfigDto, VerificationFormFieldsConfig.class);
//        VerificationFormFieldsConfig verificationFormFieldsConfig1 = repository.getById(verificationFormFieldsConfigNew.getFieldId());

        Optional<VerificationFormFieldsConfig> optionalApplicant = repository.findById(verificationFormFieldsConfigNew.getFieldId());
        if (!optionalApplicant.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404, "Details not found for field "+verificationFormFieldsConfigNew.getFieldId(),"ERROR"));
        }
        VerificationFormFieldsConfig verificationFormFieldsConfig1 = optionalApplicant.get();

        verificationFormFieldsConfig1.setFieldId(verificationFormFieldsConfigNew.getFieldId());
        verificationFormFieldsConfig1.setFieldName(verificationFormFieldsConfigNew.getFieldName());
        verificationFormFieldsConfig1.setFieldType(verificationFormFieldsConfigNew.getFieldType());
        verificationFormFieldsConfig1.setHidden(verificationFormFieldsConfigNew.isHidden());
        verificationFormFieldsConfig1.setScoringName(verificationFormFieldsConfigNew.getScoringName());
        verificationFormFieldsConfig1.setScoring(verificationFormFieldsConfigNew.isScoring());
        verificationFormFieldsConfig1.setStatus(verificationFormFieldsConfigNew.isStatus());
        verificationFormFieldsConfig1.setRequired(verificationFormFieldsConfigNew.isRequired());
        verificationFormFieldsConfig1.setLookUp(verificationFormFieldsConfigNew.isLookUp());
        verificationFormFieldsConfig1.setHidden(verificationFormFieldsConfigNew.isHidden());
        verificationFormFieldsConfig1.setLookTable(verificationFormFieldsConfigNew.getLookTable());
        verificationFormFieldsConfig1.setDataAutoPopulation(verificationFormFieldsConfigNew.isDataAutoPopulation());
        verificationFormFieldsConfig1.setMasterVerificationConfiguration(verificationFormFieldsConfigNew.getMasterVerificationConfiguration());
        verificationFormFieldsConfig1.setVerificationFormConfig(verificationFormFieldsConfigNew.getVerificationFormConfig());
        MasterVerificationConfiguration masterVerificationConfiguration = jsonUtils.mapper().convertValue(verificationFormFieldsConfigDto.getMasterVerificationConfiguration(), MasterVerificationConfiguration.class);
        VerificationFormConfig verificationFormConfig = jsonUtils.mapper().convertValue(verificationFormFieldsConfigDto.getVerificationFormConfig(), VerificationFormConfig.class);
        VerificationConfig verificationConfig = jsonUtils.mapper().convertValue(verificationFormFieldsConfigDto.getVerificationFormConfig().getVerificationConfig(), VerificationConfig.class);
        verificationFormFieldsConfig1.setMasterVerificationConfiguration(masterVerificationConfiguration);
        verificationFormFieldsConfig1.setVerificationFormConfig(verificationFormConfig);
      //  verificationFormFieldsConfig1.getVerificationFormConfig().setVerificationConfig(verificationConfig);
        try {
            repository.save(verificationFormFieldsConfig1);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,"Error while updating a field config details ","ERROR"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(getSuccessResponse(200,"Field Config Details updated successfully","SUCCESS",verificationFormFieldsConfig1 ));


    }

    @Override
    public List<MasterVerificationConfigurationDto>   getVerificationType(Integer institutionId, String productType, String profile) {
        String profileName = productService.getProductDetails(institutionId,productType,profile);
       List<MasterVerificationConfiguration> master = masterRepository.findByProfile(profileName);

       List< MasterVerificationConfigurationDto> masterDto =

               master.stream()
                       .map(add -> jsonUtils.mapper().convertValue(add, MasterVerificationConfigurationDto.class)).collect(Collectors.toList());

                return masterDto;
//        return ResponseEntity.status(HttpStatus.OK).body(getSuccessResponse(200,"Master Verification Config Details loaded successfully","SUCCESS",masterDto ));
    }

    @Override
    public List<VerificationFormFieldsConfig> getAllConfig() {
List<VerificationFormFieldsConfig> list= repository.findCrossJoin();
//        Configuration config = new Configuration()
        return list;
    }

}