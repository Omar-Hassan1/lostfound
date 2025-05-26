package com.lostfound.service;

import com.lostfound.entity.ItemCategory;

import java.util.List;
import java.util.Optional;

public interface ItemCategoryService {

    ItemCategory createCategory(ItemCategory category);

    Optional<ItemCategory> getCategoryById(Long id);

    List<ItemCategory> getAllCategories();

    ItemCategory updateCategory(Long id, ItemCategory updatedCategory);

    void deleteCategory(Long id);
}
