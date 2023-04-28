package ai.lentra.controller.scheduler;

import ai.lentra.core.config.api.tenantconfig.ConfigService;

import ai.lentra.core.jobscheduler.api.JobFunction;
import ai.lentra.core.jobscheduler.api.JobInterface;
import ai.lentra.service.scheduler.FormCleanUpService;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ai.lentra.config.SchedularConfig;
import static ai.lentra.config.dbConfig.ConfigKeys.DO_FORM_CLEANUP;

@Component
public class FormCleanUpController implements JobInterface
 {

    private final Logger logger = LoggerFactory.getLogger(FormCleanUpController.class);
    @Autowired
    FormCleanUpService formCleanUpService;

     @Value("${lookup.sync.cron.expr:0 * * * * *}")
     private String lookupSyncCronExpr;
    public void doFormCleanUp()  {
        logger.info("Started API call to delete two months old data");
        formCleanUpService.doFormCleanUp();
    }

    @Autowired
    private ConfigService configService;
    @Override
    public String getName() {
        return "DO_FORM_CLEANUP";
    }

    @Override
    public JobFunction getJobFunction() {
        return (context -> {
            logger.info("Executing Do form clean up..."); 
            formCleanUpService.doFormCleanUp();
            logger.info("Executing Do form clean up.....Done.");
        });
    }

    @Override
    public String getCronSchedule() {
        SchedularConfig config = (SchedularConfig) configService.getConfig(DO_FORM_CLEANUP.name());
        if(!Strings.isNullOrEmpty(config.getBatchJobCronExpr())) {
            return config.getBatchJobCronExpr();
        }
        return lookupSyncCronExpr;
    }
}
