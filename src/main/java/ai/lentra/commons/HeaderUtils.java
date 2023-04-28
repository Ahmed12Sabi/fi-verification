package ai.lentra.commons;

import ai.lentra.dto.headers.HeadersDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class HeaderUtils {


    public static HeadersDTO headerGenerator(String token, Long applicationId, String roleType, String userName, String institutionId, String branchName, String productType, String applicantType) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("APPLICANT-TYPE",applicantType);
        headers.set("ROLE-TYPE",roleType);
        headers.set("USER-NAME",userName);
        headers.set("Branch-NAME",branchName);
        headers.set("PRODUCT-TYPE",productType);
        headers.set("APPLICATION-ID", String.valueOf(applicationId));
        headers.set("INSTITUTION-ID",institutionId);
/*
        todo :
         need to change http headers with headerDTO */
        HeadersDTO headersDTO = new HeadersDTO();
        headersDTO.setToken(token);
        headersDTO.setApplicationId(applicationId);
        headersDTO.setRoleType(roleType);
        headersDTO.setUsername(userName);
        headersDTO.setInstitutionId(institutionId);
        headersDTO.setBranchName(branchName);
        headersDTO.setProductType(productType);
        headersDTO.setApplicantType(applicantType);
        return headersDTO;
    }
}
