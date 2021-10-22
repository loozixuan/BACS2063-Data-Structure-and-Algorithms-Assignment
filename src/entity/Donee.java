package entity;

import adt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Donee {

    private static int numberOfDonees;
    private String doneeId;
    private String doneeType;
    private String name;
    private String reasonOfApplication;
    private String address;
    private String contactNo;
    private Date regDate;
    private String caseLevel;
    private String status;
    private WongZJArraylistInterface<Campaign> campaignList;

    public Donee() {
        campaignList = new WongZJArraylist<>();
    }

    public Donee(String doneeType, String name, String reasonOfApplication,
            String address, String contactNo, Date regDate, String caseLevel) {
        numberOfDonees++;
        int doneeNumber = 1000 + numberOfDonees;
        this.doneeId = "DE" + doneeNumber;
        this.doneeType = doneeType;
        this.name = name;
        this.reasonOfApplication = reasonOfApplication;
        this.address = address;
        this.contactNo = contactNo;
        this.regDate = regDate;
        this.status = "Pending";
        this.caseLevel = caseLevel;
        campaignList = new WongZJArraylist<>();
    }

    public String getDoneeId() {
        return doneeId;
    }

    public static int getNumberOfDonees() {
        return numberOfDonees;
    }

    public static void setNumberOfDonees(int numberOfDonees) {
        Donee.numberOfDonees = numberOfDonees;
    }

    public String getDoneeType() {
        return doneeType;
    }

    public void setDoneeType(String doneeType) {
        this.doneeType = doneeType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getRegDate() {
        return this.regDate;
    }

    public String getDate() {
        //change the date into desired format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(this.regDate);
        return date;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonOfApplication() {
        return reasonOfApplication;
    }

    public void setReasonOfApplication(String reasonOfApplication) {
        this.reasonOfApplication = reasonOfApplication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaseLevel() {
        return caseLevel;
    }

    public void setCaseLevel(String caseLevel) {
        this.caseLevel = caseLevel;
    }

    public WongZJArraylistInterface<Campaign> getCampaignList() {
        return this.campaignList;
    }

    public void setCampaignList(WongZJArraylistInterface<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public void assignCampaign(Campaign campaign) {
        campaignList.add(campaign);
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //change the date into desired format
        String date = simpleDateFormat.format(this.regDate);

        String str = String.format("%-10s %-12s %-25s %-30s %-30s %-13s %-13s %-8s %-13s\n" + "Campaign Information of " + this.doneeId + " :" + "\n%s\n",
                this.doneeId, this.doneeType, this.name, this.reasonOfApplication, this.address, this.contactNo, date, this.caseLevel, this.status, this.campaignList
        );
        return str;
    }

    public static class SortDoneeByNameAsc implements LComparator<Donee> {

        @Override
        public int compare(Donee d1, Donee d2) {
            return d1.getName().compareTo(d2.getName());
        }
    }

    public static class SortDoneeByNameDes implements LComparator<Donee> {

        @Override
        public int compare(Donee d1, Donee d2) {
            return d2.getName().compareTo(d1.getName());
        }
    }

    public static class SortDoneeByDateAsc implements LComparator<Donee> {

        @Override
        public int compare(Donee d1, Donee d2) {
            return d1.getRegDate().compareTo(d2.getRegDate());
        }
    }

    public static class SortDoneeByDateDes implements LComparator<Donee> {

        @Override
        public int compare(Donee d1, Donee d2) {
            return d2.getRegDate().compareTo(d1.getRegDate());
        }
    }

    public static class SortDoneeByIDAsc implements LComparator<Donee> {

        @Override
        public int compare(Donee d1, Donee d2) {
            return d1.getDoneeId().compareTo(d2.getDoneeId());
        }
    }

    public static class SortDoneeByIDDes implements LComparator<Donee> {

        @Override
        public int compare(Donee d1, Donee d2) {
            return d2.getDoneeId().compareTo(d1.getDoneeId());
        }
    }
}
