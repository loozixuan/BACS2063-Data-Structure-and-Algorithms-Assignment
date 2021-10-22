/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ChowSHComparableLinkedList;
import adt.LeeSMLinkedList;
import entity.Campaign;
import entity.Donation;
import entity.DonationItem;
import entity.Donor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class DonationDriver {

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date todayDate = new Date();

        LeeSMLinkedList<Donor> donorList = new LeeSMLinkedList<Donor>();
        Donor donor1 = new Donor(1, "John", "11,Jalan Lobak 10", "010-6661031");
        Donor donor2 = new Donor(1, "Xiao Ming", "11,Jalan Lobak 10", "010-6661031");
        donorList.add(donor1);
        donorList.add(donor2);

        ChowSHComparableLinkedList<DonationItem> donationItemList = new ChowSHComparableLinkedList<>();
        donationItemList.add(new DonationItem("Milo (500g)", 2));
        donationItemList.add(new DonationItem("Rice (2kg)", 2));

        ArrayList<Campaign> campaignList = new ArrayList<Campaign>();
        Campaign campaign1 = new Campaign("C1001", "Loving");
        Campaign campaign2 = new Campaign("C1002", "Beautiful");
        campaignList.add(campaign1);
        campaignList.add(campaign2);

        ChowSHComparableLinkedList<Donation> donationList = new ChowSHComparableLinkedList<>();
        Donation donation1 = new Donation("DONATION1001", donor1, campaign1, donationItemList, 250.00, todayDate);
        Donation donation2 = new Donation("DONATION1002", donor2, campaign1, donationItemList, 250.00, todayDate);;
        Donation donation3 = new Donation("DONATION1003", donor2, campaign1, donationItemList, 250.00, todayDate);;
        donationList.add(donation1);
        donationList.add(donation2);
        donationList.add(donation3);

        donor1.setdonationList(new ChowSHComparableLinkedList<Donation>());
        donor1.getDonationList().add(donation1);
        donor2.setdonationList(new ChowSHComparableLinkedList<Donation>());
        donor2.getDonationList().add(donation2);
        donor2.getDonationList().add(donation3);

        donationUI(donationList, donorList, campaignList);
    }

    public static void donationUI(ChowSHComparableLinkedList<Donation> donationList, LeeSMLinkedList<Donor> donorList, ArrayList<Campaign> campaignList) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Donation");
            System.out.print("==================================\n");
            System.out.println("1. Donation History");
            System.out.println("2. Make Donation");
            System.out.println("3. Search Donation");
            System.out.println("4. Back to Home Page\n");
            System.out.print("Please select a option (Eg. 1) : ");
            String option = scan.nextLine();
            while (!option.equalsIgnoreCase("1") && !option.equalsIgnoreCase("2") && !option.equalsIgnoreCase("3") && !option.equalsIgnoreCase("4")) {
                System.out.print("Invalid input\n\n");
                System.out.print("Please select a option (Eg. 1) : ");
                option = scan.nextLine();
            }
            switch (option) {
                case "1":
                    System.out.print("\n");
                    viewDonation(donationList, donorList, campaignList);
                    System.out.print("\n");
                    break;
                case "2":
                    System.out.print("\n");
                    makeDonation(donationList, donorList, campaignList);
                    System.out.print("\n");
                    break;
                case "3":
                    System.out.print("\n");
                    searchDonation(donationList, donorList, campaignList);
                    System.out.print("\n");
                    break;
                case "4":
                    exit = true;
                    break;
            }
        }
    }

    public static void viewDonation(ChowSHComparableLinkedList<Donation> donationList, LeeSMLinkedList<Donor> donorList, ArrayList<Campaign> campaignList) {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        boolean exit = false;
        while (!exit) {
            if (donationList.size() > 0) {
                System.out.println(String.format("%-3s%-15s%-15s%-17s%-15s", "No", "Donation ID", "Donar Name", "Campaign Name", "Donation Date"));
            }
            for (int i = 1; i <= donationList.size(); i++) {
                Donation donation = donationList.get(i);
                Donor donor = donation.getDonar();
                Campaign campaign = donation.getCampaign();
                System.out.println(String.format("%-3d%-15s%-15s%-17s%-15s", i, donation.getDonationID(), donor.getDonorName(), campaign.getCampaignName(), formatter.format(donation.getDonationDate())));
            }
            System.out.print("\n");
            boolean invalid = true;
            while (invalid) {
                System.out.print("Enter donation number to view details (E.g: 1) / Enter N to exit : ");
                String option = scan.nextLine();
                if (option.equalsIgnoreCase("N")) {
                    exit = true;
                    invalid = false;
                } else {
                    try {
                        Donation donation = donationList.get(Integer.parseInt(option));
                        if (donation == null) {
                            System.out.print("Out of range\n\n");
                        } else {
                            System.out.print("\n");
                            viewDonationDetails(donationList, donation, donorList, campaignList);
                            System.out.print("\n");
                            invalid = false;

                        }
                    } catch (Exception ex) {
                        System.out.print("Invalid Input\n\n");
                    }
                }
            }

        }
    }

    public static void makeDonation(ChowSHComparableLinkedList<Donation> donationList, LeeSMLinkedList<Donor> donorList, ArrayList<Campaign> campaignList) {
        Scanner scan = new Scanner(System.in);
        Donor donor = null;

        System.out.print("Do you want to make donation? (Y = Yes / N = No) : ");
        String option = scan.nextLine();
        while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
            System.out.print("Invalid Input\n\n");
            System.out.print("Do you want to make donation? (Y = Yes / N = No) : ");
            option = scan.nextLine();
        }

        if (option.equalsIgnoreCase("Y")) {
            System.out.print("Had you make the donation before? (Y = Yes / N = No) : ");
            option = scan.nextLine();
            while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
                System.out.print("Invalid Input\n");
                System.out.print("Had you make the donation before? (Y = Yes / N = No) : ");
                option = scan.nextLine();
            }
            if (option.equalsIgnoreCase("N")) {
                System.out.print("Select your donor type (1 = Individual / 2 = Corporate) : ");
                String donorType = scan.nextLine();
                while (!donorType.equalsIgnoreCase("1") && !donorType.equalsIgnoreCase("2")) {
                    System.out.print("Invalid Input\n");
                    System.out.print("Select your donor type (1 = Individual / 2 = Corporate) : ");
                    donorType = scan.nextLine();
                }
                System.out.print("Please enter your name: ");
                String donarName = scan.nextLine();
                System.out.print("Please enter your address: ");
                String donarAddress = scan.nextLine();
                System.out.print("Please enter your contact No: ");
                String donarContactNo = scan.nextLine();
                donor = new Donor(Integer.parseInt(donorType), donarName, donarAddress, donarContactNo);
            } else {
                do {
                    System.out.print("Enter your donor ID : ");
                    String donarID = scan.nextLine();
                    donor = donorList.search(new Donor(donarID));
                    if (donor != null) {
                        option = "N";
                    } else {
                        System.out.print("The donor is not found\n");
                        System.out.print("Try again? (Y = Yes / N = No) : ");
                        option = scan.nextLine();
                        while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
                            System.out.print("Invalid Input\n\n");
                            System.out.print("Try again? (Y = Yes / N = No) : ");
                            option = scan.nextLine();
                        }
                    }
                } while (option.equalsIgnoreCase("Y"));
            }

            if (donor != null) {
                String donationID = "DONATION" + (1000 + donationList.size());
                ChowSHComparableLinkedList<DonationItem> donationItemList = new ChowSHComparableLinkedList<>();
                Donation donation = new Donation(donationID);
                Campaign campaign = null;
                do {
                    System.out.print("Campaign ID   : ");
                    String campaignID = scan.nextLine();

                    boolean found = false;
                    for (int i = 0; i < campaignList.size(); i++) {
                        if (campaignID.equalsIgnoreCase(campaignList.get(i).getCampaignID())) {
                            campaign = campaignList.get(i);
                            found = true;
                        }
                    }
                    if (found == true) {
                        option = "N";
                    } else {
                        System.out.print("The campaign is not found\n");
                        System.out.print("Try again? (Y = Yes / N = No) : ");
                        option = scan.nextLine();
                        while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
                            System.out.print("Invalid Input\n\n");
                            System.out.print("Try again? (Y = Yes / N = No) : ");
                            option = scan.nextLine();
                        }
                    }
                } while (option.equalsIgnoreCase("Y"));

                if (campaign != null) {
                    boolean add;
                    do {
                        System.out.print("Donation Item : ");
                        String donationItem = scan.nextLine();
                        int quantity = 0;
                        boolean pass = false;
                        do {
                            try {
                                System.out.print("Quantity      : ");
                                quantity = scan.nextInt();
                                scan.nextLine();
                                if (quantity <= 0) {
                                    System.out.print("Invalid quantity\n");
                                } else {
                                    pass = true;
                                }
                            } catch (InputMismatchException ex) {
                                System.out.print("Invalid Input\n");
                                scan.nextLine();
                            }
                        } while (!pass);
                        donationItemList.add(new DonationItem(donationItem, quantity));
                        System.out.print("Do you still want to donate other items? (Y = Yes / N = No) : ");
                        option = scan.nextLine();
                        while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
                            System.out.print("Invalid Input\n");
                            System.out.print("Do you want to donate other item? (Y = Yes / N = No) : ");
                            option = scan.nextLine();
                        }
                        if (option.equalsIgnoreCase("Y")) {
                            add = true;
                        } else {
                            add = false;
                        }
                    } while (add);
                    System.out.print("Do you want to donate cash? (Y = Yes / N = No) : ");
                    option = scan.nextLine();
                    while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
                        System.out.print("Invalid Input\n");
                        System.out.print("Do you want to donate cash? (Y = Yes / N = No) : ");
                        option = scan.nextLine();
                    }
                    double amount = 0;
                    if (option.equalsIgnoreCase("Y")) {
                        boolean pass = false;
                        do {
                            try {
                                System.out.print("Cash donated amount (RM) : ");
                                amount = scan.nextDouble();
                                scan.nextLine();
                                if (amount <= 0) {
                                    System.out.print("Invalid amount\n");
                                } else {
                                    pass = true;
                                }
                            } catch (InputMismatchException ex) {
                                System.out.print("Invalid Input\n");
                                scan.nextLine();
                            }
                        } while (!pass);
                    }
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date todayDate = new Date();
                    donation.setCampaign(campaign);
                    donation.setDonar(donor);
                    donation.setDonationCash(amount);
                    donation.setdonationItemList(donationItemList);
                    donation.setDonationDate(todayDate);
                    donationList.add(donation);
                    if (donor.getDonationList() == null) {
                        donor.setdonationList(new ChowSHComparableLinkedList<Donation>());
                        donorList.add(donor);
                    }
                    donor.getDonationList().add(donation);
                }
            }
        }
    }

    public static void searchDonation(ChowSHComparableLinkedList<Donation> donationList, LeeSMLinkedList<Donor> donorList, ArrayList<Campaign> campaignList) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("Please enter donation ID or N to exit : ");
            String donationID = scan.next();
            if (!donationID.equalsIgnoreCase("N")) {
                Donation donationSearch = new Donation(donationID);
                Donation donationResult = donationList.contains(donationSearch);
                if (donationResult != null) {
                    System.out.print("\n");
                    viewDonationDetails(donationList, donationResult, donorList, campaignList);
                    System.out.print("\n");
                } else {
                    System.out.print("The donation you search does not exist.\n\n");
                }
            } else {
                exit = true;
            }
        }
    }

    public static void viewDonationDetails(ChowSHComparableLinkedList<Donation> donationList, Donation donation, LeeSMLinkedList<Donor> donorList, ArrayList<Campaign> campaignList) {
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        while (!exit) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.print(String.format("%-12s%-15s", "Donation ID       : ", donation.getDonationID()));
            System.out.print(String.format("%-15s%-15s\n", "Donation Name : ", donation.getDonar().getDonorName()));
            System.out.print(String.format("%-12s%-15s", "Campaign          : ", donation.getCampaign().getCampaignName()));
            System.out.print(String.format("%-15s%-15s\n", "Donation Date : ", formatter.format(donation.getDonationDate())));
            System.out.print(String.format("%-12s%-15.2f\n\n", "Cash Donated (RM) : ", donation.getDonationCash()));

            System.out.println(String.format("%-17s%-3s", "Donation Item", "Quantity"));
            System.out.println("----------------------------------");
            for (int i = 1; i <= donation.getdonationItemList().size(); i++) {
                DonationItem donationItem = donation.getdonationItemList().get(i);
                System.out.println(String.format("%-17s%-3d", donationItem.getItem(), donationItem.getQuantity()));
            }
            System.out.print("\nEdit (1) / Delete (2) / Exit (3) : ");
            String option = scan.nextLine();
            while (!option.equalsIgnoreCase("1") && !option.equalsIgnoreCase("2") && !option.equalsIgnoreCase("3")) {
                System.out.print("Invalid Input\n\n");
                System.out.print("Edit (1) / Delete (2) / Exit (3) : ");
                option = scan.nextLine();
            }
            switch (option) {
                case "1":
                    System.out.print("\n");
                    editDonation(donation, donorList, campaignList);
                    break;
                case "2":
                    System.out.print("Are you sure to delete this donation? (Y = Yes / N = No) : ");
                    String confirmation = scan.nextLine();
                    if (confirmation.equalsIgnoreCase("Y")) {
                        donation.getDonar().getDonationList().remove(donation);
                        donationList.remove(donation);
                        exit = true;
                    } else if (confirmation.equalsIgnoreCase("N")) {

                    } else {
                        System.out.print("Invalid Input\n");
                    }
                    break;
                case "3":
                    exit = true;
                    break;
            }
        }
    }

    public static void editDonation(Donation donation, LeeSMLinkedList<Donor> donorList, ArrayList<Campaign> campaignList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Donor");
        System.out.println("2. Campaign");
        System.out.println("3. Donation Item");
        System.out.println("4. Donation Cash");
        System.out.println("5. Exit");
        System.out.print("Which field do you want to edit? : ");
        String option = scan.nextLine();
        while (!option.equalsIgnoreCase("1") && !option.equalsIgnoreCase("2") && !option.equalsIgnoreCase("3") && !option.equalsIgnoreCase("4") && !option.equalsIgnoreCase("5")) {
            System.out.print("Invalid Input\n");
            System.out.print("Which field do you want to edit? : ");
            option = scan.nextLine();
        }
        System.out.print("\n");

        switch (option) {
            case "1":
                Donor oldDonor = donation.getDonar();
                Donor newDonor = null;
                do {
                    System.out.print("Enter New Donor ID : ");
                    String donarID = scan.nextLine();
                    newDonor = donorList.search(new Donor(donarID));
                    if (newDonor != null) {
                        System.out.print("Are you sure you want to change donor? (Y = Yes / N = No) : ");
                        String confirmation = scan.nextLine();
                        while (!confirmation.equalsIgnoreCase("Y") && !confirmation.equalsIgnoreCase("N")) {
                            System.out.print("Invalid Input");
                            System.out.print("Are you sure you want to change donor? (Y = Yes / N = No) : ");
                            confirmation = scan.nextLine();
                        }
                        if (confirmation.equalsIgnoreCase("Y")) {
                            oldDonor.getDonationList().remove(donation);
                            donation.setDonar(newDonor);
                        }
                        option = "N";
                        System.out.print("\n");
                    } else {
                        System.out.print("The donor is not found\n");
                        System.out.print("Try again? (Y = Yes / N = No) : ");
                        option = scan.nextLine();
                        while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
                            System.out.print("Invalid Input\n\n");
                            System.out.print("Try again? (Y = Yes / N = No) : ");
                            option = scan.nextLine();
                        }
                    }
                } while (option.equalsIgnoreCase("Y"));
                break;
            case "2":
                Campaign campaign = null;
                System.out.print("Enter New Camaign ID : ");
                String campaignID = scan.nextLine();
                boolean found = false;
                for (int i = 1; i <= campaignList.size() && found == false; i++) {
                    if (campaignList.get(i).getCampaignID().equalsIgnoreCase(campaignID)) {
                        campaign = campaignList.get(i);
                        found = true;
                    }
                }
                if (found == true) {
                    System.out.print("Are you sure you want to change the campaign? (Y = Yes / N = No) : ");
                    String confirmation = scan.nextLine();
                    while (!confirmation.equalsIgnoreCase("Y") && !confirmation.equalsIgnoreCase("N")) {
                        System.out.print("Invalid Input");
                        System.out.print("Are you sure you want to change the campaign? (Y = Yes / N = No) : ");
                        confirmation = scan.nextLine();
                    }
                    if (confirmation.equalsIgnoreCase("Y")) {
                        donation.setCampaign(campaign);
                    }
                    option = "N";
                } else {
                    System.out.print("The campaign is not found\n");
                    System.out.print("Try again? (Y = Yes / N = No) : ");
                    option = scan.nextLine();
                    while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
                        System.out.print("Invalid Input\n\n");
                        System.out.print("Try again? (Y = Yes / N = No) : ");
                        option = scan.nextLine();
                    }
                }
                break;
            case "3":
                do {
                    System.out.println(String.format("%-5s%-17s%-3s", "", "Donation Item", "Quantity"));
                    System.out.println("----------------------------------");
                    for (int i = 1; i <= donation.getdonationItemList().size(); i++) {
                        DonationItem donationItem = donation.getdonationItemList().get(i);
                        System.out.println(String.format("%-5s%-17s%-3d", i, donationItem.getItem(), donationItem.getQuantity()));
                    }
                    System.out.print("\n");
                    boolean again = true;
                    do {
                        System.out.print("Select the item you want to edit (E.g. 1 or 2) / N = exit: ");
                        option = scan.nextLine();
                        if (!option.equalsIgnoreCase("N")) {
                            try {
                                int position = Integer.parseInt(option);
                                if (position > 0 && position <= donation.getdonationItemList().size()) {
                                    DonationItem donationItem = donation.getdonationItemList().get(position);
                                    System.out.print("Edit Item Name (1) or Quantity (2) : ");
                                    option = scan.nextLine();
                                    while (!option.equalsIgnoreCase("1") && !option.equalsIgnoreCase("2")) {
                                        System.out.print("Invalid Input\n");
                                        System.out.print("Edit Item Name (1) or Quantity (2) : ");
                                        option = scan.nextLine();
                                    }
                                    if (option.equalsIgnoreCase("1")) {
                                        System.out.print("Enter New Donation Item Name : ");
                                        String donationItemName = scan.nextLine();
                                        System.out.print("Are you sure you want to change the donation item name? (Y = Yes / N = No) : ");
                                        String confirmation = scan.nextLine();
                                        while (!confirmation.equalsIgnoreCase("Y") && !confirmation.equalsIgnoreCase("N")) {
                                            System.out.print("Invalid Input\n");
                                            System.out.print("Are you sure you want to change the donation item name? (Y = Yes / N = No) : ");
                                            confirmation = scan.nextLine();
                                        }
                                        if (confirmation.equalsIgnoreCase("Y")) {
                                            donationItem.setItem(donationItemName);
                                        }
                                    } else {
                                        int quantity = 0;
                                        boolean pass = false;
                                        do {
                                            try {
                                                System.out.print("Enter New Quantity : ");
                                                quantity = scan.nextInt();
                                                scan.nextLine();
                                                if (quantity <= 0) {
                                                    System.out.print("Invalid quantity\n");
                                                } else {
                                                    System.out.print("Are you sure you want to change the donation item quantity? (Y = Yes / N = No) : ");
                                                    String confirmation = scan.nextLine();
                                                    while (!confirmation.equalsIgnoreCase("Y") && !confirmation.equalsIgnoreCase("N")) {
                                                        System.out.print("Invalid Input\n");
                                                        System.out.print("Are you sure you want to change the donation item quantity? (Y = Yes / N = No) : ");
                                                        confirmation = scan.nextLine();
                                                    }
                                                    if (confirmation.equalsIgnoreCase("Y")) {
                                                        donationItem.setQuantity(quantity);
                                                    }
                                                    pass = true;
                                                }
                                            } catch (InputMismatchException ex) {
                                                System.out.print("Invalid Input\n");
                                                scan.nextLine();
                                            }
                                        } while (!pass);
                                    }
                                    again = false;
                                } else {
                                    System.out.print("Out of range\n");
                                }
                                System.out.print("Do you want to edit other item? (Y = Yes / N = No) : ");
                                option = scan.nextLine();
                                while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
                                    System.out.print("Invalid Input\n");
                                    System.out.print("Do you want to edit other item? (Y = Yes / N = No) : ");
                                    option = scan.nextLine();
                                }
                                System.out.print("\n");
                            } catch (Exception ex) {
                                System.out.print("Invalid Input\n");
                            }
                        } else {
                            again = false;
                        }
                    } while (again);
                } while (option.equalsIgnoreCase("Y"));
                break;
            case "4":
                double amount = 0.0;
                boolean pass = false;
                do {
                    try {
                        System.out.print("Enter New Cash Donated Amount (RM) : ");
                        amount = scan.nextDouble();
                        scan.nextLine();
                        if (amount <= 0) {
                            System.out.print("Invalid amount\n");
                        } else {
                            pass = true;
                            System.out.print("Are you sure you want to change the cash donated amount? (Y = Yes/ N = No) : ");
                            String confirmation = scan.nextLine();
                            while (!confirmation.equalsIgnoreCase("Y") && !confirmation.equalsIgnoreCase("N")) {
                                System.out.print("Invalid Input\n");
                                System.out.print("Are you sure you want to change the cash donated amount? (Y = Yes/ N = No) : ");
                                confirmation = scan.nextLine();
                            }
                            if (confirmation.equalsIgnoreCase("Y")) {
                                donation.setDonationCash(amount);
                            }
                        }
                    } catch (InputMismatchException ex) {
                        System.out.print("Invalid Input\n");
                        scan.nextLine();
                    }
                } while (!pass);
                break;
        }
    }
}
