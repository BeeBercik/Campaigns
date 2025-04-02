package com.campaigns.task.controllers;

import com.campaigns.task.model.Campaign;
import com.campaigns.task.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CampaignController {

    private final CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        return ResponseEntity.ok(this.campaignService.getAllCampaigns());
    }

    @PostMapping("/new")
    public ResponseEntity<?> addNewCampaign(@RequestBody Campaign campaign) {
        Optional<Campaign> resultOpt = this.campaignService.addNewCampaign(campaign);
        return resultOpt.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editCampaign(@PathVariable(value = "id") int id, @RequestBody Campaign campaign) {
        campaign.setId(id);
        Optional<Campaign> resultOpt = this.campaignService.editCampaign(campaign);
        return resultOpt.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("getCampaign/{id}")
    public ResponseEntity<?> getSpecificCampaign(@PathVariable(name = "id") int id) {
        Optional<Campaign> resultOpt = this.campaignService.getSpecificCampaign(id);
        return resultOpt.isPresent() ? ResponseEntity.ok(resultOpt.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<?> removeCampaign(@PathVariable(value = "id") int id) {
        this.campaignService.removeCampaign(id);
        return ResponseEntity.ok().build();
    }
}
