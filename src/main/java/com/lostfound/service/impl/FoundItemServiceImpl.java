package com.lostfound.service.impl;

import com.lostfound.entity.FoundItem;
import com.lostfound.repository.FoundItemRepository;
import com.lostfound.service.FoundItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoundItemServiceImpl implements FoundItemService {

    private final FoundItemRepository foundItemRepository;

    public FoundItemServiceImpl(FoundItemRepository foundItemRepository) {
        this.foundItemRepository = foundItemRepository;
    }

    @Override
    public FoundItem createFoundItem(FoundItem foundItem) {
        return foundItemRepository.save(foundItem);
    }

    @Override
    public Optional<FoundItem> getFoundItemById(Long id) {
        return foundItemRepository.findById(id);
    }

    @Override
    public List<FoundItem> getAllFoundItems() {
        return foundItemRepository.findAll();
    }

    @Override
    public FoundItem updateFoundItem(Long id, FoundItem updatedFoundItem) {
        return foundItemRepository.findById(id)
                .map(item -> {
                    item.setItemName(updatedFoundItem.getItemName());
                    item.setDescription(updatedFoundItem.getDescription());
                    item.setFoundLocation(updatedFoundItem.getFoundLocation());
                    item.setFoundDate(updatedFoundItem.getFoundDate());
                    item.setReporterName(updatedFoundItem.getReporterName());
                    item.setReporterContact(updatedFoundItem.getReporterContact());
                    return foundItemRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Found item not found with id " + id));
    }

    @Override
    public void deleteFoundItem(Long id) {
        foundItemRepository.deleteById(id);
    }
}
