package com.campaigns.task.mappers;

import com.campaigns.task.dto.CampaignRequestDTO;
import com.campaigns.task.dto.CampaignResponseDTO;
import com.campaigns.task.model.Campaign;
import org.springframework.stereotype.Component;

@Component
public class CampaignMapper {

    public Campaign mapRequestToEntity(CampaignRequestDTO dto) {
        return new Campaign(
                dto.name(),
                dto.keywords(),
                dto.amount(),
                dto.fund(),
                dto.status(),
                dto.town(),
                dto.radius()
        );
    }

    public CampaignResponseDTO mapEntityToResponse(Campaign campaign) {
        return new CampaignResponseDTO(
                campaign.getId(),
                campaign.getName(),
                campaign.getKeywords(),
                campaign.getAmount(),
                campaign.getFund(),
                campaign.getStatus(),
                campaign.getTown(),
                campaign.getRadius()
        );
    }
}
