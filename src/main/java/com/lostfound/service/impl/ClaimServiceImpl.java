package com.lostfound.service.impl;

import com.lostfound.entity.Claim;
import com.lostfound.repository.ClaimRepository;
import com.lostfound.service.ClaimService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Override
    public Claim createClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    @Override
    public Optional<Claim> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Claim updateClaim(Long id, Claim updatedClaim) {
        return claimRepository.findById(id)
                .map(claim -> {
                    claim.setItemId(updatedClaim.getItemId());
                    claim.setClaimantName(updatedClaim.getClaimantName());
                    claim.setClaimantContact(updatedClaim.getClaimantContact());
                    claim.setClaimDate(updatedClaim.getClaimDate());
                    claim.setNotes(updatedClaim.getNotes());
                    return claimRepository.save(claim);
                })
                .orElseThrow(() -> new RuntimeException("Claim not found with id " + id));
    }

    @Override
    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }
}
