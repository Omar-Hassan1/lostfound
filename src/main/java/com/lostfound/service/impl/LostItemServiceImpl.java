package com.lostfound.service.impl;

import com.lostfound.entity.LostItem;
import com.lostfound.repository.LostItemRepository;
import com.lostfound.service.LostItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LostItemServiceImpl implements LostItemService {

    private final LostItemRepository lostItemRepository;

    public LostItemServiceImpl(LostItemRepository lostItemRepository) {
        this.lostItemRepository = lostItemRepository;
    }

    @Override
    public LostItem createLostItem(LostItem lostItem) {
        return lostItemRepository.save(lostItem);
    }

    @Override
    public Optional<LostItem> getLostItemById(Long id) {
        return lostItemRepository.findById(id);
    }

    @Override
    public List<LostItem> getAllLostItems() {
        return lostItemRepository.findAll();
    }

    @Override
    public LostItem updateLostItem(Long id, LostItem updatedLostItem) {
        return lostItemRepository.findById(id)
                .map(item -> {
                    item.setItemName(updatedLostItem.getItemName());
                    item.setLostLocation(updatedLostItem.getLostLocation());
                    item.setLostDate(updatedLostItem.getLostDate());
                    item.setOwnerName(updatedLostItem.getOwnerName());
                    item.setOwnerContact(updatedLostItem.getOwnerContact());
                    return lostItemRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Lost item not found with id " + id));
    }

    @Override
    public void deleteLostItem(Long id) {
        lostItemRepository.deleteById(id);
    }
}
