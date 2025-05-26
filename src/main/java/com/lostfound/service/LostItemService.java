package com.lostfound.service;

import com.lostfound.entity.LostItem;

import java.util.List;
import java.util.Optional;

public interface LostItemService {

    LostItem createLostItem(LostItem lostItem);

    Optional<LostItem> getLostItemById(Long id);

    List<LostItem> getAllLostItems();

    LostItem updateLostItem(Long id, LostItem updatedLostItem);

    void deleteLostItem(Long id);
}
