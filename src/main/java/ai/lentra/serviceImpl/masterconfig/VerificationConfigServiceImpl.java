package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.masterConfig.MasterVerificationConfigurationDto;
import ai.lentra.dto.masterConfig.VerificationFormFieldsConfigDto;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import ai.lentra.modal.masterconfig.VerificationConfig;
import ai.lentra.modal.masterconfig.VerificationFormConfig;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import ai.lentra.repository.masterconfig.MasterVerificationConfigurationRepository;
import ai.lentra.repository.masterconfig.VerificaionConfigRepository;
import ai.lentra.repository.masterconfig.VerificationFormConfigRepository;
import ai.lentra.repository.masterconfig.VerificationFormFieldsConfigRepository;
import ai.lentra.service.masterconfig.VerificationConfigService;
import ai.lentra.service.verification_type.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VerificationConfigServiceImpl implements VerificationConfigService {
    @Autowired
    private JsonUtils1 jsonUtils;
    @Autowired
    VerificationFormFieldsConfigRepository repository;

    @Autowired
    VerificaionConfigRepository verificaionConfigRepository;

    @Autowired
    VerificationFormConfigRepository verificationFormConfigRepository;

    @Autowired
    VerificationFormFieldsConfigRepository verificationFormFieldsConfigRepository;
    @Autowired
    MasterVerificationConfigurationRepository masterRepository;

    //    @Autowired
//    ConfigurationRepository configurationRepository;
    @Autowired
    ProductService productService;

   /* @Override
    public ResponseEntity<ResponseDTO> addFields(List<VerificationFormFieldsConfigDto> verificationFormFieldsConfigDto) throws ConstraintViolationException {
       List<VerificationFormFieldsConfig> verificationFormFieldsConfig = createConfigObject(verificationFormFieldsConfigDto);
        try {
            repository.saveAll(verificationFormFieldsConfig);

            return ResponseEntity.status(HttpStatus.CREATED).body(getSuccessResponse(201, "Verification Config form fields has been added successfully ", "CREATED", verificationFormFieldsConfig));
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(500, "error while adding config form fields", "ERROR"));
        }
    }
*/
  /*  private List<VerificationFormFieldsConfig> createConfigObject(List<VerificationFormFieldsConfigDto> verificationFormFieldsConfigDtoList) {
//        List<VerificationFormFieldsConfig> verificationFormFieldsConfigList = verificationFormFieldsConfigDtoList.stream().map(
//                add -> jsonUtils.mapper().convertValue(add, VerificationFormFieldsConfig.class)).collect(Collectors.toList());

        List<VerificationFormFieldsConfig> verificationFormFieldsConfigList = new ArrayList<>();
        for (VerificationFormFieldsConfigDto verificationFormFieldsConfigDto:verificationFormFieldsConfigDtoList
             ) {
            VerificationFormFieldsConfig verificationFormFieldsConfig = new VerificationFormFieldsConfig();
            MasterVerificationConfiguration master = new MasterVerificationConfiguration();
            VerificationFormConfig verificationFormConfig = new VerificationFormConfig();
            VerificationConfig verificationConfig = new VerificationConfig();
            //Set Matser Data
            master.setId(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getId());
            if (verificationFormFieldsConfigDto.getMasterVerificationConfiguration().isRetrigerVerification()) {
                master.setRetrigerVerification(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().isRetrigerVerification());
            }
            master.setMultiVerificationAllowed(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getMultiVerificationAllowed());
            master.setProfileName(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getProfileName());
            master.setUserType(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getUserType());
            master.setProfileId(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getProfileId());
            master.setvType(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getVType());
            master.setProductLevelLogic(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getProductLevelLogic());
            master.seteSign(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().isESign());
            master.setProfileId(verificationFormFieldsConfigDto.getMasterVerificationConfiguration().getProfileId());

            //Set Verification Config Data
            verificationConfig.setvId(verificationFormFieldsConfigDto.getVerificationFormConfig().getVerificationConfig().getVId());
            verificationConfig.setvDescription(verificationFormFieldsConfigDto.getVerificationFormConfig().getVerificationConfig().getVDescription());
            verificationConfig.setvType(verificationFormFieldsConfigDto.getVerificationFormConfig().getVerificationConfig().getVType());
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
            verificationFormFieldsConfigList.add(verificationFormFieldsConfig);
//        verificationFormFieldsConfig.getVerificationFormConfig().setVerificationConfig(verificationConfig);

            verificationFormFieldsConfig.setFieldId(verificationFormFieldsConfigDto.getFieldId());
            verificationFormFieldsConfig.setFieldName(verificationFormFieldsConfigDto.getFieldName());
            verificationFormFieldsConfig.setFieldType(verificationFormFieldsConfigDto.getFieldType());
            verificationFormFieldsConfig.setHidden(verificationFormFieldsConfigDto.isHidden());
            verificationFormFieldsConfig.setLookUp(verificationFormFieldsConfig.isLookUp());
            verificationFormFieldsConfig.setLookTable(verificationFormFieldsConfigDto.getLookTable());
            verificationFormFieldsConfig.setScoring(verificationFormFieldsConfig.isScoring());
            verificationFormFieldsConfig.setDataAutoPopulation(verificationFormFieldsConfig.isDataAutoPopulation());
            verificationFormFieldsConfig.setStatus(verificationFormFieldsConfigDto.isStatus());
            verificationFormFieldsConfig.setMaxLength(verificationFormFieldsConfigDto.getMaxLength());
            verificationFormFieldsConfig.setMaxRange(verificationFormFieldsConfigDto.getMaxRange());
            verificationFormFieldsConfig.setMinLength(verificationFormFieldsConfigDto.getMinLength());
            verificationFormFieldsConfig.setMinRange(verificationFormFieldsConfigDto.getMinRange());
            verificationFormFieldsConfig.setScoringName(verificationFormFieldsConfigDto.getScoringName());
            verificationFormFieldsConfig.setRequired(verificationFormFieldsConfigDto.isRequired());
            verificationFormFieldsConfigList.add(verificationFormFieldsConfig);
        }
            return verificationFormFieldsConfigList;
    }*/




    /*public List<MasterConfigResponse> getAll(Integer institutionId) {
        List<VerificationFormFieldsConfig> formList = repository.findByInstistuteId(institutionId);
        List<MasterConfigResponse> verificationList = new ArrayList<>();
        for (VerificationFormFieldsConfig field : formList
        ) {
            MasterConfigResponse masterConfigResponse = new MasterConfigResponse();
            masterConfigResponse.setFormId(field.getFieldId());
            masterConfigResponse.setInstitutionId(field.getMasterVerificationConfiguration().getInstitutionId());
            masterConfigResponse.setFieldName(field.getFieldName());
            masterConfigResponse.setFieldType(field.getFieldType());
            masterConfigResponse.setFormDescription(field.getVerificationFormConfig().getFormDescription());
            masterConfigResponse.setRequired(field.isRequired());
            masterConfigResponse.setStatus(field.isStatus());
            masterConfigResponse.setRetrigerVerification(field.getMasterVerificationConfiguration().isRetrigerVerification());
            masterConfigResponse.setVId(field.getVerificationFormConfig().getVerificationConfig().getvId());
            masterConfigResponse.setProfileId(field.getMasterVerificationConfiguration().getProfileId());
            masterConfigResponse.setSubProfileName(field.getMasterVerificationConfiguration().getSubProfileName());
            masterConfigResponse.setVDescription(field.getVerificationFormConfig().getVerificationConfig().getvDescription());
            verificationList.add(masterConfigResponse);
        }
        return verificationList;
    }*/

    @Override
    public ResponseEntity<ResponseDTO> addFields(List<MasterVerificationConfiguration> masterVerificationConfigurationList) throws ConstraintViolationException {

     List<VerificationConfig> verifictionConfigList =  new ArrayList<>();
        List<VerificationFormConfig> VerificationFormConfigList =  new ArrayList<>();
        List<VerificationFormFieldsConfig> fieldsConfigList =  new ArrayList<>();

        masterVerificationConfigurationList.stream().forEach(report->
        {
            verifictionConfigList.addAll(report.getVerificationConfig()) ;
            verifictionConfigList.stream().forEach(config->
                    VerificationFormConfigList.addAll(config.getVerificationFormConfig()));
            VerificationFormConfigList.stream().forEach(field->
                    fieldsConfigList.addAll(field.getVerificationFormFieldsConfig()));
            verificationFormFieldsConfigRepository.saveAll(fieldsConfigList);

            verificationFormConfigRepository.saveAll(VerificationFormConfigList);
            verificaionConfigRepository.saveAll(verifictionConfigList);


        } );
       /* verifictionConfigList.stream().forEach(config->

                VerificationFormConfigList.addAll( verificationFormConfigRepository.saveAll(config.getVerificationFormConfig()))
        );
        VerificationFormConfigList.stream().forEach(config->

                fieldsConfigList.addAll( verificationFormFieldsConfigRepository.saveAll(config.getVerificationFormFieldsConfig()))
        );
*/
        masterVerificationConfigurationList = masterRepository.saveAll(masterVerificationConfigurationList);



        ResponseDTO responseDTO = new ResponseDTO();
         responseDTO.setMessage("Data added successfully");
         responseDTO.setCode("201");
         responseDTO.setStatus("Created");
         responseDTO.setData(masterVerificationConfigurationList);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Override
    public List<MasterVerificationConfiguration> getAll(Integer institutionId) {
        List<MasterVerificationConfiguration> masterVerificationConfigurationList = masterRepository.finByInstitutionId(institutionId);

        masterVerificationConfigurationList.stream().forEach(c->
                c.setVerificationConfig(verificaionConfigRepository.findByMasterId(c.getId()))
        );
        List<VerificationConfig> verificationConfigList =  new ArrayList<>();
        masterVerificationConfigurationList.stream().forEach(
                m->
                        verificationConfigList.addAll( m.getVerificationConfig().stream().collect(Collectors.toList()))
        );

        verificationConfigList.stream().forEach(v->
                v.setVerificationFormConfig(verificationFormConfigRepository.getByVId(v.getvId()))
        );
        verificationConfigList.stream().forEach(v->v.getVerificationFormConfig().stream().forEach(f->
                f.setVerificationFormFieldsConfig(verificationFormFieldsConfigRepository.findByFormId(f.getFormId()))
                ));


        return masterVerificationConfigurationList;
    }

    @Override
    public ResponseEntity<ResponseDTO> updateFields(VerificationFormFieldsConfigDto verificationFormFieldsConfigDto) {
        return null;
    }

    @Override
    public List<MasterVerificationConfigurationDto> getVerificationType(Integer institutionId, String productType, String profile) {
        return null;
    }

   /* public ResponseEntity<ResponseDTO> updateFields(VerificationFormFieldsConfigDto verificationFormFieldsConfigDto) {
        VerificationFormFieldsConfig verificationFormFieldsConfigNew = jsonUtils.mapper().convertValue(verificationFormFieldsConfigDto, VerificationFormFieldsConfig.class);
//        VerificationFormFieldsConfig verificationFormFieldsConfig1 = repository.getById(verificationFormFieldsConfigNew.getFieldId());

        Optional<VerificationFormFieldsConfig> optionalApplicant = repository.findById(verificationFormFieldsConfigNew.getFieldId());
        if (!optionalApplicant.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404, "Details not found for field " + verificationFormFieldsConfigNew.getFieldId(), "ERROR"));
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
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400, "Error while updating a field config details ", "ERROR"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(getSuccessResponse(200, "Field Config Details updated successfully", "SUCCESS", verificationFormFieldsConfig1));


    }
*/
    /*@Override
    public List<MasterVerificationConfigurationDto> getVerificationType(Integer institutionId, String productType, String profile) {
        String profileName = productService.getProductDetails(institutionId, productType, profile);
        List<MasterVerificationConfiguration> master = masterRepository.findByProfile(profileName);

        List<MasterVerificationConfigurationDto> masterDto =

                master.stream()
                        .map(add -> jsonUtils.mapper().convertValue(add, MasterVerificationConfigurationDto.class)).collect(Collectors.toList());

        return masterDto;
//        return ResponseEntity.status(HttpStatus.OK).body(getSuccessResponse(200,"Master Verification Config Details loaded successfully","SUCCESS",masterDto ));
    }*/

    @Override
    public List<VerificationFormFieldsConfig> getAllConfig() {
        List<VerificationFormFieldsConfig> list = repository.findCrossJoin();
//        Configuration config = new Configuration()
        return list;
    }

}