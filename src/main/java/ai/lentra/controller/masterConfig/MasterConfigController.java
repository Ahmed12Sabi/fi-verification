package ai.lentra.controller.masterConfig;

import ai.lentra.controller.configuration.scoring.ScoreConfigController;
import ai.lentra.dto.masterConfig.VerificationFormFieldResponse;
import ai.lentra.modal.masterconfig.VerificationFormFieldMaster;
import ai.lentra.service.masterconfig.VerificationFormFieldsMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/verification-master-form-fields-configs")
public class MasterConfigController {
    private static final Logger logger =  LoggerFactory.getLogger(MasterConfigController.class);

    @Autowired
    VerificationFormFieldsMasterService verificationFormFieldsMasterService;
    @GetMapping("")
    public List<VerificationFormFieldResponse> getMasterFields() {
        logger.info("Entered into getMasterFields ");
        return verificationFormFieldsMasterService.getAllMasters();
    }
    @PostMapping("")
    public VerificationFormFieldMaster post(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                            @RequestHeader(value="token",required = false) String token,
                                            @RequestHeader(value="user_name",required = true) String userName ,
                                            @RequestHeader(value="institution_id",required = true) Integer institutionId,
                                            @RequestHeader(value="role_type",required = true) String roleType ,
                                            @RequestBody @Valid VerificationFormFieldMaster verificationFormFieldMaster) {
        logger.info("Entered into post ");
        return verificationFormFieldsMasterService.save(verificationFormFieldMaster);
    }
}
