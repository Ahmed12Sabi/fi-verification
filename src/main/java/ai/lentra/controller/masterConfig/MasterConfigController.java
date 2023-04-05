package ai.lentra.controller.masterConfig;

import ai.lentra.dto.masterconfig.VerificationFormFieldResponse;
import ai.lentra.modal.masterconfig.VerificationFormFieldMaster;
import ai.lentra.service.masterconfig.VerificationFormFieldsMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping(value = "/config")
public class MasterConfigController {

@Autowired
VerificationFormFieldsMasterService verificationFormFieldsMasterService;
    @GetMapping("/verification_master_form_fields_config")
    public List<VerificationFormFieldResponse> getMasterFields() {

        return verificationFormFieldsMasterService.getAllMasters();
    }
@PostMapping("/post")
public VerificationFormFieldMaster post(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                        @RequestHeader(value="token",required = false) String token,
                                        @RequestHeader(value="user_name",required = true) String userName ,
                                        @RequestHeader(value="institution_id",required = true) Integer institutionId,
                                        @RequestHeader(value="role_type",required = true) String roleType , @RequestBody @Valid VerificationFormFieldMaster verificationFormFieldMaster) {

    return verificationFormFieldsMasterService.save(verificationFormFieldMaster);
}
}
