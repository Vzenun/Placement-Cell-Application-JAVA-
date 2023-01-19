package learnprogramming;

import java.util.Scanner;

public class ChoiceA {// Choice A is basically Enter the Application.
    public void Choice_a_1(){//Enter as Student Mode
        ChoiceAA cs_aa=new ChoiceAA();
        cs_aa.main();
    }
    public void Choice_a_2(){//Enter as Company Mode
        ChoiceAB cs_ab=new ChoiceAB();
        cs_ab.main();
    }
    public void Choice_a_3(){//Enter as Placement Cell Mode
        ChoiceAC cs_ac=new ChoiceAC();
        cs_ac.main();
    }
    public void Choice_a_4(){//Return To Main Application
        Main.main();
    }
    public void input_A(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you choice: ");
        boolean hasNextInt=sc.hasNextInt();
        if(hasNextInt){
            int n=sc.nextInt();//n is basically the choice number.
            sc.nextLine();
            System.out.println();
            if(n==1){//Enter as Student Mode
                Choice_a_1();
            }
            else if(n==2){//Enter as Company Mode
                Choice_a_2();
            }
            else if(n==3){//Enter as Placement Cell Mode
                Choice_a_3();
            }
            else if(n==4){//Return To Main Application
                Choice_a_4();
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
        sc.close();
    }
    public void main(){
        System.out.println("Choose The mode you want to Enter in:-");
        System.out.println("   1) Enter as Student Mode");
        System.out.println("   2) Enter as Company Mode");
        System.out.println("   3) Enter as Placement Cell Mode");
        System.out.println("   4) Return To Main Application");
        this.input_A();
    }
}
