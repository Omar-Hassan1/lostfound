package com.lostfound.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lost_items")
public class LostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "lost_location")
    private String lostLocation;

    @Column(name = "lost_date")
    private LocalDateTime lostDate;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_contact")
    private String ownerContact;

    public LostItem() {
    }

    public LostItem(String itemName, String lostLocation, LocalDateTime lostDate, String ownerName, String ownerContact) {
        this.itemName = itemName;

        this.lostLocation = lostLocation;
        this.lostDate = lostDate;
        this.ownerName = ownerName;
        this.ownerContact = ownerContact;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public String getLostLocation() {
        return lostLocation;
    }

    public void setLostLocation(String lostLocation) {
        this.lostLocation = lostLocation;
    }

    public LocalDateTime getLostDate() {
        return lostDate;
    }

    public void setLostDate(LocalDateTime lostDate) {
        this.lostDate = lostDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }
}
