package learnprogramming;

import java.util.HashMap;
import java.util.Scanner;

public class ChoiceABB { // Choose Company

    public void company_query(String comp_name){
        System.out.println();
        System.out.println("Welcome "+comp_name);
        System.out.println("   1) Update Role");
        System.out.println("   2) Update Package");
        System.out.println("   3) Update CGPA criteria");
        System.out.println("   4) Register To Institute Drive");
        System.out.println("   5) Back");
        System.out.print("Enter your choice: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        if(n==1){
            System.out.print("Enter new role: ");
            String role=sc.nextLine();
            Institute_Placement_Cell.Add_company_record.get(comp_name).setRole(role);
            System.out.println("Role for "+comp_name+" has been updated!!");
        }
        else if(n==2){
            System.out.print("Enter new package offer: ");
            double package_offer=sc.nextDouble();
            Institute_Placement_Cell.Add_company_record.get(comp_name).setPackage_offer(package_offer);
            System.out.println("Package offer for "+comp_name+" has been updated!!");
        }
        else if(n==3){
            System.out.print("Enter new CGPA criterion: ");
            double cgpa=sc.nextDouble();
            Institute_Placement_Cell.Add_company_record.get(comp_name).setCgpa_req(cgpa);
            System.out.println("CGPA criterion for "+comp_name+" has been updated!!");
        }
        else if(n==4){
            System.out.println("Enter the current time:");
            System.out.println("Enter the registration date and time in the format yyyy/MM/dd HH:mm");
            String k=sc.nextLine();
            if(k.compareTo(Institute_Placement_Cell.op_com_date)>=0 && k.compareTo(Institute_Placement_Cell.cl_com_date)<=0){
                Institute_Placement_Cell.Add_company_record.get(comp_name).setTime(k);
                Institute_Placement_Cell.reg_company(Institute_Placement_Cell.Add_company_record.get(comp_name));
                System.out.println("Successfully Registered!!!");
            }
            else{
                System.out.println("Sorry not allowed to register!!!");
            }
        }
        else if(n==5){// goes back to choice ab
            System.out.println();
            ChoiceAB cs_ab=new ChoiceAB();
            cs_ab.main();
        }
        else{
            System.out.println("Entered an invalid choice type again.");
            company_query(comp_name);
        }
        company_query(comp_name);
    }
    public void input_ABB(){
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of company to enter into mode of Available Companies:-");
        int i=1;
        for (HashMap.Entry<String,Company> entry : Institute_Placement_Cell.Add_company_record.entrySet()){
            System.out.println("   "+i+") "+entry.getKey());
            i++;
        }
        System.out.print("-> ");
        String comp_name=sc.nextLine();
        company_query(comp_name);
    }
    public void main(){
        this.input_ABB();
    }
}
