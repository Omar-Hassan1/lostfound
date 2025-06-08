package com.lostfound.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private String claimantName;

    @Column(nullable = false)
    private String claimantContact;

    @Column(name = "claim_date", nullable = false)
    private LocalDateTime claimDate;

    @Column(length = 500)
    private String notes;

    public Claim() {
    }

    public Claim(Long itemId, String claimantName, String claimantContact, LocalDateTime claimDate, String notes) {
        this.itemId = itemId;
        this.claimantName = claimantName;
        this.claimantContact = claimantContact;
        this.claimDate = claimDate;
        this.notes = notes;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    public String getClaimantContact() {
        return claimantContact;
    }

    public void setClaimantContact(String claimantContact) {
        this.claimantContact = claimantContact;
    }

    public LocalDateTime getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDateTime claimDate) {
        this.claimDate = claimDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
