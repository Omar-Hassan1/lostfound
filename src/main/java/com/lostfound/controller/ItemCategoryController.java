package com.lostfound.controller;

import com.lostfound.entity.ItemCategory;
import com.lostfound.service.ItemCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    public ItemCategoryController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @PostMapping
    public ResponseEntity<ItemCategory> createCategory(@RequestBody ItemCategory category) {
        ItemCategory savedCategory = itemCategoryService.createCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCategory> getCategoryById(@PathVariable Long id) {
        return itemCategoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ItemCategory>> getAllCategories() {
        List<ItemCategory> categories = itemCategoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCategory> updateCategory(@PathVariable Long id, @RequestBody ItemCategory updatedCategory) {
        try {
            ItemCategory category = itemCategoryService.updateCategory(id, updatedCategory);
            return ResponseEntity.ok(category);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        itemCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
