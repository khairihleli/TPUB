package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.ZoneRequest;
import com.example.tpubpfe.dto.ZoneResponse;
import com.example.tpubpfe.model.Zone;
import com.example.tpubpfe.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public ZoneResponse create(ZoneRequest request) {
        Zone zone = new Zone();
        zone.setName(request.getName());
        zone.setDescription(request.getDescription());
        zone.setLatitude(request.getLatitude());
        zone.setLongitude(request.getLongitude());
        zone.setRadiusKm(request.getRadiusKm());
        zone.setCity(request.getCity());
        return toResponse(zoneRepository.save(zone));
    }

    public List<ZoneResponse> findAll() {
        return zoneRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public ZoneResponse update(Long id, ZoneRequest request) {
        Zone zone = zoneRepository.findById(id).orElseThrow(() -> new ZoneNotFoundException(id));
        zone.setName(request.getName());
        zone.setDescription(request.getDescription());
        zone.setLatitude(request.getLatitude());
        zone.setLongitude(request.getLongitude());
        zone.setRadiusKm(request.getRadiusKm());
        zone.setCity(request.getCity());
        return toResponse(zoneRepository.save(zone));
    }

    public void delete(Long id) {
        Zone zone = zoneRepository.findById(id).orElseThrow(() -> new ZoneNotFoundException(id));
        zoneRepository.delete(zone);
    }

    private ZoneResponse toResponse(Zone zone) {
        return new ZoneResponse(zone.getId(), zone.getName(), zone.getDescription(), zone.getLatitude(), zone.getLongitude(), zone.getRadiusKm(), zone.getCity());
    }
}
