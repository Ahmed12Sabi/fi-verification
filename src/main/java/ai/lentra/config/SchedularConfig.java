package ai.lentra.config;

import ai.lentra.core.config.api.tenantconfig.Config;
import com.fasterxml.jackson.annotation.JsonProperty;

import static ai.lentra.config.dbConfig.ConfigKeys.DO_FORM_CLEANUP;

public class SchedularConfig implements Config {


    @JsonProperty("batch_job_execution_frequency")
    private String batchJobCronExpr;

  /*  public Boolean getAutoClose() {
        return autoClose;
    }

    public void setAutoClose(Boolean autoClose) {
        this.autoClose = autoClose;
    }

    public String getAutoCloseDuration() {
        return autoCloseDuration;
    }

    public void setAutoCloseDuration(String autoCloseDuration) {
        this.autoCloseDuration = autoCloseDuration;
    }
*/
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