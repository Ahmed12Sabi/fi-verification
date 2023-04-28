package ai.lentra.controller.masterConfig;

import ai.lentra.dto.masterConfig.VerificationFormFieldsConfigDto;
import ai.lentra.dto.responses.ResponseDTO;

import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import ai.lentra.service.masterconfig.VerificationConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/master-configurations")
public class VerificationConfigController {

    private static final Logger logger =  LoggerFactory.getLogger(VerificationConfigController.class);
    @Autowired
    VerificationConfigService verificationConfigService;
    @PostMapping("")
    public ResponseEntity<ResponseDTO>  postFieldsConfig(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                                         @RequestHeader(value="token",required = false) String token,
                                                         @RequestHeader(value="user_name",required = true) String userName ,
                                                         @RequestHeader(value="institution_id",required = true) Integer institutionId,
                                                         @RequestHeader(value="role_type",required = true) String roleType ,
                                                         @RequestBody @Valid List<MasterVerificationConfiguration> verificationFormFieldsConfigDto) throws ConstraintViolationException {
        logger.info("Entered into postFieldsConfig");
        return verificationConfigService.addFields( verificationFormFieldsConfigDto);

    }

    @GetMapping("")
    public List<MasterVerificationConfiguration> getFieldsConfig(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                                                 @RequestHeader(value="token",required = false) String token,

                                                                 @RequestHeader(value="institution_id",required = true) Integer institutionId
                                                                 ) {
        logger.info("Entered into getFieldsConfig");
              return verificationConfigService.getAll( institutionId);

    }


    @GetMapping("/configurations")
    public List<VerificationFormFieldsConfig>  getFieldsConfigJoins(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                                                    @RequestHeader(value="token",required = false) String token,
                                                                    @RequestHeader(value="user_name",required = true) String userName ,
                                                                    @RequestHeader(value="institution_id",required = true) Integer institutionId,
                                                                    @RequestHeader(value="role_type",required = true) String roleType ) {
        logger.info("Entered into getFieldsConfigJoins");
        return verificationConfigService.getAllConfig( );

    }

    @PatchMapping("")
    public ResponseEntity<ResponseDTO>  patchConfig(
            @RequestHeader(value="Content-Type",required = true) String contentType  ,
            @RequestHeader(value="token",required = false) String token,
            @RequestHeader(value="user_name",required = true) String userName ,
            @RequestHeader(value="institution_id",required = true) Integer institutionId,
            @RequestHeader(value="role_type",required = true) String roleType ,
            @RequestBody @Valid VerificationFormFieldsConfigDto verificationFormFieldsConfigDto) {
        logger.info("Entered into patchConfig");
        return verificationConfigService.updateFields(verificationFormFieldsConfigDto);
    }

}