package com.lostfound.controller;

import com.lostfound.entity.LostItem;
import com.lostfound.service.LostItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lost-items")
public class LostItemController {

    private final LostItemService lostItemService;

    public LostItemController(LostItemService lostItemService) {
        this.lostItemService = lostItemService;
    }

    @PostMapping
    public ResponseEntity<LostItem> createLostItem(@RequestBody LostItem lostItem) {
        LostItem saved = lostItemService.createLostItem(lostItem);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LostItem> getLostItemById(@PathVariable Long id) {
        return lostItemService.getLostItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LostItem>> getAllLostItems() {
        List<LostItem> items = lostItemService.getAllLostItems();
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LostItem> updateLostItem(@PathVariable Long id, @RequestBody LostItem updatedLostItem) {
        try {
            LostItem item = lostItemService.updateLostItem(id, updatedLostItem);
            return ResponseEntity.ok(item);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLostItem(@PathVariable Long id) {
        lostItemService.deleteLostItem(id);
        return ResponseEntity.noContent().build();
    }
}
