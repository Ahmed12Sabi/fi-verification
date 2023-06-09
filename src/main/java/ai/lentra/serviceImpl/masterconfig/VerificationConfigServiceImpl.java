package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.masterConfig.MasterVerificationConfigurationDto;
import ai.lentra.dto.masterConfig.VerificationFormFieldsConfigDto;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.*;
import ai.lentra.repository.masterconfig.*;
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

    @Autowired
    ProductConfigRepository productConfigRepository;

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

        List<MasterVerificationConfiguration>masterVerificationConfigurationList1 = masterRepository.saveAll(masterVerificationConfigurationList);

      /*  masterVerificationConfigurationList.stream().forEach(report ->
        {
            report.getVerificationConfig().stream().forEach(config -> {
                config.setMasterVerificationConfiguration(report);

                config.getVerificationFormConfig().stream().forEach(form->{
                    form.setVerificationConfig(config);
                    form.getVerificationFormFieldsConfig().stream().forEach(field->{
                        field.setVerificationFormConfig(form);
                    });
                    verificationFormFieldsConfigRepository.saveAll(form.getVerificationFormFieldsConfig());

                });
                verificationFormConfigRepository.saveAll(config.getVerificationFormConfig());

            });


            verificaionConfigRepository.saveAll(report.getVerificationConfig());
            ProductConfigEntity product = productConfigRepository.getByInstituteIdAndProfileName(report.getInstituteId(), report.getProfileName());
           if(product!=null) {
               report.setProductType(product.getProductType());
           }
        });*/

        masterVerificationConfigurationList = masterRepository.saveAll(masterVerificationConfigurationList);


        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Data added successfully");
        responseDTO.setCode("201");
        responseDTO.setStatus("Created");
        responseDTO.setData(masterVerificationConfigurationList);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Override
    public ResponseEntity<ResponseDTO> getAll(Integer institutionId) {
        List<MasterVerificationConfiguration> masterVerificationConfigurationList = masterRepository.findByInstituteId(String.valueOf(institutionId));
        List<VerificationConfig> verificationConfigList = new ArrayList<>();
        masterVerificationConfigurationList.stream().forEach(
                m -> {
                    ProductConfigEntity product = productConfigRepository.getByInstituteIdAndProfileName(m.getInstituteId(), m.getProfileName());
                 if(product!=null) {
                     m.setProductType(product.getProductType());
                 }
                 verificationConfigList.addAll(verificaionConfigRepository.findByMasterVerificationConfiguration_Id(m.getId()));
                    m.setVerificationConfig(verificationConfigList);

                });
        List<VerificationFormConfig> verificationFormConfigList = new ArrayList<>();

        verificationConfigList.stream().forEach(v -> {
            verificationFormConfigList.addAll(verificationFormConfigRepository.findByVerificationConfig_vId(v.getvId()));
            v.setVerificationFormConfig(verificationFormConfigList);

        });
        List<VerificationFormFieldsConfig> verificationFormFieldsConfigList = new ArrayList<>();

        verificationConfigList.stream().forEach(v ->
                v.getVerificationFormConfig().stream().forEach(f ->
                        {
                            verificationFormFieldsConfigList.addAll(verificationFormFieldsConfigRepository.findByVerificationFormConfig_FormId(f.getFormId()));
                            f.setVerificationFormFieldsConfig(verificationFormFieldsConfigList);
                        }
                ));

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setCode("200");
        responseDTO.setStatus("OK");
        responseDTO.setData(masterVerificationConfigurationList);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//        return masterVerificationConfigurationList;
    }

    @Override
    public ResponseEntity<ResponseDTO> updateFields(VerificationFormFieldsConfigDto verificationFormFieldsConfigDto) {
        return null;
    }

    @Override
    public List<MasterVerificationConfigurationDto> getVerificationType(Integer institutionId, String productType, String profile) {
        return null;
    }

    @Override
    public List<VerificationFormFieldsConfig> getAllConfig() {
        List<VerificationFormFieldsConfig> list = new ArrayList<>();
                //repository.findCrossJoin();
//        Configuration config = new Configuration()
        return list;
    }

}