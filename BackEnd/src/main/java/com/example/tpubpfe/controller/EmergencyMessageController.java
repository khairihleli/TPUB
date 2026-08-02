package com.example.tpubpfe.controller;

import com.example.tpubpfe.dto.EmergencyMessageRequest;
import com.example.tpubpfe.dto.EmergencyMessageResponse;
import com.example.tpubpfe.service.EmergencyMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergency-messages")
@RequiredArgsConstructor
public class EmergencyMessageController {

    private final EmergencyMessageService emergencyMessageService;

    @PostMapping
    public ResponseEntity<EmergencyMessageResponse> createMessage(@RequestBody EmergencyMessageRequest request) {
        return new ResponseEntity<>(emergencyMessageService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmergencyMessageResponse>> getAllMessages() {
        return ResponseEntity.ok(emergencyMessageService.findAll());
    }
}
