/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class Donor implements Comparable<Donor>, Serializable {

    private String donorID;
    private String donorType;
    private String donorName;
    private String donorAddress;
    private String contactNo;
    private Date regDate;
    private static int numDonor = 0;

    private ChowSHListInterface<Donation> donationList;

    public Donor() {
    }

    public Donor(String donorID) {
        this.donorID = donorID;
    }

    public Donor(int donorType, String donorName, String donorAddress, String contactNo) {
        numDonor++;
        int id = 1000 + numDonor;
        Date date = new Date();

        this.donorID = "C" + Integer.toString(id);
        if (donorType == 1) {
            this.donorType = "Individual";
        } else {
            this.donorType = "Corporate";
        }

        this.donorName = donorName;
        this.donorAddress = donorAddress;
        this.contactNo = contactNo;
        this.regDate = date;

    }

    public String getDonorID() {
        return donorID;
    }

    public String getDonorType() {
        return donorType;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getDonorAddress() {
        return donorAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public Date getRegDate() {

        return regDate;
    }

    public ChowSHListInterface<Donation> getDonationList() {
        return donationList;
    }

    public double getTotalDonationAmount() {
        double totalDonationAmount = 0.0;

        if (donationList != null) {
            for (int i = 1; i <= donationList.size(); i++) {
                if (donationList.get(i).getDonar().compareTo(this) == 0) {
                    totalDonationAmount += donationList.get(i).getDonationCash();
                }
            }
        }

        return totalDonationAmount;

    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public void setDonorAddress(String donorAddress) {
        this.donorAddress = donorAddress;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public void setdonationList(ChowSHListInterface<Donation> donationList) {
        this.donationList = donationList;
    }

    @Override
    public int compareTo(Donor o) {
        if (this.donorID.compareTo(o.donorID) > 0) {
            return 1;
        } else if (this.donorID.equals(o.donorID)) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Donor ID              :" + donorID
                + "\nDonor Type            :" + donorType
                + "\nDonor Name            :" + donorName
                + "\nAddress               :" + donorAddress
                + "\nContact Number        :" + contactNo
                + "\nRegister Date         :" + dateFormat.format(regDate);

    }

}
