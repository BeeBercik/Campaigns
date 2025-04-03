package com.campaigns.task.services;

import com.campaigns.task.dto.CampaignRequestDTO;
import com.campaigns.task.dto.CampaignResponseDTO;
import com.campaigns.task.model.Campaign;

import java.util.List;
import java.util.Optional;

public interface CampaignServiceInterface {
    Optional<Campaign> addNewCampaign(CampaignRequestDTO campaignDTO);
    Optional<Campaign> editCampaign(int id, CampaignRequestDTO campaignDTO);
    List<CampaignResponseDTO> getAllCampaigns();
    Optional<CampaignResponseDTO> getSpecificCampaign(int id);
    boolean removeCampaign(int id);
    Long getBalance();
}
