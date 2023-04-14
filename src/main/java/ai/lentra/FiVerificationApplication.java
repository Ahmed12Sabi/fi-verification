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

	public String scheduler ;

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		// Properties prop = readPropertiesFile("configuration.properties");
		prop.load(FiVerificationApplication.class.getClassLoader().getResourceAsStream("configuration.properties"));
		System.out.println("username: "+ prop.getProperty("scheduler"));
		Long schedule = Long.valueOf(prop.getProperty("scheduler"));
		schedule = schedule * 600000;
		// schedule = schedule * 86400000;
		SpringApplication.run(FiVerificationApplication.class, args);
		Timer t = new Timer();


		TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				FormCleanUpServiceImpl formCleanUpController = new FormCleanUpServiceImpl();
				System.out.println("working on");
				formCleanUpController.doFormCleanUp();

			};
		};
		t.schedule(tt, new Date(),schedule); ;
	}
	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}
	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver localeResolver=new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
