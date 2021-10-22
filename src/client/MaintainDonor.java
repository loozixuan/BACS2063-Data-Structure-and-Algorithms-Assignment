/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.*;
import entity.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Chrisann Lee
 */
public class MaintainDonor {

    Date todayDate = new Date();

    //Donor List
    private LeeSMListInterface<Donor> donorList = new LeeSMLinkedList<>();

    //Donation List and DonationItem List that need to add to donor
    private ChowSHListInterface<Donation> donationList = new ChowSHComparableLinkedList<>();
    private ChowSHListInterface<Donation> donationList2 = new ChowSHComparableLinkedList<>();
    private ChowSHListInterface<Donation> donationList3 = new ChowSHComparableLinkedList<>();
    private ChowSHListInterface<Donation> donationList4 = new ChowSHComparableLinkedList<>();
    private ChowSHListInterface<Donation> donationList5 = new ChowSHComparableLinkedList<>();
    private ChowSHListInterface<Donation> donationList6 = new ChowSHComparableLinkedList<>();
    private ChowSHListInterface<Donation> donationList7 = new ChowSHComparableLinkedList<>();
    private ChowSHListInterface<Donation> donationList8 = new ChowSHComparableLinkedList<>();
    private ChowSHComparableLinkedList<DonationItem> donationItemList = new ChowSHComparableLinkedList<>();

    private void initializeDonor() {
        Donor donor1 = new Donor(1, "John", "11,Jalan Lobak 10", "010-2223678");
        Donor donor2 = new Donor(1, "Lee", "22,Jalan Merak 4", "012-6678987");
        Donor donor3 = new Donor(1, "Paul", "11,Jalan Lobak 22", "010-6661031");
        Donor donor4 = new Donor(1, "Max", "11,Jalan TSR 7", "010-6661031");
        Donor donor5 = new Donor(1, "William", "11,Jalan Blossom", "010-6661031");
        Donor donor6 = new Donor(2, "DHL Seremban", "No 46, Jalan Tampin, Taman Bukit Emas", "06-679 6396");
        Donor donor7 = new Donor(2, "SG Seremban", "49, Jalan Toman 4, Kemayan Square", "017-6445678");
        Donor donor8 = new Donor(2, "OSSB Seremban", "No. 447, Jalan Haruan 4/3", "010-6556789");

        //Set donor's donationList
        donor1.setdonationList(donationList);
        donor2.setdonationList(donationList2);
        donor3.setdonationList(donationList3);
        donor4.setdonationList(donationList4);
        donor5.setdonationList(donationList5);
        donor6.setdonationList(donationList6);
        donor7.setdonationList(donationList7);
        donor8.setdonationList(donationList8);

        //add Donor to Donor List
        donorList.add(donor1);
        donorList.add(donor2);
        donorList.add(donor3);
        donorList.add(donor4);
        donorList.add(donor5);
        donorList.add(donor6);
        donorList.add(donor7);
        donorList.add(donor8);

        //Item and Campaign need to add to donation
        donationItemList.add(new DonationItem("Milo (500g)", 2));
        donationItemList.add(new DonationItem("Rice (2kg)", 2));
        Campaign campaign1 = new Campaign("C1001", "Loving");
        Campaign campaign2 = new Campaign("C1002", "Beautiful");

        DonationItem item1 = new DonationItem("Book", 2);
        Donation donation1 = new Donation("DONATION1001", donor1, campaign1, donationItemList, 250.00, todayDate);
        Donation donation2 = new Donation("DONATION1002", donor1, campaign2, donationItemList, 250.00, todayDate);
        Donation donation3 = new Donation("DONATION1003", donor2, campaign1, donationItemList, 250.00, todayDate);
        Donation donation4 = new Donation("DONATION1004", donor3, campaign2, donationItemList, 750.00, todayDate);
        Donation donation5 = new Donation("DONATION1005", donor4, campaign1, donationItemList, 850.00, todayDate);
        Donation donation6 = new Donation("DONATION1006", donor5, campaign2, donationItemList, 150.00, todayDate);
        Donation donation7 = new Donation("DONATION1007", donor6, campaign1, donationItemList, 1150.00, todayDate);
        Donation donation8 = new Donation("DONATION1008", donor7, campaign1, donationItemList, 2250.00, todayDate);
        Donation donation9 = new Donation("DONATION1009", donor8, campaign2, donationItemList, 3550.00, todayDate);

        //donationList for each of the donor
        donationList.add(donation1);
        donationList.add(donation2);
        donationList2.add(donation3);
        donationList3.add(donation4);
        donationList4.add(donation5);
        donationList5.add(donation6);
        donationList6.add(donation7);
        donationList7.add(donation8);
        donationList8.add(donation9);

    }

