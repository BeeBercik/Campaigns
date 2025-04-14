package com.campaigns.task.controllers.impl;

import com.campaigns.task.controllers.CampaignControllerInterface;
import com.campaigns.task.dto.CampaignRequestDTO;
import com.campaigns.task.dto.CampaignResponseDTO;
import com.campaigns.task.model.Campaign;
import com.campaigns.task.services.impl.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return this.campaignService.addNewCampaign(campaignRequestDTO)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editCampaign(@PathVariable(value = "id") int id, @RequestBody CampaignRequestDTO campaignRequestDTO) {
        return this.campaignService.editCampaign(id, campaignRequestDTO)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/getCampaign/{id}")
    public ResponseEntity<?> getSpecificCampaign(@PathVariable(name = "id") int id) {
        return this.campaignService.getSpecificCampaign(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCampaign(@PathVariable(value = "id") int id) {
        return this.campaignService.removeCampaign(id)
                ?  ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/balance")
    public ResponseEntity<Long> getAccountBalance() {
        return ResponseEntity.ok(this.campaignService.getBalance());
    }
}
