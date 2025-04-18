package com.campaigns.task.model;

import jakarta.persistence.*;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String keywords;
    private Long amount;
    private Long fund;
    private Boolean status;
    private String town;
    private Integer radius;

    public Campaign() {
    }

    public Campaign(String name, String keywords, Long amount, Long fund, Boolean status, String town, Integer radius) {
        this.name = name;
        this.keywords = keywords;
        this.amount = amount;
        this.fund = fund;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setFund(Long fund) {
        this.fund = fund;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKeywords() {
        return keywords;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getFund() {
        return fund;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getTown() {
        return town;
    }

    public Integer getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords='" + keywords + '\'' +
                ", amount=" + amount +
                ", fund=" + fund +
                ", status=" + status +
                ", town='" + town + '\'' +
                ", radius=" + radius +
                '}';
    }
}