    public MaintainDonor() {
        initializeDonor();
    }

    public static void main(String[] args) {

        MaintainDonor m = new MaintainDonor();
        m.displayDonorMenu();
    }

    public void displayDonorMenu() {

        Date todayDate = new Date();

        //Donor
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        int option = 0;
        boolean continueInput = true;
        do {
            do {

                try {
                    System.out.println("========================================================");
                    System.out.println("                    DONOR MAINTENANCE  ");
                    System.out.println("========================================================");
                    System.out.println("1. Donor Registration");
                    System.out.println("2. Edit Donor");
                    System.out.println("3. Retrieve Donor");
                    System.out.println("4. Delete Donor");
                    System.out.println("5. Donor Report");
                    System.out.println("6. Exit");
                    System.out.print("Enter option:");

                    option = scan.nextInt();
                    continueInput = false;

                } catch (Exception ex) {
                    System.err.println("Invalid Input\n");
                    scan.nextLine();
                }

            } while (continueInput);

            switch (option) {
                case 1:

                    addDonor(donorList);
                    break;
                case 2:
                    editDonor(donorList);
                    break;
                case 3:
                    retrieveDonor(donorList);
                    break;
                case 4:
                    deleteDonor(donorList);
                    break;
                case 5:
                    generateReport(donorList);
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Please select 1,2,3,4 or 5.");
                    scan.nextLine();
                    break;

            }

        } while (option != 6);
    }

    public static void addDonor(LeeSMListInterface<Donor> donorList) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        boolean validate = false;
        char confirmAdd;
        String phoneNo = "";
        String address = "";
        String name = "";
        int donorType = 0;
        String donorTypeString = "";
        boolean continueAdd = true;
        //Donor Type
        do {
            System.out.println("\n========================================================");
            System.out.println("                    DONOR REGISTRATION  ");
            System.out.println("========================================================");
            try {
                System.out.print("Select Donor Type [1=Individual; 2= Corporate] :");
                donorType = scan.nextInt();
                if (donorType != 1 && donorType != 2) {
                    System.err.println("Please enter \"1\" or \"2\" only");
                    scan.nextLine();
                }
            } catch (Exception ex) {
                System.err.println("Invalid Input");
                scan.nextLine();
            }
        } while (donorType != 1 && donorType != 2);

        //Name
        do {
            System.out.print("Enter name:");
            name = scan.next();
            for (int i = 0; i < name.length(); i++) {
                if (!Character.isLetter(name.charAt(i))) {
                    validate = false;
                } else {
                    validate = true;
                }
            }
            if (validate == false) {
                System.err.println("Invalid Donor Name");
            }

        } while (validate != true);

        //Phone
        do {
            do {
                try {
                    System.out.print("Enter phone number:");
                    phoneNo = scan.next();
                    scan.nextLine();
                    validate = validatePhoneNo(phoneNo);
                    if (validate == false) {
                        System.err.println("Phone number requires 10 or 11 digits.");
                    } else {
                        continueAdd = false;
                    }
                } catch (Exception ex) {
                    System.err.println("Invalid Input");
                    scan.nextLine();
                }
            } while (continueAdd);
        } while (validate != true);

