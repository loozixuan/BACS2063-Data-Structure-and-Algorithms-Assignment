/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import adt.*;
/**
 *
 * @author Chow Sing Hong
 */
public class Donation implements Comparable<Donation>{
    private String donationID;
    private Donor donar;
    private Campaign campaign;
    private ChowSHComparableLinkedList<DonationItem> donationItemList;
    private double donationCash;
    private Date donationDate;

    public Donation(String donationID) {
        this.donationID = donationID;
    }


    public Donation(String donationID, Donor donar, Campaign campaign, ChowSHComparableLinkedList<DonationItem> donationItemList, double donationCash, Date donationDate) {
        this.donationID = donationID;
        this.donar = donar;
        this.campaign = campaign;
        this.donationItemList = donationItemList;
        this.donationCash = donationCash;
        this.donationDate = donationDate;
    }

    public String getDonationID() {
        return donationID;
    }

    public Donor getDonar() {
        return donar;
    }

    public void setDonar(Donor donar) {
        this.donar = donar;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public ChowSHComparableLinkedList<DonationItem> getdonationItemList() {
        return donationItemList;
    }

    public void setdonationItemList(ChowSHComparableLinkedList<DonationItem> donationItemList) {
        this.donationItemList = donationItemList;
    }

    public double getDonationCash() {
        return donationCash;
    }

    public void setDonationCash(double donationCash) {
        this.donationCash = donationCash;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public int compareTo(Donation donation) {
        return donationID.compareTo(donation.getDonationID());
    }

    @Override
    public String toString() {
        return "Donation ID\t: " + donationID + 
                "\nDonor\t\t: " + donar.getDonorID() + 
                "\nCampaign\t\t: " + campaign.getCampaignID() + 
                "\n" + donationItemList + 
                "Donation Cash\t: " + donationCash + 
                "\nDonationDate\t: " + donationDate + "\n\n";
    }
}
