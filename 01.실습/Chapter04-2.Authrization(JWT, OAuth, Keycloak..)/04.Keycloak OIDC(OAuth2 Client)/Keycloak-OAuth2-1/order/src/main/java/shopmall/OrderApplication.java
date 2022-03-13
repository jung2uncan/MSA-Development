package shopmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrderApplication {

	protected static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(OrderApplication.class, args);
	}
}
