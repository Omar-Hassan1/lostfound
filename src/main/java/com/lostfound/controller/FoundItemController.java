package com.lostfound.controller;

import com.lostfound.entity.FoundItem;
import com.lostfound.service.FoundItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/found-items")
public class FoundItemController {

    private final FoundItemService foundItemService;

    public FoundItemController(FoundItemService foundItemService) {
        this.foundItemService = foundItemService;
    }

    @PostMapping
    public ResponseEntity<FoundItem> createFoundItem(@RequestBody FoundItem foundItem) {
        FoundItem saved = foundItemService.createFoundItem(foundItem);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoundItem> getFoundItemById(@PathVariable Long id) {
        return foundItemService.getFoundItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FoundItem>> getAllFoundItems() {
        List<FoundItem> items = foundItemService.getAllFoundItems();
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoundItem> updateFoundItem(@PathVariable Long id, @RequestBody FoundItem updatedFoundItem) {
        try {
            FoundItem item = foundItemService.updateFoundItem(id, updatedFoundItem);
            return ResponseEntity.ok(item);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoundItem(@PathVariable Long id) {
        foundItemService.deleteFoundItem(id);
        return ResponseEntity.noContent().build();
    }
}
