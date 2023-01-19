package learnprogramming;

import java.util.HashMap;
import java.util.Scanner;

public class ChoiceAB {// Choose the company query to perform
    public void Choice_ab_1(){ // ADD COMPANY AND DETAILS
        //Here we have to add different companies before registering the company in the placement cell
        ChoiceABA cs_aba=new ChoiceABA();
        cs_aba.main();
    }
    public void Choice_ab_2(){ // Choose Company
        //Here we have entered into company portals after entering our details here is where we are going to register and all
        ChoiceABB cs_abb=new ChoiceABB();
        cs_abb.main();
    }
    public void Choice_ab_3(){ // Get Available Companies
        // AND PRINT ALL THE added companies ,they may or may not are registered.
        System.out.println();
        System.out.println("Available companies are: ");
        int i=1;
        for (HashMap.Entry<String,Company> entry : Institute_Placement_Cell.Add_company_record.entrySet()){
            System.out.println(i+") "+entry.getKey());
            i++;
        }
        System.out.println();
        main();
    }
    public void Choice_ab_4(){ //Back to Choice A
        System.out.println();
        ChoiceA cs_a=new ChoiceA();
        cs_a.main();
    }
    public void input_AB(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you choice: ");
        boolean hasNextInt=sc.hasNextInt();
        if(hasNextInt){
            int n=sc.nextInt();
            sc.nextLine();
            if(n==1){ // ADD COMPANY AND DETAILS
                Choice_ab_1();
            }
            else if(n==2){ // Choose Company
                Choice_ab_2();
            }
            else if(n==3){ // Get Available Companies
                Choice_ab_3();
            }
            else if(n==4){ //Back to Choice A
                Choice_ab_4();
            }
            else{
                System.out.println("Sorry,you entered an invalid value,choose again.");
                System.out.println();
                this.main();
            }
        }
        else{
            System.out.println("Sorry,you entered an invalid value,choose again.");
            System.out.println();
            this.main();
        }
    }
    public void main(){// Choose the company query to perform
        System.out.println("Choose the Company Query to perform-");
        System.out.println("   1) Add Company and Details");
        System.out.println("   2) Choose Company");
        System.out.println("   3) Get Available Companies");
        System.out.println("   4) Back");
        this.input_AB();
    }
}
