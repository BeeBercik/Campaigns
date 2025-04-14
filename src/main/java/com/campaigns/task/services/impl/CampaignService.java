package com.campaigns.task.services.impl;

import com.campaigns.task.dto.CampaignRequestDTO;
import com.campaigns.task.dto.CampaignResponseDTO;
import com.campaigns.task.exceptions.CampaignNotFoundException;
import com.campaigns.task.exceptions.InsufficientAccountBalance;
import com.campaigns.task.model.Campaign;
import com.campaigns.task.repositories.CampaignRepository;
import com.campaigns.task.services.CampaignServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService implements CampaignServiceInterface {

    private final CampaignRepository campaignRepository;
    private long defaultAccountBalance = 1000;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public void addNewCampaign(CampaignRequestDTO campaignDTO) {
        if (campaignDTO.fund() > this.defaultAccountBalance)
            throw new InsufficientAccountBalance("Not enough money");

        this.defaultAccountBalance -= campaignDTO.fund();
        this.campaignRepository.save(this.mapRequestToEntity(campaignDTO));
    }

    public void editCampaign(int id, CampaignRequestDTO campaignDTO) {
        Campaign existingCampaign = this.campaignRepository.findById(id)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found"));

        long difference = campaignDTO.fund() - existingCampaign.getFund();
        if (this.defaultAccountBalance - difference < 0)
            throw new InsufficientAccountBalance("Not enough money");

        this.defaultAccountBalance -= difference;
        Campaign updatedCampaign = this.mapRequestToEntity(campaignDTO);
        updatedCampaign.setId(id);

        this.campaignRepository.save(updatedCampaign);
    }

    public List<CampaignResponseDTO> getAllCampaigns() {
        return this.campaignRepository.findAll()
                .stream()
                .map(this::mapEntityToResponse)
                .toList();
    }

    public CampaignResponseDTO getSpecificCampaign(int id) {
        return this.campaignRepository.findById(id)
                .map(this::mapEntityToResponse)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found"));
    }

    public void removeCampaign(int id) {
        Campaign campaign = this.campaignRepository.findById(id)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found"));

        this.defaultAccountBalance += campaign.getFund();
        this.campaignRepository.deleteById(id);
    }

    public Long getBalance() {
        return this.defaultAccountBalance;
    }

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
