package com.wellsfargo.counselor;

import com.wellsfargo.counselor.entity.*;
import com.wellsfargo.counselor.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Entrypoint {

    public static void main(String[] args) {
        SpringApplication.run(Entrypoint.class, args);
    }
    @Bean
    CommandLineRunner demo(AdvisorRepository advisorRepo,
                           ClientRepository clientRepo,
                           PortfolioRepository portfolioRepo,
                           SecurityRepository securityRepo) {
        return args -> {
            Advisor advisor = new Advisor("John", "Doe", "123 Street", "9876543210", "john@example.com");
            advisorRepo.save(advisor);

            Client client = new Client(advisor, "Alice", "alice@example.com");
            clientRepo.save(client);

            Portfolio portfolio = new Portfolio(client, "Moderate", "USD");
            portfolioRepo.save(portfolio);

            Security security = new Security(portfolio, "Apple Inc.", "Stock",
                    LocalDate.now(), 150.0, 10);
            securityRepo.save(security);
        };
    }
}
