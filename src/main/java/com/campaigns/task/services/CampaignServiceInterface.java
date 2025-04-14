package com.campaigns.task.services;

import com.campaigns.task.dto.CampaignRequestDTO;
import com.campaigns.task.dto.CampaignResponseDTO;

import java.util.List;

public interface CampaignServiceInterface {
    void addNewCampaign(CampaignRequestDTO campaignDTO);
    void editCampaign(int id, CampaignRequestDTO campaignDTO);
    List<CampaignResponseDTO> getAllCampaigns();
    CampaignResponseDTO getSpecificCampaign(int id);
    void removeCampaign(int id);
    Long getBalance();
}
