package com.lostfound.service.impl;

import com.lostfound.entity.ItemCategory;
import com.lostfound.repository.ItemCategoryRepository;
import com.lostfound.service.ItemCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    private final ItemCategoryRepository itemCategoryRepository;

    public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository) {
        this.itemCategoryRepository = itemCategoryRepository;
    }

    @Override
    public ItemCategory createCategory(ItemCategory category) {
        return itemCategoryRepository.save(category);
    }

    @Override
    public Optional<ItemCategory> getCategoryById(Long id) {
        return itemCategoryRepository.findById(id);
    }

    @Override
    public List<ItemCategory> getAllCategories() {
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory updateCategory(Long id, ItemCategory updatedCategory) {
        return itemCategoryRepository.findById(id)
                .map(category -> {
                    category.setName(updatedCategory.getName());
                    category.setDescription(updatedCategory.getDescription());
                    return itemCategoryRepository.save(category);
                }).orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    }

    @Override
    public void deleteCategory(Long id) {
        itemCategoryRepository.deleteById(id);
    }
}
