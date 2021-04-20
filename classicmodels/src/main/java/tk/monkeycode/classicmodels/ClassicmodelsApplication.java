package tk.monkeycode.classicmodels;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClassicmodelsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ClassicmodelsApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ClassicmodelsApplication.class);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> DemoConsola.main(args);
	}

	
}
