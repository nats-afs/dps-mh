package com.afs.nats.dpsmh;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.afs.nats.dpsmh.model.Office;
import com.afs.nats.dpsmh.model.Requisite;
import com.afs.nats.dpsmh.repository.ClaimantRepository;
import com.afs.nats.dpsmh.repository.OfficeRepository;
import com.afs.nats.dpsmh.repository.RequisiteRepository;
import com.github.javafaker.Bool;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.afs.nats.dpsmh.model.Claimant;
import com.afs.nats.dpsmh.model.DocumentType;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
//@EnableJpaAuditing
//@EnableJpaRepositories
public class DpsMhApplication {

    public static void main(String[] args) {
        SpringApplication.run(DpsMhApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ClaimantRepository claimantRepository, OfficeRepository officeRepository,
                                    RequisiteRepository requisiteRepository) {
        return args -> {
            Faker faker = new Faker();

            List<Claimant> claimantList = new ArrayList<Claimant>();
            List<Office> officeList = new ArrayList<Office>();
            for (int i = 1; i < 100; i++) {
                Boolean tipo = faker.bool().bool();
                claimantList
                        .add(new Claimant(
                                faker.name().fullName(),
                                faker.address().fullAddress(),
                                faker.phoneNumber().cellPhone(),
                                faker.internet().emailAddress(),
                                tipo.equals(Boolean.TRUE) ? DocumentType.DNI : DocumentType.RUC,
                                tipo.equals(Boolean.TRUE) ? faker.number().digits(8) : faker.number().digits(11))
                        );
            }

            for (int i = 0; i < 10; i++) {
                officeList.add(new Office(
                        faker.company().name(),
                        faker.company().suffix(),
                        faker.company().catchPhrase(),
                        faker.bool().bool()));
            }

            IntStream.range(0, 50).forEach((a) -> requisiteRepository.save(
                    new Requisite(faker.gameOfThrones().house(), faker.esports().event())
            ));

            officeList.forEach(officeRepository::save);
            claimantList.forEach(claimantRepository::save);
        };
    }
}
