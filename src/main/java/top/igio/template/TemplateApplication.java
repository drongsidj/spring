package top.igio.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateApplication {

	final static Logger logger = LoggerFactory.getLogger(TemplateApplication.class);

	public static void main(String[] args) {
		logger.info("TemplateApplication start...");
		SpringApplication.run(TemplateApplication.class, args);
	}

}
