package learnprogramming;

import java.util.Scanner;

public class ChoiceABA { // Add Company and Details

    public void input_ABA(){ // Add Company and Details
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the company name: ");
        String name_comp=sc.nextLine();
        System.out.print("Enter the company's role: ");
        String role=sc.nextLine();
        System.out.print("Enter the company's package offer: ");
        double package_offer=sc.nextDouble();
        System.out.print("Enter the company's cgpa_req: ");
        double cgpa_req=sc.nextDouble();
        sc.nextLine();
        Company company=new Company(name_comp,role,package_offer,cgpa_req);
        Institute_Placement_Cell.add_company(company);  // here we have add company in the company records
        System.out.println();
        ChoiceAB cs_ab=new ChoiceAB();
        cs_ab.main();
    }
    public void main(){
        this.input_ABA();
    }
}
