package client;

import entity.*;
import adt.*;
import java.util.Date;
import java.util.Scanner;

public class MaintainDonee {

    private LooZXListInterface<Donee> doneeList = new LooZXArrayList<>();
    private WongZJArraylistInterface<Campaign> campaignList = new WongZJArraylist<>();

    private Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public MaintainDonee() {
        initializeDonees();
        initializeCampaigns();
    }

    private void initializeDonees() {
        doneeList.add(new Donee("Individual", "John Doe", "Umemployed during lockdown", "53,Kampung Gurney", "01118981229", new Date(1626294600000l), "Normal"));
        doneeList.add(new Donee("Society", "Home Care Elder Care", "Lack of Food", "88,Kampung Pasir", "02874536223", new Date(1626494600000l), "Normal"));
        doneeList.add(new Donee("Individual", "Johannes", "Umemployed", "53,Kampung Gurney", "01285463772", new Date(1626694600000l), "Normal"));
        doneeList.add(new Donee("Society", "Rumah Kasih Charity Home", "In need of essentials", "12,Taman Bunya", "0182643556", new Date(1626694600000l), "Normal"));
        doneeList.add(new Donee("Individual", "Lim Min", "Affected by pandemic", "11, Bunga Raya", "018912336", new Date(1627694600000l), "Normal"));
    }

    private void initializeCampaigns() {
        campaignList.add(new Campaign("S1", "Donate Blood Campaign"));
        campaignList.add(new Campaign("S2", "White Flag Campaign"));
        campaignList.add(new Campaign("S3", "Fundraising Campaigns"));
        campaignList.add(new Campaign("S4", "Donation Campaigns"));
        campaignList.add(new Campaign("S5", "Money Donation Campaigns"));
    }

    public void displayCampaigns() {
        System.out.println("\n  Available Campaign List\n===========================");
        System.out.println(ANSI_BLUE + " ID      Campaign Name" + ANSI_RESET + "\n===========================");
        for (int i = 1; i <= campaignList.getNumberOfEntries(); i++) {
            System.out.println(" " + campaignList.getEntry(i).getCampaignID() + "  " + campaignList.getEntry(i).getCampaignName());
            System.out.println("");
        }
    }

    public void displayDoneeHeader() {
        System.out.println("==============================================================================================================================================================");
        System.out.print(String.format("%-10s %-12s %-25s %-30s %-30s %-13s %-13s %-8s %-13s\n", "Donee ID", "Type", "Name", "Reason Of Application", "Address", "Contact No", "Reg Date", "Case", "Status"));
        System.out.println("==============================================================================================================================================================");
    }

