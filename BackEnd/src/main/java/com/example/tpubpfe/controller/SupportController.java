package com.example.tpubpfe.controller;

import com.example.tpubpfe.dto.SupportRequest;
import com.example.tpubpfe.dto.SupportResponse;
import com.example.tpubpfe.service.SupportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supports")
@RequiredArgsConstructor
public class SupportController {

    private final SupportService supportService;

    @PostMapping
    public ResponseEntity<SupportResponse> createSupport(@Valid @RequestBody SupportRequest request) {
        return new ResponseEntity<>(supportService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SupportResponse>> getAllSupports() {
        return ResponseEntity.ok(supportService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportResponse> updateSupport(@PathVariable Long id, @Valid @RequestBody SupportRequest request) {
        return ResponseEntity.ok(supportService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupport(@PathVariable Long id) {
        supportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
