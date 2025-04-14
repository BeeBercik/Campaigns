package com.campaigns.task.controllers.impl;

import com.campaigns.task.controllers.CampaignControllerInterface;
import com.campaigns.task.dto.CampaignRequestDTO;
import com.campaigns.task.dto.CampaignResponseDTO;
import com.campaigns.task.services.impl.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CampaignController implements CampaignControllerInterface {

    private final CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CampaignResponseDTO>> getAllCampaigns() {
        return ResponseEntity.ok(this.campaignService.getAllCampaigns());
    }

    @PostMapping("/new")
    public ResponseEntity<?> addNewCampaign(@RequestBody CampaignRequestDTO campaignRequestDTO) {
        this.campaignService.addNewCampaign(campaignRequestDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editCampaign(@PathVariable(value = "id") int id, @RequestBody CampaignRequestDTO campaignRequestDTO) {
        this.campaignService.editCampaign(id, campaignRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getCampaign/{id}")
    public ResponseEntity<CampaignResponseDTO> getSpecificCampaign(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().body(this.campaignService.getSpecificCampaign(id));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCampaign(@PathVariable(value = "id") int id) {
        this.campaignService.removeCampaign(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/balance")
    public ResponseEntity<Long> getAccountBalance() {
        return ResponseEntity.ok(this.campaignService.getBalance());
    }
}
