package com.campaigns.task.dto;

public record CampaignResponseDTO(
        Integer id,
        String name,
        String keywords,
        Long amount,
        Long fund,
        Boolean status,
        String town,
        Integer radius) {
}
