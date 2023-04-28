package ai.lentra.controller.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@PropertySource("classpath:configuration.properties")
public class VerificationScheduler {


    /*@Scheduled(cron = scheduler)
    public void scheduleTaskUsingCronExpression() {


    }*/
}
