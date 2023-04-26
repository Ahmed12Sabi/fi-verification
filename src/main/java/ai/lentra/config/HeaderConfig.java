package ai.lentra.config;

import ai.lentra.dto.HeadersDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configuration.properties")
public class HeaderConfig {


    public static HeadersDTO headerGenerator(String token, Long applicationId, String roleType, String userName, String institutionId, String branchName, String productType, String applicantType) {
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
    @Value("${spring.configuration.scheduler}")
    public static String scheduler;
}
