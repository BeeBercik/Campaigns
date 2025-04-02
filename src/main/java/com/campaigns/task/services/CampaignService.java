package com.campaigns.task.services;

import com.campaigns.task.model.Campaign;
import com.campaigns.task.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private int defaultAccountBalance = 1000;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Optional<Campaign> addNewCampaign(Campaign campaign) {
        this.defaultAccountBalance -= campaign.getFund();
        if(this.defaultAccountBalance < 0) return Optional.empty();

        return Optional.of(this.campaignRepository.save(campaign));
    }

    public Optional<Campaign> editCampaign(Campaign campaign) {
        Optional<Campaign> existingOpt = this.campaignRepository.findById(campaign.getId());

        Campaign existing = existingOpt.get();
        Long oldFund = existing.getFund();
        Long newFund = campaign.getFund();
        Long difference = newFund - oldFund;

        if (this.defaultAccountBalance - difference < 0)
            return Optional.empty();

        this.defaultAccountBalance -= difference;
        Campaign updated = this.campaignRepository.save(campaign);

        return Optional.of(updated);
    }

    public List<Campaign> getAllCampaigns() {
        return this.campaignRepository.findAll();
    }

    public Optional<Campaign> getSpecificCampaign(int id) {
        return this.campaignRepository.findById(id);
    }

    public void removeCampaign(int id) {
        this.campaignRepository.deleteById(id);
    }
}
