package entity;

import adt.WongZJArraylist;

public class Campaign {

    String campaignID;
    String campaignName;
    WongZJArraylist<Location> locations;
    String contactNo;
    String reason;
    String resourceNeeded;
    String status;

    public Campaign() {

    }

    public Campaign(String campaignID, String campaignName, String contactNo, String reason, String resourceNeeded, String status) {
        this.campaignID = campaignID;
        this.campaignName = campaignName;
        this.locations = new WongZJArraylist<Location>();
        this.contactNo = contactNo;
        this.reason = reason;
        this.resourceNeeded = resourceNeeded;
        this.status = status;
    }

    public Campaign(String campaignID, String campaignName) {
        this.campaignID = campaignID;
        this.campaignName = campaignName;
    }

    public String getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(String campaignID) {
        this.campaignID = campaignID;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public WongZJArraylist<Location> getLocations() {
        return locations;
    }

    public void setLocations(WongZJArraylist<Location> locations) {
        this.locations = locations;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResourceNeeded() {
        return resourceNeeded;
    }

    public void setResourceNeeded(String resourceNeeded) {
        this.resourceNeeded = resourceNeeded;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    @Override
    public String toString() {
        return campaignID + " " + campaignName;
    }

}
