package client;

import adt.WongZJArraylist;
import entity.Campaign;
import entity.Location;
import utility.Support;


public class Campaignmodule {
    
    static WongZJArraylist <Campaign> campaigns = new WongZJArraylist <Campaign>();
	static Location l1=new Location("Selangor","Pertaling Jaya", "Tan Building");
        static Location l2=new Location("Negeri Sembilan","Seremban", "Lee Building");

	public static void main(String[] args) {
            
            
            campaigns.add(new Campaign("S1","Animal Campaign","06-2345678","Not enough money to buy food","money","Still available"));
            campaigns.add(new Campaign("S2","Nursing Home Campaign","06-2345678","Not enough money to buy food","money","Still available"));
            campaigns.add(new Campaign("S3","Orphanage Campaign","06-2345678","Not enough money to buy clothes","clothes","Not available"));
            campaigns.add(new Campaign("S4","Help Individual Family Campaign","06-2345678","Not enough money to buy food","food","Not available"));
            campaigns.add(new Campaign("S5","B Campaign","06-2345678","Not enough money to buy food","food","Not available"));
            campaigns.getEntry(1).addLocation(l1);
            campaigns.getEntry(2).addLocation(l2);
            campaigns.getEntry(3).addLocation(l1);
            campaigns.getEntry(4).addLocation(l2);
            campaigns.getEntry(5).addLocation(l1);
            
            Campaignmodule c= new Campaignmodule();
            c.start();
        }
        


                private void start() {
		
		menu();
		int option =-1;
		
		while(option !=5) {
			option = Support.readInt("Enter Option > ");
			
			if (option ==1) {
				addcampaign();
			}
			else if(option ==2) {
				editcampaign();
			}
			else if (option ==3) {
				deletecampaign();
			}
			
			else if (option ==4) {
				showcampaign();
			}
			else if (option ==5) {
				System.out.println("Quit");
			}
			
			
		}
		
}
                private void menu() {
                    
		System.out.println("                    Maintenance Campaign                                ");
        System.out.println("******************************************************************************");
        System.out.println("1. Add Campaign");
        System.out.println("2. Edit Campaign");
        System.out.println("3. Delete Campaign");
        System.out.println("4. Display All Campaign");
        System.out.println("5. Exit");
        
	
	
	}
                
                private void showcampaign() {

     
                       

               
		 System.out.println("                              Campaign List                                     ");
                 System.out.println("************************************************************************************");
                 System.out.println("       Campaign ID     |      Campaign Name        |     Contact No      ");

                for(int k=0;k<campaigns.size();k++){
                       String output1 = String.format("No.%d %10s  %27s  %35s",(k+1),campaigns.getEntry(k+1).getCampaignID(),
                               campaigns.getEntry(k+1).getCampaignName(),
                               campaigns.getEntry(k+1).getContactNo()+"\n"+
                               "Resource Needed:"+campaigns.getEntry(k+1).getResourceNeeded()+"\n"+
                               "Status:"+campaigns.getEntry(k+1).getStatus()+"\n"+
                               "Reason:"+campaigns.getEntry(k+1).getReason()+"\n"+
                               campaigns.getEntry(k+1).getLocations()+"\n"+
                               "************************************************************************************");
                       System.out.println("************************************************************************************");
                       System.out.println(output1);


                }
            
             
	}
                private void deletecampaign() {


                     String deletecampaigns = Support.readString("Enter product id to delete campaign >");
                     int check = 0;
	       
                 
	        for (int x = 0; x<campaigns.size();x++) {
	            if (deletecampaigns.equalsIgnoreCase(campaigns.getEntry(x+1).getCampaignID())) {
	            	campaigns.remove(x+1);
	                System.out.println("Campaign successfully deleted");
                        check++;
                        Campaignmodule c= new Campaignmodule();
                        c.start();
                        break;
         }
	        }
                if(check == 0){
                    System.out.println("Campaign do not exist!");
                }
      }

	
                 
                 
         
         
	private void editcampaign() {

		String prodID = Support.readString("Enter Campaign ID to edit > ");
		
		for (int i=0;i<campaigns.size();i++) {
			if (prodID.equalsIgnoreCase(campaigns.getEntry(i+1).getCampaignID())) {
				
				String name = Support.readString("Enter new Campaign Name >");
				String contact = Support.readString("Enter new Contact No >");
				String reason = Support.readString("Enter new Reason >");
                                String reasourceneeded = Support.readString("Enter new Resource Needed >");
                                String status = Support.readString("Enter new Status >");
				

				campaigns.getEntry(i+1).setCampaignName(name);
				campaigns.getEntry(i+1).setContactNo(contact);
				campaigns.getEntry(i+1).setReason(reason);
                                campaigns.getEntry(i+1).setResourceNeeded(reasourceneeded);
                                campaigns.getEntry(i+1).setStatus(status);
                                
                                System.out.println("Campaign ID : " + campaigns.getEntry(i).getCampaignID() + " has been updated");
                                Campaignmodule c= new Campaignmodule();
                                c.start();
                        }}
        }

        
        
        
        private void addcampaign() {       

        String campaignID = Support.readString("Enter Campaign ID >");
        String campaignName = Support.readString("Enter Campaign Name >");
        String contactNo = Support.readString("Enter Contact No >");
        String reason = Support.readString("Enter Reason >");
        String resourceNeeded = Support.readString("Enter Resource Needed >");
        String status = Support.readString("Enter Status >");
        
        
        Campaign p = new Campaign(campaignID, campaignName,contactNo,reason,resourceNeeded,status);
        Location location = null;
        char confirm ='y';
        do {
            String state = Support.readString("Enter State >");
            String city = Support.readString("Enter City >");
            String building = Support.readString("Enter Building >");
            location = new Location(state, city, building);
            p.addLocation(location);
            confirm = Support.readChar("do you want to continue add location? (y/n)");
            
        } while (Character.toLowerCase(confirm) == 'y');
        campaigns.add(p);

    }

        
        
        
        

        }
        
