package com.lostfound.service;

import com.lostfound.entity.FoundItem;

import java.util.List;
import java.util.Optional;

public interface FoundItemService {

    FoundItem createFoundItem(FoundItem foundItem);

    Optional<FoundItem> getFoundItemById(Long id);

    List<FoundItem> getAllFoundItems();

    FoundItem updateFoundItem(Long id, FoundItem updatedFoundItem);

    void deleteFoundItem(Long id);
}
