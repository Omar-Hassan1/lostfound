package com.lostfound.service;

import com.lostfound.entity.Claim;

import java.util.List;
import java.util.Optional;

public interface ClaimService {

    Claim createClaim(Claim claim);

    Optional<Claim> getClaimById(Long id);

    List<Claim> getAllClaims();

    Claim updateClaim(Long id, Claim updatedClaim);

    void deleteClaim(Long id);
}
