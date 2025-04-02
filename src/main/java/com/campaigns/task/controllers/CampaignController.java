package com.campaigns.task.controllers;

import com.campaigns.task.model.Campaign;
import com.campaigns.task.services.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println("kontroler get all campaigns");
        System.out.println(this.campaignService.getAllCampaigns());
        return new ResponseEntity<>(this.campaignService.getAllCampaigns(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addNewCampaign(@RequestBody Campaign campaign) {
        System.out.println(campaign);
        Campaign result = this.campaignService.addNewCampaign(campaign);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public void editCampaign(@RequestBody Campaign campaign) {
        System.out.println(campaign);
//        Campaign result = this.campaignService.addNewCampaign(campaign);
//        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
