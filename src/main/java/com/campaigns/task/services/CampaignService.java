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
        System.out.println(this.defaultAccountBalance);
        if(this.defaultAccountBalance < 0) return Optional.empty();

        return Optional.of(this.campaignRepository.save(campaign));
    }

    public List<Campaign> getAllCampaigns() {
        return this.campaignRepository.findAll();
    }
}
