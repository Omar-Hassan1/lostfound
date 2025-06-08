package com.lostfound.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "found_items")
public class FoundItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "found_location")
    private String foundLocation;

    @Column(name = "found_date")
    private LocalDateTime foundDate;

    @Column(name = "reporter_name")
    private String reporterName;

    @Column(name = "reporter_contact")
    private String reporterContact;

    public FoundItem() {
    }

    public FoundItem(String itemName, String description, String foundLocation, LocalDateTime foundDate, String reporterName, String reporterContact) {
        this.itemName = itemName;
        this.foundLocation = foundLocation;
        this.foundDate = foundDate;
        this.reporterName = reporterName;
        this.reporterContact = reporterContact;
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


    public String getFoundLocation() {
        return foundLocation;
    }

    public void setFoundLocation(String foundLocation) {
        this.foundLocation = foundLocation;
    }

    public LocalDateTime getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(LocalDateTime foundDate) {
        this.foundDate = foundDate;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getReporterContact() {
        return reporterContact;
    }

    public void setReporterContact(String reporterContact) {
        this.reporterContact = reporterContact;
    }
}
