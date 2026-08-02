package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.EmergencyMessageRequest;
import com.example.tpubpfe.dto.EmergencyMessageResponse;
import com.example.tpubpfe.model.EmergencyMessage;
import com.example.tpubpfe.repository.EmergencyMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmergencyMessageService {

    private final EmergencyMessageRepository emergencyMessageRepository;

    public EmergencyMessageResponse create(EmergencyMessageRequest request) {
        EmergencyMessage message = new EmergencyMessage();
        message.setTitle(request.getTitle());
        message.setMessage(request.getMessage());
        message.setZone(request.getZone());
        message.setStartTime(request.getStartTime());
        message.setEndTime(request.getEndTime());
        message.setPriority(request.getPriority() != null ? request.getPriority() : 1);
        return toResponse(emergencyMessageRepository.save(message));
    }

    public List<EmergencyMessageResponse> findAll() {
        return emergencyMessageRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public EmergencyMessageResponse update(Long id, EmergencyMessageRequest request) {
        EmergencyMessage message = emergencyMessageRepository.findById(id).orElseThrow(() -> new RuntimeException("Emergency message not found"));
        message.setTitle(request.getTitle());
        message.setMessage(request.getMessage());
        message.setZone(request.getZone());
        message.setStartTime(request.getStartTime());
        message.setEndTime(request.getEndTime());
        message.setPriority(request.getPriority() != null ? request.getPriority() : message.getPriority());
        return toResponse(emergencyMessageRepository.save(message));
    }

    public void delete(Long id) {
        EmergencyMessage message = emergencyMessageRepository.findById(id).orElseThrow(() -> new RuntimeException("Emergency message not found"));
        emergencyMessageRepository.delete(message);
    }

    private EmergencyMessageResponse toResponse(EmergencyMessage message) {
        return new EmergencyMessageResponse(message.getId(), message.getTitle(), message.getMessage(), message.getZone(), message.getStartTime(), message.getEndTime(), message.getPriority());
    }
}
