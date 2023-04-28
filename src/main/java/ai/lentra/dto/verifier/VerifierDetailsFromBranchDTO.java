
package ai.lentra.dto.verifier;

import com.fasterxml.jackson.annotation.JsonInclude;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)

public class VerifierDetailsFromBranchDTO {
    private String branchName;
    private  List<String> userNames = new ArrayList<>();

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(List<String> userNames) {
        this.userNames = userNames;
    }
}
