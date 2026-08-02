package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.CompanyRequest;
import com.example.tpubpfe.dto.CompanyResponse;
import com.example.tpubpfe.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;

    @BeforeEach
    void setUp() {
        companyRepository.deleteAll();
    }

    @Test
    void shouldCreateReadUpdateAndDeleteCompany() {
        CompanyResponse created = companyService.create(new CompanyRequest(
                "Acme",
                "contact@acme.com",
                "21671234567",
                "Tunis"
        ));

        assertThat(created.getId()).isNotNull();
        assertThat(created.getName()).isEqualTo("Acme");

        List<CompanyResponse> companies = companyService.findAll();
        assertThat(companies).hasSize(1);

        CompanyResponse updated = companyService.update(created.getId(), new CompanyRequest(
                "Acme Corp",
                "info@acme.com",
                "21671987654",
                "Sfax"
        ));

        assertThat(updated.getName()).isEqualTo("Acme Corp");
        assertThat(updated.getEmail()).isEqualTo("info@acme.com");

        companyService.delete(created.getId());
        assertThat(companyService.findAll()).isEmpty();
    }
}
