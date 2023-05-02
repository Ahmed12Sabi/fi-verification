package ai.lentra.config;

import ai.lentra.core.config.api.tenantconfig.Config;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import static ai.lentra.config.dbConfig.ConfigKeys.DO_FORM_CLEANUP;
@Component
public class SchedularConfig implements Config {


    @JsonProperty("batch_job_execution_frequency")
    private String batchJobCronExpr;


    public String getBatchJobCronExpr() {
        return batchJobCronExpr;
    }

    public void setBatchJobCronExpr(String batchJobCronExpr) {
        this.batchJobCronExpr = batchJobCronExpr;
    }

    @Override
    public String getConfigKey() {
        return DO_FORM_CLEANUP.name();
    }
}