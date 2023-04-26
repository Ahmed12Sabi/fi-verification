package ai.lentra.controller.masterConfig;

import ai.lentra.dto.masterconfig.MasterConfigResponse;
import ai.lentra.dto.masterconfig.VerificationFormFieldsConfigDto;
import ai.lentra.dto.responses.ResponseDTO;

import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import ai.lentra.service.masterconfig.VerificationConfigService;
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

    @Autowired
    VerificationConfigService verificationConfigService;
    @PostMapping("")
    public ResponseEntity<ResponseDTO>  postFieldsConfig(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                                         @RequestHeader(value="token",required = false) String token,
                                                         @RequestHeader(value="user_name",required = true) String userName ,
                                                         @RequestHeader(value="institution_id",required = true) Integer institutionId,
                                                         @RequestHeader(value="role_type",required = true) String roleType ,
                                                         @RequestBody @Valid List<MasterVerificationConfiguration> verificationFormFieldsConfigDto) throws ConstraintViolationException {
        return verificationConfigService.addFields( verificationFormFieldsConfigDto);

    }

    @GetMapping("")
    public List<MasterVerificationConfiguration> getFieldsConfig(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                                                 @RequestHeader(value="token",required = false) String token,

                                                                 @RequestHeader(value="institution_id",required = true) Integer institutionId
                                                                 ) {

              return verificationConfigService.getAll( institutionId);

    }


    @GetMapping("/configurations")
    public List<VerificationFormFieldsConfig>  getFieldsConfigJoins(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                                                    @RequestHeader(value="token",required = false) String token,
                                                                    @RequestHeader(value="user_name",required = true) String userName ,
                                                                    @RequestHeader(value="institution_id",required = true) Integer institutionId,
                                                                    @RequestHeader(value="role_type",required = true) String roleType ) {

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
        return verificationConfigService.updateFields(verificationFormFieldsConfigDto);
    }

}