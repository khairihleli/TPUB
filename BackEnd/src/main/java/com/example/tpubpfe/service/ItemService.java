package com.example.tpubpfe.service;

import com.example.tpubpfe.model.Item;
import com.example.tpubpfe.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item update(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        return itemRepository.save(item);
    }

    public void delete(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        itemRepository.delete(item);
    }
}
