package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.SupportRequest;
import com.example.tpubpfe.dto.SupportResponse;
import com.example.tpubpfe.model.Support;
import com.example.tpubpfe.repository.SupportRepository;
import com.example.tpubpfe.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportRepository supportRepository;
    private final ZoneRepository zoneRepository;

    public SupportResponse create(SupportRequest request) {
        zoneRepository.findById(request.getZoneId()).orElseThrow(() -> new ZoneNotFoundException(request.getZoneId()));

        Support support = new Support();
        support.setName(request.getName());
        support.setType(request.getType());
        support.setZoneId(request.getZoneId());
        support.setStatus(request.getStatus());
        support.setCapacity(request.getCapacity());
        return toResponse(supportRepository.save(support));
    }

    public List<SupportResponse> findAll() {
        return supportRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public SupportResponse update(Long id, SupportRequest request) {
        Support support = supportRepository.findById(id).orElseThrow(() -> new SupportNotFoundException(id));
        zoneRepository.findById(request.getZoneId()).orElseThrow(() -> new ZoneNotFoundException(request.getZoneId()));
        support.setName(request.getName());
        support.setType(request.getType());
        support.setZoneId(request.getZoneId());
        support.setStatus(request.getStatus());
        support.setCapacity(request.getCapacity());
        return toResponse(supportRepository.save(support));
    }

    public void delete(Long id) {
        Support support = supportRepository.findById(id).orElseThrow(() -> new SupportNotFoundException(id));
        supportRepository.delete(support);
    }

    private SupportResponse toResponse(Support support) {
        return new SupportResponse(support.getId(), support.getName(), support.getType(), support.getZoneId(), support.getStatus(), support.getCapacity());
    }
}
