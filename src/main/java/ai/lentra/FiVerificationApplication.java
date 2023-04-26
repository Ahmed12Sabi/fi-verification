package ai.lentra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.io.IOException;

@SpringBootApplication
@EnableTransactionManagement
public class FiVerificationApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(FiVerificationApplication.class,args);

	}
}
