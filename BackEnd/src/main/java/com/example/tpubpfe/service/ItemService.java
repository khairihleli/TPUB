package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.ItemRequest;
import com.example.tpubpfe.dto.ItemResponse;
import com.example.tpubpfe.model.Item;
import com.example.tpubpfe.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponse create(ItemRequest request) {
        Item item = new Item();
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        return toResponse(itemRepository.save(item));
    }

    public List<ItemResponse> findAll() {
        return itemRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ItemResponse update(Long id, ItemRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        item.setName(request.getName());
        item.setDescription(request.getDescription());
        return toResponse(itemRepository.save(item));
    }

    public void delete(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        itemRepository.delete(item);
    }

    private ItemResponse toResponse(Item item) {
        return new ItemResponse(item.getId(), item.getName(), item.getDescription());
    }
}
