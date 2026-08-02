package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.CompanyRequest;
import com.example.tpubpfe.dto.CompanyResponse;
import com.example.tpubpfe.model.Company;
import com.example.tpubpfe.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyResponse create(CompanyRequest request) {
        Company company = new Company();
        company.setName(request.getName());
        company.setEmail(request.getEmail());
        company.setPhone(request.getPhone());
        company.setAddress(request.getAddress());
        return toResponse(companyRepository.save(company));
    }

    public List<CompanyResponse> findAll() {
        return companyRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public CompanyResponse update(Long id, CompanyRequest request) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));

        company.setName(request.getName());
        company.setEmail(request.getEmail());
        company.setPhone(request.getPhone());
        company.setAddress(request.getAddress());
        return toResponse(companyRepository.save(company));
    }

    public void delete(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
        companyRepository.delete(company);
    }

    private CompanyResponse toResponse(Company company) {
        return new CompanyResponse(company.getId(), company.getName(), company.getEmail(), company.getPhone(), company.getAddress());
    }
}
