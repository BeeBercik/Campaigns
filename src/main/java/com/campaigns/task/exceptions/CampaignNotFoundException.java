package com.campaigns.task.exceptions;

public class CampaignNotFoundException extends RuntimeException {
    public CampaignNotFoundException(String message) {
        super(message);
    }
}
