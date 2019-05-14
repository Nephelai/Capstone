package triplej.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class CapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}
}
