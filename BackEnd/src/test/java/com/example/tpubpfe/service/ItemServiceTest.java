package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.ItemRequest;
import com.example.tpubpfe.dto.ItemResponse;
import com.example.tpubpfe.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void shouldCreateReadUpdateAndDeleteItem() {
        itemRepository.deleteAll();

        ItemResponse created = itemService.create(new ItemRequest("Laptop", "Gaming laptop"));
        assertThat(created.getId()).isNotNull();

        List<ItemResponse> items = itemService.findAll();
        assertThat(items).hasSize(1);

        ItemResponse updated = itemService.update(created.getId(), new ItemRequest("Laptop Pro", "Updated laptop"));
        assertThat(updated.getName()).isEqualTo("Laptop Pro");

        itemService.delete(created.getId());
        assertThat(itemService.findAll()).isEmpty();
    }
}