    public void displayAllDonees() {
        System.out.println("==============================================================================================================================================================");
        System.out.println(ANSI_PURPLE + "                                                                        Donee Details" + ANSI_RESET);
        displayDoneeHeader();
        for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
            System.out.println(doneeList.getEntry(i));
        }
    }

    public void displayParticularDoneeDetails(String type, String id) {
        boolean found = false;
        System.out.println("==============================================================================================================================================================");
        System.out.println(ANSI_PURPLE + "                                                                        Donee Details" + ANSI_RESET);
        displayDoneeHeader();
        for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
            if (doneeList.getEntry(i).getDoneeType().equals(type)) {
                if (doneeList.getEntry(i).getDoneeId().equalsIgnoreCase(id)) {
                    found = true;
                    System.out.println(doneeList.getEntry(i));
                }
            }
        }
        if (!found) {
            System.out.println(ANSI_RED + "                                                                        No record found\n\n" + ANSI_RESET);
        }
    }

    public void DisplayParticularDonee() {
        int choice;
        String id, cont = "";
        do {
            choice = checkInt(scanner, "\n\n--------------------\nFilter Donee By Type\n--------------------\n"
                    + "1. Individual\n2. Society\n3. Exit\nPlease Select Type : ", 3);
            switch (choice) {
                case 1:
                    System.out.println("\nDonee List (Individual Type)");
                    System.out.println("==========================================");
                    System.out.println(String.format("| %-10s | %-25s |", "Donee ID", "Name"));
                    System.out.println("==========================================");
                    for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                        if (doneeList.getEntry(i).getDoneeType().equals("Individual")) {
                            System.out.println(String.format("| %-10s | %-25s |", doneeList.getEntry(i).getDoneeId(),
                                    doneeList.getEntry(i).getName()));
                        }
                    }
                    System.out.println("==========================================");
                    System.out.println("");

                    System.out.print("Please Enter Donee ID to view the details : ");
                    id = scanner.next();
                    displayParticularDoneeDetails("Individual", id);
                    break;

                case 2:
                    System.out.println("\nDonee List (Society Type)");
                    System.out.println("==========================================");
                    System.out.println(String.format("| %-10s | %-25s |", "Donee ID", "Name"));
                    System.out.println("==========================================");
                    for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                        if (doneeList.getEntry(i).getDoneeType().equals("Society")) {
                            System.out.println(String.format("| %-10s | %-25s |", doneeList.getEntry(i).getDoneeId(),
                                    doneeList.getEntry(i).getName()));
                        }
                    }
                    System.out.println("==========================================");
                    System.out.println("");

                    System.out.print("Please Enter Donee ID to view the details : ");
                    id = scanner.next();
                    displayParticularDoneeDetails("Society", id);
                    break;

                case 3:
                    System.out.println(ANSI_BLUE + "Exit this menu..." + ANSI_RESET);
                    break;

                default:
                    System.out.println(ANSI_RED + "Invalid Input.Please select option 1 - 3" + ANSI_RESET);
            }
            System.out.print("Do you want to coninue this process?(y-yes/n-no) ");
            cont = scanner.next();
        } while (choice != 3 && cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
    }

    public void doneeRetrieveMenu() {
        int option;
        String back;
        do {
            option = checkInt(scanner, "\n========================\n      Display Donee\n========================\n"
                    + "1. Retrieve All Donee(s)\n"
                    + "2. Retrieve One Donee\n"
                    + "3. Exit this menu\n"
                    + "Please select one option : ", 3);
            switch (option) {
                case 1:
                    displayAllDonees();
                    System.out.print("Press any key to back to Display Donee Menu ");
                    back = scanner.next();
                    break;
                case 2:
                    DisplayParticularDonee();
                    break;
                case 3:
                    System.out.println(ANSI_BLUE + "Exiting this menu......." + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid input.Please select option 1 - 3" + ANSI_RESET);
            }
        } while (option != 3);
    }

    public void addDonee() {
        String cont, name, reasonOfApplication, address, contactNo, confirmCase;
        int type, position;
        boolean result, checkContactNo, checkName;
        Donee donee = null;

        do {
            System.out.println("========================\n        Add Donee\n========================");

            System.out.print("Please Enter Donee Name : ");
            scanner.nextLine();
            name = scanner.nextLine();
            checkName = validateName(name);
            while (checkName == false) {
                System.out.println(ANSI_RED + "Name can only consists of alphabet i.e Loo Yong Yang" + ANSI_RESET);
                System.out.print("\nPlease Enter Donee Name : ");
                name = scanner.nextLine();
                checkName = validateName(name);
            }

            System.out.print("Please Enter the Reason of Application : ");
            reasonOfApplication = scanner.nextLine();

            System.out.print("Please Enter the Address : ");
            address = scanner.nextLine();

            System.out.print("Please Enter Contact Number : ");
            contactNo = scanner.next();
            checkContactNo = validatePhoneNumber(contactNo);
            while (checkContactNo == false) {
                System.out.println(ANSI_RED + "Contact Number format wrong.Please enter again" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "Format required:\n" + ANSI_BLUE + "- Contact Number must be a number\n" + ANSI_BLUE + "- Length must be between 10-11; i.e 01236543654\n" + ANSI_RESET);
                System.out.print("Please Enter Contact Number : ");
                contactNo = scanner.next();
                checkContactNo = validatePhoneNumber(contactNo);
            }

            do {
                type = checkInt(scanner, "==========\nDonee Type\n==========\nPlease Select Type : \n1.Individual\n2.Society\nPlease select one option : ", 2);
            } while (type == -1);

            System.out.println(ANSI_PURPLE + "\n******************************************************************" + ANSI_RESET);
            System.out.println("Notes: Donee can be add between other donees if the case is urgent");
            System.out.println(ANSI_PURPLE + "******************************************************************" + ANSI_RESET);

            System.out.print("\nIs this an urgent case?(y-yes/n-no) ");
            confirmCase = scanner.next();
            if (confirmCase.charAt(0) == 'Y' || confirmCase.charAt(0) == 'y') {
                System.out.println("\n==========================================");
                System.out.println(ANSI_BLUE + "    Donee applications currently have " + doneeList.getNumberOfEntries() + ANSI_RESET);
                System.out.println("==========================================");
                System.out.println("------------------------------------------");
                System.out.println(String.format("| %-10s | %-25s |", "No.", "Name"));
                System.out.println("------------------------------------------");
                for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                    System.out.println(String.format("| %-10s | %-25s |", i, doneeList.getEntry(i).getName()));

                }
                System.out.println("------------------------------------------");
                do {
                    position = checkInt(scanner, "\nWhich position you will like to insert? : ", doneeList.getNumberOfEntries());
                } while (position == -1);
                switch (type) {
                    case 1:
                        donee = new Donee("Individual", name, reasonOfApplication, address, contactNo, new Date(), "Urgent");
                        break;
                    case 2:
                        donee = new Donee("Society", name, reasonOfApplication, address, contactNo, new Date(), "Urgent");
                        break;
                    default:
                        System.err.println("Please select 1 or 2");
                        break;
                }
                result = doneeList.add(position, donee);
            } else {
                switch (type) {
                    case 1:
                        donee = new Donee("Individual", name, reasonOfApplication, address, contactNo, new Date(), "Normal");
                        break;
                    case 2:
                        donee = new Donee("Society", name, reasonOfApplication, address, contactNo, new Date(), "Normal");
                        break;
                    default:
                        System.err.println("Please select 1 or 2");
                        break;
                }
                result = doneeList.add(donee);
            }

            if (result) {
                System.out.println(ANSI_GREEN + "Donee has been added successfully\n" + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Adding process error\n" + ANSI_RESET);
            }
            System.out.print("Do you want to add another donee?(y-yes/n-no) ");
            cont = scanner.next();
        } while (cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
    }

    public void doneeApproval() {
        String id, cont = "";
        int option;
        boolean found = false;
        do {
            displayAllDonees();
            System.out.print("Please Enter Donee ID to make approval : ");
            id = scanner.next();
            for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                if (doneeList.getEntry(i).getDoneeId().equalsIgnoreCase(id)) {
                    found = true;
                    System.out.println("===========================\n    Donee Status Update\n===========================");
                    option = checkInt(scanner, "Update Donee " + ANSI_BLUE + id + ANSI_RESET + " Status\n---------------------------\n1. Eligible\n2. Ineligible\nPlease select one option : ", 2);
                    switch (option) {
                        case 1:
                            doneeList.getEntry(i).setStatus(ANSI_GREEN + "Eligible" + ANSI_RESET);
                            System.out.println(ANSI_GREEN + "\nDonee Status update successfully" + ANSI_RESET + "\nFeedback : " + id + " application has been approved\n");
                            break;
                        case 2:
                            doneeList.getEntry(i).setStatus(ANSI_RED + "Ineligible" + ANSI_RESET);
                            System.out.println(ANSI_GREEN + "\nDonee Status update successfully" + ANSI_RESET + "\nFeedback : " + id + " application has been rejected\n");
                            break;
                        default:
                            System.out.println(ANSI_RED + "Invalid input." + ANSI_RESET);
                    }
                }
            }

            if (!found) {
                System.out.println(ANSI_RED + "Donee with id " + id + " not found" + ANSI_RESET);
            }
            System.out.print("Do you want to coninue this process?(y-yes/n-no) ");
            cont = scanner.next();
        } while (cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
    }

    public void updateOneInfo(int index, String id) {
        int option, newType;
        String newName, newReason, newContactNo, newAddress, cont = "";
        boolean update = false, checkContactNo, checkName;
        do {
            System.out.println("\n\n=================\nDonee Update Menu\n=================\n"
                    + "1. Update Donee Type\n"
                    + "2. Update Donee Name\n"
                    + "3. Update Reason Of Application\n"
                    + "4. Update Donee Address\n"
                    + "5. Update Donee Contact Number\n"
                    + "6. Exit this menu\n"
            );

            System.out.print("Please select one option : ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    newType = checkInt(scanner, "\nPlease Select new Donee Type :\n1. Individual\n2. Society\nPlease select one option : ", 2);
                    switch (newType) {
                        case 1:
                            doneeList.getEntry(index).setDoneeType("Individual");
                            update = true;
                            break;
                        case 2:
                            doneeList.getEntry(index).setDoneeType("Society");
                            update = true;
                            break;
                        default:
                            System.out.println(ANSI_RED + "Invalid input." + ANSI_RESET);
                    }

                    break;
                case 2:
                    System.out.print("\nPlease enter new Donee Name : ");
                    scanner.nextLine();
                    newName = scanner.nextLine();
                    checkName = validateName(newName);
                    while (checkName == false) {
                        System.out.println(ANSI_RED + "Name can only consists of alphabet i.e Loo Yong Yang" + ANSI_RESET);
                        System.out.print("\nPlease Enter Donee Name : ");
                        newName = scanner.nextLine();
                        checkName = validateName(newName);
                    }
                    doneeList.getEntry(index).setName(newName);
                    update = true;
                    break;
                case 3:
                    System.out.print("\nPlease enter new reason : ");
                    scanner.nextLine();
                    newReason = scanner.nextLine();
                    doneeList.getEntry(index).setReasonOfApplication(newReason);
                    update = true;
                    break;
                case 4:
                    System.out.print("\nPlease enter new Donee Address : ");
                    scanner.nextLine();
                    newAddress = scanner.nextLine();
                    doneeList.getEntry(index).setAddress(newAddress);
                    update = true;
                    break;
                case 5:
                    System.out.print("\nPlease Enter Contact Number : ");
                    newContactNo = scanner.next();
                    checkContactNo = validatePhoneNumber(newContactNo);
                    while (checkContactNo == false) {
                        System.out.println(ANSI_RED + "Contact Number format wrong.Please enter again" + ANSI_RESET);
                        System.out.println(ANSI_BLUE + "Format required:\n" + ANSI_BLUE + "- Contact Number must be a number\n" + ANSI_BLUE + "- Length must be between 10-11; i.e 01236543654\n" + ANSI_RESET);
                        System.out.print("Please Enter Contact Number : ");
                        newContactNo = scanner.next();
                        checkContactNo = validatePhoneNumber(newContactNo);
                    }
                    doneeList.getEntry(index).setContactNo(newContactNo);
                    update = true;
                    break;
                case 6:
                    update = false;
                    System.out.println(ANSI_BLUE + "Exiting this menu.......");
                    break;
                default:
                    System.err.println("Invalid input");
            }
            if (update) {
                System.out.println("\nDonee Information (After Update)");
                displayDoneeHeader();
                System.out.print(doneeList.getEntry(index));
                System.out.print(ANSI_GREEN + "Donee information has been updated successfully" + ANSI_RESET);
            }
            System.out.print("\nDo you want to coninue this process?(y-yes/n-no) ");
            cont = scanner.next();
        } while (option != 6 && cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
    }

    public void updateAllInfo(int index, String id) {
        String name, reasonOfApplication, address, contactNo, newType = "";
        int type;
        boolean checkContactNo, checkName;
        System.out.println("\n====================\nUpdating " + id + " Info\n====================");
        System.out.print("Please Enter Donee Name : ");
        scanner.nextLine();
        name = scanner.nextLine();
        checkName = validateName(name);
        while (checkName == false) {
            System.out.println(ANSI_RED + "Name can only consists of alphabet i.e Loo Yong Yang" + ANSI_RESET);
            System.out.print("\nPlease Enter Donee Name : ");
            name = scanner.nextLine();
            checkName = validateName(name);
        }

        System.out.print("Please Enter the Reason of Application : ");
        reasonOfApplication = scanner.nextLine();

        System.out.print("Please Enter the Address : ");
        address = scanner.nextLine();

        System.out.print("Please Enter Contact Number : ");
        contactNo = scanner.next();
        checkContactNo = validatePhoneNumber(contactNo);
        while (checkContactNo == false) {
            System.out.println(ANSI_RED + "Contact Number format wrong.Please enter again" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "Format required:\n" + ANSI_BLUE + "- Contact Number must be a number\n" + ANSI_BLUE + "- Length must be between 10-11; i.e 01236543654\n" + ANSI_RESET);
            System.out.print("Please Enter Contact Number : ");
            contactNo = scanner.next();
            checkContactNo = validatePhoneNumber(contactNo);
        }

        do {
            type = checkInt(scanner, "Please Select Donee Type : \n1. Individual\n2. Society\nPlease select one option : ", 2);
        } while (type == -1);

        switch (type) {
            case 1:
                newType = "Individual";
                break;
            case 2:
                newType = "Society";
                break;
            default:
                System.err.println("Please select 1 or 2");
                break;
        }
        Donee donee = doneeList.getEntry(index);
        donee.setName(name);
        donee.setDoneeType(newType);
        donee.setReasonOfApplication(reasonOfApplication);
        donee.setAddress(address);
        donee.setContactNo(contactNo);
        Donee updatedEntry = doneeList.setEntry(index, donee);

        System.out.println("\nDonee Information (After Update)");
        displayDoneeHeader();
        System.out.print(updatedEntry);
        System.out.println(ANSI_GREEN + "Donee information has been updated successfully\n" + ANSI_RESET);
    }

    public void updateDonee() {
        int option;
        String id, cont = "";
        boolean found = false;
        do {
            displayAllDonees();
            System.out.print("Please enter a donee id to be updated : ");
            id = scanner.next();
            for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                if (doneeList.getEntry(i).getDoneeId().equalsIgnoreCase(id)) {
                    found = true;
                    do {
                        System.out.println("==================\nDonee Update Menu\n==================\n"
                                + "1. Update one info\n"
                                + "2. Update all info\n"
                                + "3. Exit this menu\n"
                        );
                        option = checkInt(scanner, "Please select one option : ", 3);

                        switch (option) {
                            case 1:
                                updateOneInfo(i, id);
                                break;
                            case 2:
                                updateAllInfo(i, id);
                                break;
                            case 3:
                                System.out.println(ANSI_BLUE + "Exiting this menu......." + ANSI_RESET);
                                break;
                            default:
                                System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
                        }
                    } while (option != 3);
                }
            }

            if (!found) {
                System.out.println(ANSI_RED + "Donee with id " + id + " not found" + ANSI_RESET);
            }

            System.out.print("Do you want to coninue this process?(y-yes/n-no) ");
            cont = scanner.next();

        } while (cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
    }

    public void removeDonee() {
        String id, confirm, cont = "";
        boolean found = false;

        do {
            displayAllDonees();
            System.out.print("Please enter a donee id to be removed : ");
            id = scanner.next();
            for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                if (doneeList.getEntry(i).getDoneeId().equalsIgnoreCase(id)) {
                    Donee removedDonee = doneeList.getEntry(i);
                    found = true;
                    System.out.print("--------------------------------\nDonee " + id + " Preview Information\n--------------------------------\n");
                    displayDoneeHeader();
                    System.out.println(doneeList.getEntry(i));
                    System.out.print("Do you confirm to remove Donee with id " + id + " ?(y-yes/n-no) ");
                    confirm = scanner.next();
                    if (confirm.charAt(0) == 'Y' || confirm.charAt(0) == 'y') {
                        boolean result = doneeList.remove(removedDonee);
                        if (result) {
                            System.out.println("\n" + ANSI_GREEN + "Donee has been removed successfully" + ANSI_RESET);
                            System.out.println("\nDonee List (After Remove)");
                            displayAllDonees();
                        } else {
                            System.out.println(ANSI_RED + "Donee " + id + " remove process failed" + ANSI_RESET);
                        }
                    } else {
                        System.out.println(ANSI_BLUE + "Remove process has been canceled. Thank you." + ANSI_RESET);
                    }
                }
            }

            if (!found) {
                System.out.println(ANSI_RED + "Donee with id " + id + " not found" + ANSI_RESET);
            }

            System.out.print("Do you want to coninue this process?(y-yes/n-no) ");
            cont = scanner.next();
        } while (cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
    }

    public void doneeSearching() {
        int option;
        boolean found = false;
        String id, name, date = "", cont = "";
        do {
            System.out.println("\n======================\n  Search Donee by : \n======================\n1. Donee ID\n2. Donee Name\n3. Registration Date\n4. Exit this menu\n");
            option = checkInt(scanner, "Please select one option : ", 4);

            switch (option) {
                case 1:
                    do {
                        System.out.print("\nPlease Enter Donee ID : ");
                        scanner.nextLine();
                        id = scanner.nextLine();
                        displayDoneeHeader();
                        for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                            if (doneeList.getEntry(i).getDoneeId().equalsIgnoreCase(id)) {
                                found = true;
                                System.out.println(doneeList.getEntry(i) + ANSI_GREEN + "Donee(s) Found. It's position is on " + i + ANSI_RESET + "\n");
                            }
                        }
                        if (found == false) {
                            System.out.println(ANSI_RED + "                                                                        No record found\n\n" + ANSI_RESET);
                        }
                        System.out.print("Do you want to continue this search donee id process?(y-yes/n-no) ");
                        cont = scanner.next();
                        found = false;
                    } while (cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
                    break;
                case 2:
                    do {
                        System.out.print("\nPlease Enter Donee Name : ");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        displayDoneeHeader();
                        for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                            if (doneeList.getEntry(i).getName().equalsIgnoreCase(name)) {
                                found = true;
                                System.out.println(doneeList.getEntry(i) + ANSI_GREEN + "Donee(s) Found. It's position is on " + i + ANSI_RESET + "\n");
                            }
                        }
                        if (found == false) {
                            System.out.println(ANSI_RED + "                                                                        No record found\n\n" + ANSI_RESET);
                        }
                        System.out.print("Do you want to continue this search donee name process?(y-yes/n-no) ");
                        cont = scanner.next();
                        found = false;
                    } while (cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
                    break;
                case 3:
                    do {
                        System.out.print("\nPlease Enter Registration Date : ");
                        scanner.nextLine();
                        date = scanner.nextLine();
                        displayDoneeHeader();
                        for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                            if (doneeList.getEntry(i).getDate().equals(date)) {
                                found = true;
                                System.out.println(doneeList.getEntry(i) + ANSI_GREEN + "Donee(s) Found. It's position is on " + i + ANSI_RESET + "\n");
                            }
                        }
                        if (found == false) {
                            System.out.println(ANSI_RED + "                                                                        No record found\n\n" + ANSI_RESET);
                        }
                        System.out.print("Do you want to continue this search date process?(y-yes/n-no) ");
                        cont = scanner.next();
                        found = false;
                    } while (cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
                    break;
                default:
                    break;
            }
        } while (option != 4);
    }

    public void assignCampaignToDonee() {
        String id, campaignID, cont = "", contInsertCampaign = "";
        boolean found = false, foundCampaign = false;
        do {
            displayAllDonees();
            System.out.print("Please Enter Donee ID to assign campaign : ");
            id = scanner.next();
            for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
                if (doneeList.getEntry(i).getDoneeId().equalsIgnoreCase(id)) {
                    found = true;
                    if (doneeList.getEntry(i).getStatus().equals(ANSI_GREEN + "Eligible" + ANSI_RESET)) {
                        Donee donee = doneeList.getEntry(i);
                        displayCampaigns();
                        do {
                            System.out.print("Please enter campaign ID to be inserted into donee " + id + " :");
                            campaignID = scanner.next();
                            for (int campaign = 1; campaign <= campaignList.getNumberOfEntries(); campaign++) {
                                if (campaignID.equals(campaignList.getEntry(campaign).getCampaignID())) {
                                    foundCampaign = true;
                                    Campaign c = new Campaign(campaignList.getEntry(campaign).getCampaignID(), campaignList.getEntry(campaign).getCampaignName());
                                    donee.assignCampaign(c);
                                    System.out.println(ANSI_GREEN + "Donee has been assigned to campaign " + c.getCampaignName() + "\n" + ANSI_RESET);
                                }
                            }
                            if (!foundCampaign) {
                                System.out.println(ANSI_RED + "Campaign not found." + ANSI_RESET);
                            }
                            System.out.print("\nDo you want to continue assign campaign?(y-yes/n-no) ");
                            contInsertCampaign = scanner.next();
                        } while (contInsertCampaign.charAt(0) == 'Y' || contInsertCampaign.charAt(0) == 'y');
                    } else if (doneeList.getEntry(i).getStatus().equals(ANSI_RED + "Ineligible" + ANSI_RESET)) {
                        System.out.println(ANSI_RED + "Can't assign campaign to donee " + id + " as this donee status is ineligible." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Can't assign campaign to donee " + id + " as this donee status still in pending process." + ANSI_RESET);
                    }
                }
            }

            if (!found) {
                System.out.println(ANSI_RED + "Donee with id " + id + " not found" + ANSI_RESET);
            }

            System.out.print("\nDo you want to continue this process?(y-yes/n-no) ");
            cont = scanner.next();

        } while (cont.charAt(0) == 'Y' || cont.charAt(0) == 'y');
    }

    public void confirmTrimDoneeListSize() {
        String confirm = "", back = "";
        System.out.println("\n===========================\n  List Storage Minimizing\n===========================");
        System.out.println("-------------------------------------------------------------------");
        System.out.println(ANSI_BLUE + "| Notes: This process is for minimizing the internal storage used |\n| by DoneeList"
                + " if there is any unused space in this list          |" + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        System.out.print("\nDo you confirm want to shrink the DoneeList to current size?(y-yes/n-no) ");
        confirm = scanner.next();
        if (confirm.charAt(0) == 'Y' || confirm.charAt(0) == 'y') {
            doneeList.trimToSize();
            System.out.println("\nList size after shrinking              : " + doneeList.getNumberOfEntries()
                    + "\nTotal Number of record(s) in doneeList : " + doneeList.getNumberOfEntries());
            System.out.println("System feedback :" + ANSI_GREEN + " List has been shrink successfully" + ANSI_RESET);
        } else {
            System.out.println("\nSystem feedback : Shrink process has been" + ANSI_RED + " canceled" + ANSI_RESET);
        }
        System.out.print("\nPress any key back to main menu ");
        back = scanner.next();
    }

    public void displaySummaryHeader() {
        System.out.println("\n\n--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(ANSI_PURPLE + "                                                     [   Donee Summary of Easy Donation Application   ]" + ANSI_RESET);
        System.out.println("==============================================================================================================================================================");
        System.out.print(String.format("%-10s %-12s %-25s %-30s %-30s %-13s %-13s %-8s %-13s\n", "Donee ID", "Type", "Name", "Reason Of Application", "Address", "Contact No", "Reg Date", "Case", "Status"));
        System.out.println("==============================================================================================================================================================");
    }

    public void displaySortedDoneeSummary() {
        int option, optionOrder;
        Object[] donee = doneeList.toArray();
        option = checkInt(scanner, "====================\nSort Donee List by :\n==================== \n1. Unsorted\n2. Name\n3. Date\n4. Donee ID\nPlease select option : ", 4);
        switch (option) {
            case 1:
                displayAllDonees();
                break;
            case 2:
                optionOrder = checkInt(scanner, "\n\n=================================\n  Record Sorting Order (Name) :\n================================= \n1. Ascending (Oldest to Latest)\n2. Descending (Latest to Oldest)\nPlease select one option to show the summary : ", 2);
                if (optionOrder == 1) {
                    displaySummaryHeader();
                    doneeList.sort(donee, new Donee.SortDoneeByNameAsc());
                } else {
                    displaySummaryHeader();
                    doneeList.sort(donee, new Donee.SortDoneeByNameDes());
                }
                System.out.println("\n" + LooZXArrayList.toString(donee));
                break;
            case 3:
                optionOrder = checkInt(scanner, "\n\n=================================\n  Record Sorting Order (Date) : \n================================= \n1. Ascending (Oldest to Latest)\n2. Descending (Latest to Oldest)\nPlease select one option to show the summary : ", 2);
                if (optionOrder == 1) {
                    displaySummaryHeader();
                    doneeList.sort(donee, new Donee.SortDoneeByDateAsc());
                } else {
                    displaySummaryHeader();
                    doneeList.sort(donee, new Donee.SortDoneeByDateDes());
                }
                System.out.println("\n" + LooZXArrayList.toString(donee));
                break;
            case 4:
                optionOrder = checkInt(scanner, "\n\n=================================\n   Record Sorting Order (ID) : \n================================= \n1. Ascending (Oldest to Latest)\n2. Descending (Latest to Oldest)\nPlease select one option to show the summary : ", 2);
                if (optionOrder == 1) {
                    displaySummaryHeader();
                    doneeList.sort(donee, new Donee.SortDoneeByIDAsc());
                } else {
                    displaySummaryHeader();
                    doneeList.sort(donee, new Donee.SortDoneeByIDDes());
                }
                System.out.println("\n" + LooZXArrayList.toString(donee));
                break;
            default:
                System.out.println(ANSI_RED + "Please select option 1-3" + ANSI_RESET);
                break;
        }
    }

    public void displayDoneeSummary() {
        String back;
        int countInvidual = 0, countSociety = 0, countNormal = 0, countUrgent = 0, countEligible = 0, countPending = 0, countIneligible = 0;
        for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
            if (doneeList.getEntry(i).getDoneeType().equals("Society")) {
                countSociety++;
            }
            if (doneeList.getEntry(i).getDoneeType().equals("Individual")) {
                countInvidual++;
            }
            if (doneeList.getEntry(i).getCaseLevel().equals("Normal")) {
                countNormal++;
            }
            if (doneeList.getEntry(i).getCaseLevel().equals("Urgent")) {
                countUrgent++;
            }
            if (doneeList.getEntry(i).getStatus().equals(ANSI_GREEN + "Eligible" + ANSI_RESET)) {
                countEligible++;
            }
            if (doneeList.getEntry(i).getStatus().equals(ANSI_RED + "Ineligible" + ANSI_RESET)) {
                countIneligible++;
            }
            if (doneeList.getEntry(i).getStatus().equals("Pending")) {
                countPending++;
            }
        }

        displaySortedDoneeSummary();

        System.out.println(ANSI_PURPLE + "**********************************\n"
                + " Total number of Donee involved: " + doneeList.getNumberOfEntries()
                + "\n**********************************" + ANSI_RESET);
        System.out.println("Details Number View of Donee Status : ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("               Pending              :               Eligible              :              Ineligible             ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("                  " + countPending + "                 :                  " + countEligible + "                  :                   " + countIneligible);

        System.out.println("\nDetails Number View of Donee Type : ");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("              Individual            :               Society               ");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("                  " + countInvidual + "                 :                  " + countSociety);

        System.out.println("\nDetails Number View of Case Level : ");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("              Normal                :                 Urgent              ");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("                 " + countNormal + "                  :                  " + countUrgent);

        System.out.print("\nPress any key to back to main menu ");
        back = scanner.next();
    }

    public void displayDoneeMainMenu() {
        int choice;
        do {
            choice = checkInt(scanner, "\n=========================================================\n"
                    + "                Donee Management Main Menu      \n"
                    + "=========================================================\n"
                    + "1.  Add Donee\n"
                    + "2.  Update Donee\n"
                    + "3.  Search Donee\n"
                    + "4.  Retrieve Donee\n"
                    + "5.  Remove Donee\n"
                    + "6.  Donee Application Approval\n"
                    + "7.  Donee Campaign Assignment\n"
                    + "8.  Donee Information Summary\n"
                    + "9.  DoneeList Storage Minimization (Internal System Usage)\n"
                    + "10. Exit Donee Management Main Menu\n\nPlease enter choice : ", 10);

            switch (choice) {
                case 1:
                    addDonee();
                    break;
                case 2:
                    updateDonee();
                    break;
                case 3:
                    doneeSearching();
                    break;
                case 4:
                    doneeRetrieveMenu();
                    break;
                case 5:
                    removeDonee();
                    break;
                case 6:
                    doneeApproval();
                    break;
                case 7:
                    assignCampaignToDonee();
                    break;
                case 8:
                    displayDoneeSummary();
                    break;
                case 9:
                    confirmTrimDoneeListSize();
                    break;
                case 10:
                    System.out.println(ANSI_BLUE + "Exiting Donee Management Main menu..." + ANSI_RESET);
                    break;
                case 11:
                    System.out.println(ANSI_RED + "Invalid Input" + ANSI_RESET);
                    break;
            }
        } while (choice != 10);
    }


    /* Choice & Option Validation Part  */
    public int checkInt(Scanner scanner, String prompt, int noOfChoice) {
        int checkIsValidInt = -1;
        while (checkIsValidInt < 0) {
            System.out.print(prompt);
            String input = scanner.next();

            try {
                checkIsValidInt = Integer.valueOf(input);
                if (checkIsValidInt <= 0 || checkIsValidInt > noOfChoice) {
                    System.out.println(ANSI_RED + "Invalid Input. Input must be between 1 - " + noOfChoice + ANSI_RESET + "\n");
                    checkIsValidInt = -1;
                }
            } catch (NumberFormatException ex) {
                checkIsValidInt = -1;
                System.out.println(ANSI_RED + "Invalid Input. It must be a number." + ANSI_RESET + "\n");
            }
        }
        return checkIsValidInt;
    }

    private static boolean validatePhoneNumber(String phoneNo) {
        return phoneNo.matches("\\d{10,11}"); //allow only 10-11 digits
    }

    private static boolean validateName(String name) {
        return name.matches("[a-zA-Z][a-zA-Z ]*"); //allow only alphabets and space
    }

    public static void main(String[] args) {
        MaintainDonee donee = new MaintainDonee();
        donee.displayDoneeMainMenu();
    }
}
