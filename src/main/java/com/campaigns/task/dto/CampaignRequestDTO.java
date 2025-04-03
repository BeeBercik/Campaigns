package com.campaigns.task.dto;

public record CampaignRequestDTO(
        String name,
        String keywords,
        Long amount,
        Long fund,
        Boolean status,
        String town,
        Integer radius
) { }
