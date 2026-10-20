package ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repository")
@SpringBootApplication(scanBasePackages = {"controller", "service"})
public class SpringEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEcommerceApplication.class, args);
    }

}