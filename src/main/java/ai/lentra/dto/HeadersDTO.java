package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeadersDTO {
    private String token;
    private String username;
    private String roleType;
    private Long applicationId;
    private String applicationType;
    private String institutionId;
    private String branchName;
private String applicantType;
    private String productType;
}