        //Address
        System.out.print("Enter Address :");
        address = scan.next();

        //Donor entered details
        System.out.println("\n-----------------------");
        System.out.println("    Donor Details");
        System.out.println("-----------------------");
        if (donorType == 1) {
            donorTypeString = "Individual";
        } else {
            donorTypeString = "Corporate";
        }
        System.out.println("Donor Type :" + donorTypeString);
        System.out.println("Donor Name :" + name);
        System.out.println("Contact Number :" + phoneNo);
        System.out.println("Address :" + address);

        do {
            System.out.print("\nAre you confirm to add donor (Y-Yes/N-No):");
            confirmAdd = scan.next().charAt(0);
            if (Character.toUpperCase(confirmAdd) == 'Y') {

                donorList.add(new Donor(donorType, name, address, phoneNo));

                System.out.println("*New Donor has been added.*");
                System.out.println("\n--------------------------------------------------------");
                System.out.println("                  Donor Details");
                System.out.println("--------------------------------------------------------");
                System.out.println(donorList.getEntry(donorList.getNumberOfEntries()));
                System.out.print("\nEnter any key to go back to main page :");
                String any = scan.next();
            } else {
                System.err.println("Please enter \"Y\" or \"N\" only");
            }

        } while (Character.toUpperCase(confirmAdd) != 'Y' && Character.toUpperCase(confirmAdd) != 'N');

    }

    public static void deleteDonor(LeeSMListInterface<Donor> donorList) {

        Scanner scan = new Scanner(System.in);
        char cont = ' ';
        String donorDeleteID = "";
        Donor deletedDonor = new Donor();
        System.out.println("\n========================================================");
        System.out.println("                       DELETE DONOR  ");
        System.out.println("========================================================");
        do {
            System.out.print("Enter a Donor ID:");
            donorDeleteID = scan.next();

            if (donorList.search(new Donor(donorDeleteID)) != null) {

                int count = donorList.getPosition(new Donor(donorDeleteID));
                deletedDonor = donorList.remove(count);
                System.out.println("\n--------------------------------------------------------");
                System.out.println("                      Deleted Donor  ");
                System.out.println("--------------------------------------------------------");
                System.out.println(deletedDonor.toString());

            } else {
                System.err.println("\nNo record for " + donorDeleteID);

            }
            System.out.print("Do you want to continue?(Y-Yes/N-No) :");
            cont = scan.next().charAt(0);
            System.out.println("--------------------------------------------------------\n");

        } while (Character.toUpperCase(cont) == 'Y');

    }

    public static void editDonor(LeeSMListInterface<Donor> donorList) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        boolean validate = false;
        boolean continueInput = true;
        boolean continueAdd = true;
        int optionEdit = 0;
        char confirmUpdate = ' ';
        char cont = ' ';
        String editID = "";
        Donor editDonor = new Donor();
        int positionDonor = 0;

        String newName = "";
        String newContact = "";
        String newAddress = "";
        int newDonorType = 0;
        String newDonorTypeString = "";

        System.out.println("\n========================================================");
        System.out.println("                       EDIT DONOR  ");
        System.out.println("========================================================");
        do {
            System.out.print("Enter a Donor ID:");
            editID = scan.next();

            if (donorList.search(new Donor(editID)) != null) {

                positionDonor = donorList.getPosition(new Donor(editID));;
                editDonor = donorList.search(new Donor(editID));
                System.out.println("\n--------------------------------------------------------");
                System.out.println("                      Donor Details  ");
                System.out.println("--------------------------------------------------------");
                System.out.println(editDonor.toString());

                //Edit Selection
                do {
                    do {
                        try {
                            System.out.println("\n            Edit Selection          ");
                            System.out.println("-------------------------------------");
                            System.out.println("1.Edit Name");
                            System.out.println("2.Edit Contact Number");
                            System.out.println("3.Edit Donor Type");
                            System.out.println("4.Edit Address");
                            System.out.println("5.Edit All Details");
                            System.out.println("6.Exit");

                            System.out.print("Enter option :");
                            optionEdit = scan.nextInt();
                            continueInput = false;

                        } catch (Exception ex) {
                            System.err.println("Invalid Input\n");
                            scan.nextLine();
                        }

                    } while (continueInput);

                    switch (optionEdit) {
                        case 1:
                            do {
                                System.out.print("\nEnter new name:");
                                newName = scan.next();
                                for (int i = 0; i < newName.length(); i++) {
                                    if (!Character.isLetter(newName.charAt(i))) {
                                        validate = false;
                                    } else {
                                        validate = true;
                                    }
                                }
                                if (validate == false) {
                                    System.err.println("Invalid Donor Name");
                                }

                            } while (validate != true);

                            System.out.print("Confirm update? (Y-Yes/N-No):");
                            confirmUpdate = scan.next().charAt(0);
                            if (Character.toUpperCase(confirmUpdate) == 'Y') {
                                editDonor.setDonorName(newName);
                                donorList.edit(editDonor, positionDonor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Donor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(donorList.search(new Donor(editID)).toString());
                            } else {
                                System.out.println("\n*Donor Details remain unchange*\n");
                                System.out.println("--------------------------------------------------------\n");
                                positionDonor = donorList.getPosition(new Donor(editID));;
                                editDonor = donorList.search(new Donor(editID));
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                      Donor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(editDonor.toString());
                            }

                            break;
                        case 2:
                            do {
                                do {
                                    try {
                                        System.out.print("\nEnter new contact number:");
                                        newContact = scan.next();
                                        scan.nextLine();
                                        validate = validatePhoneNo(newContact);
                                        if (validate == false) {
                                            System.err.println("Phone number requires 10 or 11 digits.");
                                        } else {
                                            continueAdd = false;
                                        }
                                    } catch (Exception ex) {
                                        System.err.println("Invalid Input");
                                        scan.nextLine();
                                    }
                                } while (continueAdd);
                            } while (validate != true);
                            System.out.print("Confirm update? (Y-Yes/N-No):");
                            confirmUpdate = scan.next().charAt(0);
                            if (Character.toUpperCase(confirmUpdate) == 'Y') {
                                editDonor.setContactNo(newContact);
                                donorList.edit(editDonor, positionDonor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Donor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(donorList.search(new Donor(editID)).toString());
                            } else {
                                System.out.println("\n*Donor Details remain unchange*\n");
                                System.out.println("--------------------------------------------------------\n");
                            }

                            break;
                        case 3:
                            do {
                                try {
                                    System.out.print("\nSelect Donor Type [1=Individual; 2= Corporate] :");
                                    newDonorType = scan.nextInt();
                                    if (newDonorType != 1 && newDonorType != 2) {
                                        System.err.println("Please enter \"1\" or \"2\" only");
                                    }

                                } catch (Exception ex) {
                                    System.err.println("Invalid Input");
                                    scan.nextLine();
                                }

                            } while (newDonorType != 1 && newDonorType != 2);
                            if (newDonorType == 1) {
                                newDonorTypeString = "Individual";
                            } else {
                                newDonorTypeString = "Corporate";
                            }
                            System.out.print("Confirm update? (Y-Yes/N-No):");
                            confirmUpdate = scan.next().charAt(0);
                            if (Character.toUpperCase(confirmUpdate) == 'Y') {
                                editDonor.setDonorType(newDonorTypeString);
                                donorList.edit(editDonor, positionDonor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Donor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(donorList.search(new Donor(editID)).toString());
                            } else {
                                System.out.println("\n*Donor Details remain unchange*\n");
                                System.out.println("--------------------------------------------------------\n");
                            }

                            break;
                        case 4:
                            System.out.println("\nEnter new address :");
                            newAddress = scan.next();
                            System.out.print("Confirm update? (Y-Yes/N-No):");
                            confirmUpdate = scan.next().charAt(0);
                            if (Character.toUpperCase(confirmUpdate) == 'Y') {
                                editDonor.setDonorAddress(newAddress);
                                donorList.edit(editDonor, positionDonor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Donor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(donorList.search(new Donor(editID)).toString());
                            } else {
                                System.out.println("\n*Donor Details remain unchange*\n");
                                System.out.println("--------------------------------------------------------\n");
                            }

                            break;

                        case 5:
                            //New Name
                            do {
                                System.out.print("\nEnter new name:");
                                newName = scan.next();
                                for (int i = 0; i < newName.length(); i++) {
                                    if (!Character.isLetter(newName.charAt(i))) {
                                        validate = false;
                                    } else {
                                        validate = true;
                                    }
                                }
                                if (validate == false) {
                                    System.err.println("Invalid Donor Name");
                                }

                            } while (validate != true);

                            //New Contact Number
                            do {
                                do {
                                    try {
                                        System.out.print("Enter new contact number:");
                                        newContact = scan.next();
                                        scan.nextLine();
                                        validate = validatePhoneNo(newContact);
                                        if (validate == false) {
                                            System.err.println("Phone number requires 10 or 11 digits.");
                                        } else {
                                            continueAdd = false;
                                        }
                                    } catch (Exception ex) {
                                        System.err.println("Invalid Input");
                                        scan.nextLine();
                                    }
                                } while (continueAdd);
                            } while (validate != true);

                            //New Donor Type
                            do {
                                try {
                                    System.out.print("Select Donor Type [1=Individual; 2= Corporate] :");
                                    newDonorType = scan.nextInt();
                                    if (newDonorType != 1 && newDonorType != 2) {
                                        System.err.println("Please enter \"1\" or \"2\" only");
                                    }

                                } catch (Exception ex) {
                                    System.err.println("Invalid Input");
                                    scan.nextLine();
                                }

                            } while (newDonorType != 1 && newDonorType != 2);
                            if (newDonorType == 1) {
                                newDonorTypeString = "Individual";
                            } else {
                                newDonorTypeString = "Corporate";
                            }

                            //New Address
                            System.out.print("Enter new address :");
                            newAddress = scan.next();

                            editDonor.setDonorName(newName);
                            editDonor.setContactNo(newContact);
                            editDonor.setDonorType(newDonorTypeString);
                            editDonor.setDonorAddress(newAddress);
                            System.out.print("Confirm update? (Y-Yes/N-No):");
                            confirmUpdate = scan.next().charAt(0);
                            if (Character.toUpperCase(confirmUpdate) == 'Y') {
                                donorList.edit(editDonor, positionDonor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Donor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(donorList.search(new Donor(editID)).toString());
                            } else {
                                System.out.println("\n*Donor Details remain unchange*\n");
                                System.out.println("--------------------------------------------------------\n");
                            }

                            break;
                        case 6:
                            break;
                        default:
                            System.err.println("Please select 1,2,3,4 or 5.");
                            scan.nextLine();
                            break;

                    }
                } while (optionEdit != 6);

            } else {
                System.err.println("No record for " + editID);
            }
            System.out.print("\nDo you want to continue edit other donor?(Y-Yes/N-No) :");
            cont = scan.next().charAt(0);
            System.out.println("--------------------------------------------------------\n");

        } while (Character.toUpperCase(cont) == 'Y');

    }

    public static void retrieveDonor(LeeSMListInterface<Donor> donorList) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);
        char cont = ' ';
        String retrieveID = "";
        Donor retrieveDonor = new Donor();
        System.out.println("\n========================================================");
        System.out.println("                       RETRIEVE DONOR  ");
        System.out.println("========================================================");
        do {

            System.out.print("Enter a Donor ID:");
            retrieveID = scan.next();

            if (donorList.search(new Donor(retrieveID)) != null) {

                retrieveDonor = donorList.search(new Donor(retrieveID));
                System.out.println("\n--------------------------------------------------------");
                System.out.println("                      Donor Details  ");
                System.out.println("--------------------------------------------------------");
                System.out.println(retrieveDonor.toString());
                if (retrieveDonor.getDonationList() != null) {
                    System.out.println("Total Donation Amount :RM" + retrieveDonor.getTotalDonationAmount());
                    for (int i = 1; i <= retrieveDonor.getDonationList().size(); i++) {

                        System.out.printf("\n                     Donation %d                      \n", i);
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Donation ID               :" + retrieveDonor.getDonationList().get(i).getDonationID());
                        System.out.println("Donation Date             :" + dateFormat.format(retrieveDonor.getDonationList().get(i).getDonationDate()));
                        System.out.println("Campaign                  :" + retrieveDonor.getDonationList().get(i).getCampaign().getCampaignName());
                        System.out.println("Total Donation Amount(RM) :" + retrieveDonor.getDonationList().get(i).getDonationCash());
                        System.out.printf("\n                   Donation Item %d                      \n", i);
                        System.out.println("--------------------------------------------------------");
                        for (int j = 1; j <= retrieveDonor.getDonationList().get(i).getdonationItemList().size(); j++) {
                            DonationItem donationItem = retrieveDonor.getDonationList().get(i).getdonationItemList().get(j);
                            System.out.printf("%-15s %4d\n", donationItem.getItem(), donationItem.getQuantity());
                        }
                    }

                }

            } else {
                System.err.println("\nNo record for " + retrieveID);
            }
            System.out.print("\nDo you want to continue?(Y-Yes/N-No) :");
            cont = scan.next().charAt(0);
            System.out.println("--------------------------------------------------------\n");

        } while (Character.toUpperCase(cont) == 'Y');
    }

    public static void generateReport(LeeSMListInterface<Donor> donorList) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int optionReport = 0;
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        boolean continueInput = true;
        String any = "";

        do {
            do {
                try {
                    System.out.println("\n========================================================");
                    System.out.println("                       DONOR REPORT  ");
                    System.out.println("========================================================");
                    System.out.println("1.Donor Report (Ascending - Donor ID)");
                    System.out.println("2.Donor Report (Descending -Donor ID)");
                    System.out.println("3.Donor Report (Individual)");
                    System.out.println("4.Donor Report (Corporate)");
                    System.out.println("5.Exit");
                    System.out.print("Enter option :");
                    optionReport = scan.nextInt();
                    continueInput = false;
                    scan.nextLine();
                } catch (Exception ex) {
                    System.err.println("Invalid Input\n");
                    scan.nextLine();
                }

            } while (continueInput);

            switch (optionReport) {
                case 1:

                    System.out.println("\n======================================================================================================================================");
                    System.out.println("                                                               DONOR REPORT(ASCENDING)");
                    System.out.println("======================================================================================================================================");
                    System.out.println("| ID      | NAME              | CONTACT NO.         | ADDRESS                                      | REG DATE       | DONATION AMOUNT | ");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                    for (int i = 1; i <= donorList.getNumberOfEntries(); i++) {
                        System.out.printf("|%-9s| %-18s| %-20s| %-45s| %-15s| RM %-13.2f|\n", donorList.getEntry(i).getDonorID(), donorList.getEntry(i).getDonorName(), donorList.getEntry(i).getContactNo(), donorList.getEntry(i).getDonorAddress(), dateFormat.format(donorList.getEntry(i).getRegDate()), donorList.getEntry(i).getTotalDonationAmount());
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.print("Enter any key go back to report menu :");
                    any = scan.next();
                    break;
                case 2:
                    LeeSMListInterface<Donor> donorListSort = new LeeSMLinkedList<>();
                    for (int i = 1; i <= donorList.getNumberOfEntries(); i++) {
                        donorListSort.add(donorList.getEntry(i));
                    }
                    donorListSort.selectionSortDesc();
                    System.out.println("\n======================================================================================================================================");
                    System.out.println("                                                       DONOR REPORT(DESCENDING)");
                    System.out.println("======================================================================================================================================");
                    System.out.println("| ID      | NAME              | CONTACT NO.         | ADDRESS                                      | REG DATE       | DONATION AMOUNT | ");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                    for (int i = 1; i <= donorListSort.getNumberOfEntries(); i++) {
                        System.out.printf("|%-9s| %-18s| %-20s| %-45s| %-15s| RM %-13.2f|\n", donorListSort.getEntry(i).getDonorID(), donorListSort.getEntry(i).getDonorName(), donorListSort.getEntry(i).getContactNo(), donorListSort.getEntry(i).getDonorAddress(), dateFormat.format(donorListSort.getEntry(i).getRegDate()), donorListSort.getEntry(i).getTotalDonationAmount());
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.print("Enter any key go back to report menu :");
                    any = scan.next();
                    break;
                case 3:
                    System.out.println("\n======================================================================================================================================");
                    System.out.println("                                                       DONOR REPORT(Individual)");
                    System.out.println("======================================================================================================================================");
                    System.out.println("| ID      | NAME              | CONTACT NO.         | ADDRESS                                      | REG DATE       | DONATION AMOUNT | ");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                    for (int i = 1; i <= donorList.getNumberOfEntries(); i++) {
                        if (donorList.getEntry(i).getDonorType().equalsIgnoreCase("Individual")) {
                            System.out.printf("|%-9s| %-18s| %-20s| %-45s| %-15s| RM %-13.2f|\n", donorList.getEntry(i).getDonorID(), donorList.getEntry(i).getDonorName(), donorList.getEntry(i).getContactNo(), donorList.getEntry(i).getDonorAddress(), dateFormat.format(donorList.getEntry(i).getRegDate()), donorList.getEntry(i).getTotalDonationAmount());

                        }
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.print("Enter any key go back to report menu :");
                    any = scan.next();
                    break;
                case 4:
                    System.out.println("\n======================================================================================================================================");
                    System.out.println("                                                        DONOR REPORT(Corporate)");
                    System.out.println("======================================================================================================================================");
                    System.out.println("| ID      | NAME              | CONTACT NO.         | ADDRESS                                      | REG DATE       | DONATION AMOUNT | ");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                    for (int i = 1; i <= donorList.getNumberOfEntries(); i++) {
                        if (donorList.getEntry(i).getDonorType().equalsIgnoreCase("Corporate")) {
                            System.out.printf("|%-9s| %-18s| %-20s| %-45s| %-15s| RM %-13.2f|\n", donorList.getEntry(i).getDonorID(), donorList.getEntry(i).getDonorName(), donorList.getEntry(i).getContactNo(), donorList.getEntry(i).getDonorAddress(), dateFormat.format(donorList.getEntry(i).getRegDate()), donorList.getEntry(i).getTotalDonationAmount());

                        }
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.print("Enter any key go back to report menu :");
                    any = scan.next();
                    break;
                case 5:
                    break;

                default:
                    System.err.println("Please select 1,2,3,4 or 5.");
                    scan.nextLine();
                    break;
            }

        } while (optionReport != 5);

    }

    public static boolean validatePhoneNo(String validatePhoneNo) {
        boolean validPhone = false;
        if (validatePhoneNo.length() < 10 || validatePhoneNo.length() > 11) {
            validPhone = false;
        } else {
            for (int i = 0; i < validatePhoneNo.length(); i++) {
                char ch = validatePhoneNo.charAt(i);
                if (!Character.isDigit(ch)) {
                    validPhone = false;
                } else {
                    validPhone = true;
                }
            }
        }
        return validPhone;

    }
}
