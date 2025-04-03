package com.campaigns.task.services.impl;

import com.campaigns.task.dto.CampaignRequestDTO;
import com.campaigns.task.dto.CampaignResponseDTO;
import com.campaigns.task.model.Campaign;
import com.campaigns.task.repositories.CampaignRepository;
import com.campaigns.task.services.CampaignServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService implements CampaignServiceInterface {

    private final CampaignRepository campaignRepository;
    private long defaultAccountBalance = 1000;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Optional<Campaign> addNewCampaign(CampaignRequestDTO campaignDTO) {
        if (campaignDTO.fund() > this.defaultAccountBalance) {
            return Optional.empty();
        }
        this.defaultAccountBalance -= campaignDTO.fund();

        return Optional.of(this.campaignRepository.save(
                this.mapRequestToEntity(campaignDTO)));
    }

    public Optional<Campaign> editCampaign(int id, CampaignRequestDTO campaignDTO) {
        Optional<Campaign> existingOpt = this.campaignRepository.findById(id);
        if(existingOpt.isEmpty()) return Optional.empty();

        Campaign existing = existingOpt.get();
        Long oldFund = existing.getFund();
        Long newFund = campaignDTO.fund();
        long difference = newFund - oldFund;

        if (this.defaultAccountBalance - difference < 0)
            return Optional.empty();

        this.defaultAccountBalance -= difference;
        Campaign updatedCampaign = this.mapRequestToEntity(campaignDTO);
        updatedCampaign.setId(id);

        return Optional.of(this.campaignRepository.save(updatedCampaign));
    }

    public List<CampaignResponseDTO> getAllCampaigns() {
        return this.campaignRepository.findAll()
                .stream()
                .map(this::mapEntityToResponse)
                .toList();
    }

    public Optional<CampaignResponseDTO> getSpecificCampaign(int id) {
        return this.campaignRepository.findById(id).map(this::mapEntityToResponse);
    }

    public boolean removeCampaign(int id) {
        Optional<Campaign> campaign = this.campaignRepository.findById(id);
        if(campaign.isEmpty()) return false;

        this.defaultAccountBalance += campaign.get().getFund();
        this.campaignRepository.deleteById(id);
        return true;
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
