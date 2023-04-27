package ai.lentra.controller.verificationType;

import ai.lentra.dto.masterConfig.MasterVerificationConfigurationDto;
import ai.lentra.service.masterconfig.ProductsConfigService;
import ai.lentra.service.masterconfig.VerificationConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Validated
@RequestMapping(value = "/verification_types")
public class VerificationTypeController {
    @Autowired
    ProductsConfigService productService;
    @Autowired
    VerificationConfigService configService;
  /*  @GetMapping("")
    public String heloo(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                        @RequestHeader(value="token",required = false) String token,
                        @RequestHeader(value="user_name",required = true) String userName ,
                        @RequestHeader(value="institution_id",required = true) Integer institutionId,
                        @RequestHeader(value="role_type",required = true) String roleType ,
                        @RequestHeader(value="application_id",required = true) Integer applicationId ,
                        @RequestHeader(value="application_type",required = true) String applicationType ,
                        @RequestHeader(value="branch_name",required = false) String branchName ,

                        @PathVariable(value = "pro") String profile,
                        @PathVariable String productType){
        return "hrloo";
    }
*/
    @GetMapping(value = "/{profile_name}/{product_type}")
    public List<MasterVerificationConfigurationDto> getVerificationType(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                                           @RequestHeader(value="token",required = false) String token,
                                                           @RequestHeader(value="user_name",required = true) String userName ,
                                                           @RequestHeader(value="institution_id",required = true) Integer institutionId,
                                                           @RequestHeader(value="role_type",required = true) String roleType ,
                                                           @RequestHeader(value="application_id",required = true) Integer applicationId ,
                                                           @RequestHeader(value="application_type",required = true) String applicationType ,
                                                           @RequestHeader(value="branch_name",required = false) String branchName ,

                                                           @PathVariable(value = "profile_name") String profile,
                                                           @PathVariable(value="product_type") String productType) {

//        String profileName = productService.getProductDetails(institutionId,productType,profile);
        return configService.getVerificationType(institutionId,productType,profile);
    }



}
