package ai.lentra;

import ai.lentra.controller.scheduler.FormCleanUpController;
import ai.lentra.service.scheduler.FormCleanUpService;
import ai.lentra.serviceImpl.scheduler.FormCleanUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@SpringBootApplication
@Transactional
@EnableScheduling
public class FiVerificationApplication {

	public String scheduler;

	public static void main(String[] args) throws IOException {


		SpringApplication.run(FiVerificationApplication.class, args);

	}
}
