package com.example.tpubpfe.controller;

import com.example.tpubpfe.dto.ContentCheckRequest;
import com.example.tpubpfe.dto.ContentCheckResponse;
import com.example.tpubpfe.service.ContentCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class ContentCheckController {

    private final ContentCheckService contentCheckService;

    @PostMapping("/check-content")
    public ResponseEntity<ContentCheckResponse> createCheck(@RequestBody ContentCheckRequest request) {
        return new ResponseEntity<>(contentCheckService.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/checks")
    public ResponseEntity<List<ContentCheckResponse>> getAllChecks() {
        return ResponseEntity.ok(contentCheckService.findAll());
    }
}
