package learnprogramming;

import java.util.Scanner;

public class ChoiceAA { //Enter as Student Mode
    public void Choice_aa_1(){ // Enter as a Student(Give Student Name, and Roll No.)
        //Basically here we are going as a student after adding our details and all
        //Before accessing this we need to first add student objects in added students.
        ChoiceAAA cs_aaa=new ChoiceAAA();
        cs_aaa.main();
        main();
    }
    public void Choice_aa_2(){ // Add students
        //Before registering we need to first add our details on the portal
        ChoiceAAB cs_aab=new ChoiceAAB();
        cs_aab.main();
        main();
    }

    public void Choice_aa_3(){ //Back to Choice A
        ChoiceA cs_a=new ChoiceA();
        cs_a.main();
    }
    public void input_AA(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you choice: ");
        boolean hasNextInt=sc.hasNextInt();
        if(hasNextInt){
            int n=sc.nextInt();
            sc.nextLine();
            if(n==1){ // Enter as a Student(Give Student Name, and Roll No.)
                Choice_aa_1();
            }
            else if(n==2){ // Add students
                Choice_aa_2();
            }
            else if(n==3){ //Back to Choice A
                Choice_aa_3();
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
    public void main(){// Enter as Student Mode
        System.out.println("Choose the Student Query to perform-");
        System.out.println("   1) Enter as a Student(Give Student Name, and Roll No.)");
        System.out.println("   2) Add students");
        System.out.println("   3) Back");
        this.input_AA();
    }
}
