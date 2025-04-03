package com.campaigns.task.controllers;

import com.campaigns.task.dto.CampaignRequestDTO;
import com.campaigns.task.dto.CampaignResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CampaignControllerInterface {
    ResponseEntity<List<CampaignResponseDTO>> getAllCampaigns();
    ResponseEntity<?> addNewCampaign(@RequestBody CampaignRequestDTO campaignRequestDTO);
    ResponseEntity<?> editCampaign(@PathVariable(value = "id") int id, @RequestBody CampaignRequestDTO campaignRequestDTO);
    ResponseEntity<?> getSpecificCampaign(@PathVariable(name = "id") int id);
    ResponseEntity<?> removeCampaign(@PathVariable(value = "id") int id);
    ResponseEntity<Long> getAccountBalance();
}
