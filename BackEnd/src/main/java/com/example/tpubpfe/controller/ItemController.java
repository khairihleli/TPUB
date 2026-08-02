package com.example.tpubpfe.controller;

import com.example.tpubpfe.dto.ItemRequest;
import com.example.tpubpfe.dto.ItemResponse;
import com.example.tpubpfe.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@Valid @RequestBody ItemRequest request) {
        return new ResponseEntity<>(itemService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemResponse> updateItem(@PathVariable Long id, @Valid @RequestBody ItemRequest request) {
        return ResponseEntity.ok(itemService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
